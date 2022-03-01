package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.balance.modules.employee_management.entity.Dept;
import com.trkj.balance.modules.employee_management.entity.Staff;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.employee_management.vo.StaffVo;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.entity.CompensationDeptPost;
import com.trkj.balance.modules.salary_management.entity.CompensationStaff;
import com.trkj.balance.modules.salary_management.mapper.CompensationDeptPostMapper;
import com.trkj.balance.modules.salary_management.mapper.CompensationMapper;
import com.trkj.balance.modules.salary_management.mapper.CompensationStaffMapper;
import com.trkj.balance.modules.salary_management.mapper.DeptPostMapper;
import com.trkj.balance.modules.salary_management.service.CompensationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.salary_management.service.CompensationStaffService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 薪酬组表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-08
 */
@Service
public class CompensationServiceImpl extends ServiceImpl<CompensationMapper, Compensation> implements CompensationService {

    //薪酬组
    @Autowired
    private CompensationMapper compensationMapper;

    //薪酬组部门职位表
    @Autowired
    private CompensationDeptPostMapper compensationDeptPostMapper;

    // 薪酬组员工表
    @Autowired
    private CompensationStaffMapper compensationStaffMapper;

    //部门职位表
    @Autowired
    private DeptPostMapper deptPostMapper;

    // 员工表
    @Autowired
    private StaffMapper staffMapper;

    // 薪酬组员工中间表service
    @Autowired
    private CompensationStaffService compensationStaffService;

    // 新增薪酬组
    @Override
    @Transactional
    public int insertCompensation(Compensation compensation, ArrayList<Integer> deptIds,
                                  ArrayList<Integer> postIds, ArrayList<Integer> staffIds) {

        //添加薪酬组
        if (compensationMapper.insert(compensation) > 0) {
            // 声明一个实体类
            CompensationDeptPost compensationDeptPost = new CompensationDeptPost();
            //将新加的薪酬组id 作为薪酬组部门职位表的外键
            compensationDeptPost.setCompensationId(compensation.getCompensationId());

            // 申明一个员工id数据
            List<Integer> dp_staffIds = new ArrayList<>();

            // 使用双层for循环 按部门id和职位偶读查询部门职位中间表的id
            for (int i = 0; i < deptIds.size(); i++) { // 循环部门id
                for (int j = 0; j < postIds.size(); j++) { // 循环职位id
                    // 拿到部门id和职位id 去查询部门职位中间表的id
                    Long deptPostId = deptPostMapper.selectDeptPost(deptIds.get(i), postIds.get(j));
                    // 如果id为空 则 换下一个id继续查询
                    if (deptPostId == null) {
                        continue; // 结束此次循环，j++ 再次循环
                    }

                    // 按部门id和职位id查询员工表 id
                    QueryWrapper wrapper = new QueryWrapper<>();
                    wrapper.select("STAFF_ID").eq("DEPT_ID", deptIds.get(i));
                    wrapper.eq("POSITION_ID", postIds.get(j));
                    List<Map> empIds = staffMapper.selectMaps(wrapper);
                    for (Map map : empIds) {// 遍历map
                        dp_staffIds.add(Integer.valueOf(map.get("staffId").toString()));
                    }

                    // 将查询出来的部门职位中间表id，加入薪酬组部门职位中间表中
                    compensationDeptPost.setDeptPostId(deptPostId);
                    //添加薪酬组部门职位表
                    if (compensationDeptPostMapper.insert(compensationDeptPost) < 1) {
                        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                        // 手动回滚
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return 0;
                    }
                }
            }

            // 循环查询id是否重复
            for (int i = 0; i < dp_staffIds.size(); i++) {
                for (int j = 0; j < staffIds.size(); j++) {
                    // 如果重复
                    if (dp_staffIds.get(i).equals(staffIds.get(j))) {
                        // 按当前下标删除员工id
                        staffIds.remove(j);
                    }
                }
            }

            // 计算薪酬组人数
            compensation.setCompensationNumber((long) (dp_staffIds.size() + staffIds.size()));
            // 修改薪酬组人数
            compensationMapper.updateById(compensation);


            // 声明一个实体类
            CompensationStaff compensationStaff = new CompensationStaff();
            //将新加的薪酬组id 作为薪酬组员工表的外键
            compensationStaff.setCompensationId(compensation.getCompensationId());

            // 拿到员工id 查询 薪酬组员工中间表有无数据
            for (Integer staffId : staffIds) {

                QueryWrapper wrapper = new QueryWrapper<>();
                wrapper.eq("STAFF_ID", staffId);
                wrapper.eq("COMPENSATIONIS_ONE", 1);
                compensationStaffMapper.delete(wrapper);// 删除之前有的员工

                compensationStaff.setStaffId(Long.valueOf(staffId));//将id放入
                compensationStaff.setCompensationisOne(0L);// 单独员工放入

                // 如果查询到了
                if (compensationStaffMapper.insert(compensationStaff) < 1) {
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }

            // 声明一个id
            ArrayList<Integer> id = new ArrayList();
            // 部门职位员工
            for (Integer staffId : dp_staffIds) {
                compensationStaff.setStaffId(Long.valueOf(staffId));//将id放入
                compensationStaff.setCompensationisOne(1L);// 部门职位 员工放入

                id.clear();// 清空id数组
                id.add(staffId);// push当前id
                // 报错部门职位需要查询一遍，员工id如果有，就跳过添加
                if (compensationStaffService.selectCompensationStaffName(id) != null) continue;

                // 添加薪酬组员工中间表
                if (compensationStaffMapper.insert(compensationStaff) < 1 ) {
                    // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
                    // 手动回滚
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return 0;
                }
            }

        }
        // 执行完成，添加成功
        return 1;
    }

    //查询薪酬组名称
    @Override
    public List<Map<String, Object>> selectCompensationName() {
        QueryWrapper<Compensation> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("COMPENSATION_ID", "COMPENSATION_NAME");
        queryWrapper.eq("IS_DELETED", 0);
        return compensationMapper.selectMaps(queryWrapper);
    }

    //根据id查询薪酬组数据
    @Override
    public Compensation selectCompensationById(Long id) {
        return compensationMapper.selectById(id);
    }

    //修改薪酬组数据
    @Override
    public int updateCompensation(Compensation compensation) {
        return compensationMapper.updateById(compensation);
    }

    //根据薪酬组名称查询
    @Override
    public String selectCompensationNames(String name) {
        // 声明一个条件构造器
        QueryWrapper<Compensation> wrapper = new QueryWrapper<>();
        wrapper.eq("COMPENSATION_NAME", name);
        List<Compensation> compensations = compensationMapper.selectList(wrapper);
        // 有数据 返回薪酬组名称
        if (compensations.size() > 0) {
            return name;
        }

        return null;
    }

    //查询薪酬组
    @Override
    public IPage<Compensation> selectCompensationPage(IPage<Compensation> page) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("IS_DELETED", 0);

        return compensationMapper.selectPage(page, wrapper);
    }


    // 按薪酬组id查询部门id
    @Override
    public List<Integer> selectDeptId(int id) {
        List<Integer> insuredDeptPosts = compensationDeptPostMapper.selectinsuredDeptPostBydefInsuredId(id);

        if (insuredDeptPosts.size() == 0) {
            return null;
        }

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.in("DEPT_POST_ID", insuredDeptPosts);

        return deptPostMapper.selectDeptId(wrapper);
    }

    // 按薪酬组id查询职位id
    @Override
    public List<Integer> selectPostId(int id) {
        List<Integer> insuredDeptPosts = compensationDeptPostMapper.selectinsuredDeptPostBydefInsuredId(id);

        if (insuredDeptPosts.size() == 0) {
            return null;
        }

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.in("DEPT_POST_ID", insuredDeptPosts);

        return deptPostMapper.selectPostId(wrapper);
    }

    // 按薪酬组id查询员工
    @Override
    public List<Integer> selectStaffId(int id) {

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STAFF_ID").eq("COMPENSATION_ID", id);
        wrapper.eq("COMPENSATIONIS_ONE",0);// 状态为员工不是部门职位
        return compensationStaffMapper.selectList(wrapper);
    }


    //删除薪酬组
    @Override
    public int deleteCompensation(Long id) {
        return compensationMapper.deleteById(id);
    }
}

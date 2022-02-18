package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.attendance_management.vo.TravelVo;
import com.trkj.balance.modules.organization_management.entity.Dept;
import com.trkj.balance.modules.organization_management.entity.Staff;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import com.trkj.balance.modules.organization_management.mapper.Staff_DeptMapper;
import com.trkj.balance.modules.organization_management.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.organization_management.vo.DeptStaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-12
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {
    @Autowired
    public DeptMapper deptMapper;

    @Autowired
    public Staff_DeptMapper staff_deptMapper;

    //删除
    @Override
    public int deptdelete(Long id) {
        return deptMapper.deleteById(id);
    }

    //添加
    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    //修改
    @Override
    @Transactional //事务注解
    public int amend(Dept dept) {
        return deptMapper.updateById(dept);
    }

    //模糊搜索
    @Override
    public IPage<Dept> moss(int page, int size, String deptName) {
        Page<Dept> page1=new Page<>(page,size);
        QueryWrapper<Dept> wrapper=new QueryWrapper<>();
        wrapper.like("DEPT_NAME",deptName);
        IPage<Dept> n=deptMapper.selectPage(page1,wrapper);
        return n;
    }

    //查询员工
    @Override
    public IPage<DeptStaffVo> yg(int page, int pagesize,String staffName) {
        Page<DeptStaffVo> page1 = new Page<>(page,pagesize);
        QueryWrapper<DeptStaffVo> wrapper = new QueryWrapper<>();
        //员工姓名
        if (staffName!="" && staffName!=null){
            wrapper.like("a.STAFF_NAME",staffName);
        }
        return staff_deptMapper.yg(page1,wrapper);
    }



    /**
     * 获取所有分类
     * @return
     */
    @Override
    public List<Dept> queryList() {

//        ArrayList arr = new ArrayList<Object>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(4);
//
//        System.out.println("11111111111111111111111111");
//        System.out.println(arr);
//
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.in("DEPT_ID",arr);

        // 用boot获取分类数据   selectAll在springboot中是获取数据表里的所有数据
        List<Dept> data = deptMapper.selectList(null);
        //定义新的list
        List<Dept> deptpList = new ArrayList<>();
        //先找到所有的一级分类
        for(Dept dept : data){
            // 一级菜单的parentId是0
            if(dept.getDeptPid()+""!="" && dept.getDeptPid()!=null && dept.getDeptPid() == 1){
                deptpList.add(dept);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for(Dept dept : deptpList){
            dept.setChildren(getChilde(dept.getDeptId(), data));
        }
        return deptpList;
    }


    /**
     * 递归查找子菜单
     *
     * @param id 当前菜单id
     * @param rootList 要查找的列表
     * @return
     */
    private List<Dept> getChilde(Long id, List<Dept> rootList){
        //子级
        List<Dept> childList = new ArrayList<>();
        for(Dept dept : rootList){
            // 遍历所有节点，将父级id与传过来的id比较
            if(dept.getDeptPid()+""!="" && dept.getDeptPid()!=null && dept.getDeptPid().equals(id)){
                childList.add(dept);
            }
        }
        // 把子级的子级再循环一遍
        for(Dept dept : childList){
            if(dept.getDeptPid()+""!="" && dept.getDeptPid()!=null ){
                dept.setChildren(getChilde(dept.getDeptId(), rootList));
            }

        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }





}

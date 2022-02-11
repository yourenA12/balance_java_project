package com.trkj.balance.modules.organization_management.service.impl;

import com.trkj.balance.modules.organization_management.entity.Dept;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import com.trkj.balance.modules.organization_management.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.system_managementTest.entity.Deptp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int amend(Dept dept) {
        return deptMapper.updateById(dept);
    }


    @Override
    public List<Dept> queryList() {
        List<Dept> data = deptMapper.selectList(null);
        List<Dept> deptList = new ArrayList<>();
        for (Dept dept : data){
            if (dept.getDeptId()+""!="" && dept.getDeptId()!=null && dept.getDeptId() ==1){
                deptList.add(dept);
            }
        }
        for (Dept dept : deptList){
            dept.setChildren(getChilde(dept.getDeptId(),data));
        }
        return deptList;
    }


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

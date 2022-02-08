package com.trkj.balance.modules.salary_management.service.impl;

import com.trkj.balance.modules.salary_management.entity.Dept;
import com.trkj.balance.modules.salary_management.mapper.DeptSalaryMapper;
import com.trkj.balance.modules.salary_management.service.DeptSalaryService;
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
 * @author 林落。
 * @since 2022-02-08
 */
@Service
public class DeptSalaryServiceImpl extends ServiceImpl<DeptSalaryMapper, Dept> implements DeptSalaryService {
    @Autowired
    private DeptSalaryMapper deptMapper;


    @Override
    public List<Dept> queryList() {
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

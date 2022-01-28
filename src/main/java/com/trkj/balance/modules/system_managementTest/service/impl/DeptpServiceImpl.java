package com.trkj.balance.modules.system_managementTest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.system_managementTest.entity.Deptp;
import com.trkj.balance.modules.system_managementTest.mapper.DeptpMapper;
import com.trkj.balance.modules.system_managementTest.service.DeptpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-01-16
 */
@Service
public class DeptpServiceImpl extends ServiceImpl<DeptpMapper, Deptp> implements DeptpService {

    @Autowired
    private DeptpMapper deptpMapper;


    /**
     * 获取所有分类
     * @return
     */
    @Override
    public List<Deptp> queryList() {

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
        List<Deptp> data = deptpMapper.selectList(null);
        //定义新的list
        List<Deptp> deptpList = new ArrayList<>();
        //先找到所有的一级分类
        for(Deptp deptp : data){
            // 一级菜单的parentId是0
            if(deptp.getDeptPid()+""!="" && deptp.getDeptPid()!=null && deptp.getDeptPid() == 1){
                deptpList.add(deptp);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for(Deptp deptp : deptpList){
            deptp.setChildren(getChilde(deptp.getDeptId(), data));
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
    private List<Deptp> getChilde(Long id, List<Deptp> rootList){
        //子级
        List<Deptp> childList = new ArrayList<>();
        for(Deptp deptp : rootList){
            // 遍历所有节点，将父级id与传过来的id比较
            if(deptp.getDeptPid()+""!="" && deptp.getDeptPid()!=null && deptp.getDeptPid().equals(id)){
                childList.add(deptp);
            }
        }
        // 把子级的子级再循环一遍
        for(Deptp deptp : childList){
            if(deptp.getDeptPid()+""!="" && deptp.getDeptPid()!=null ){
                deptp.setChildren(getChilde(deptp.getDeptId(), rootList));
            }

        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }


}

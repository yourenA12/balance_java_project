package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.organization_management.mapper.PositionsMapper;
import com.trkj.balance.modules.organization_management.entity.DeptPost;
import com.trkj.balance.modules.organization_management.entity.Position;
import com.trkj.balance.modules.organization_management.mapper.DeptPoMapper;
import com.trkj.balance.modules.organization_management.service.DeptPoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * <p>
 * 部门职位中间表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-03-01
 */
@Service
public class DeptPoServiceImpl extends ServiceImpl<DeptPoMapper, DeptPost> implements DeptPoService {

    @Autowired
    private DeptPoMapper deptPostMapper;

    @Autowired
    private PositionsMapper postMapper;

    // 新增职位
    @Override
    @Transactional
    public int insert(Position post, ArrayList<Integer> deptIds) {

        // 如果职位id不为空，就删除当前职位再次新增
        if(post.getPositionId()!=null){
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("POSITION_ID",post.getPositionId());
            wrapper.like("POSITION_NAME",post.getPositionName());
            deptPostMapper.delete(wrapper);
        }

        // 新增职位
        postMapper.insert(post);

        // 声明部门职位中间表
        DeptPost deptPost = new DeptPost();
        deptPost.setPositionId(post.getPositionId());// 职位id

        // 循环部门id
        for (Integer deptId : deptIds) {

            deptPost.setDeptId(Long.valueOf(deptId));// 部门id
            deptPostMapper.insert(deptPost);// 添加部门职位中间表

        }

        return 1;
    }
}

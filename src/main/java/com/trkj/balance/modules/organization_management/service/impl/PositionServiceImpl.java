package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.entity.Position;
import com.trkj.balance.modules.organization_management.mapper.DeptMapper;
import com.trkj.balance.modules.organization_management.mapper.PositionsMapper;
import com.trkj.balance.modules.organization_management.mapper.PositionsVoMapper;
import com.trkj.balance.modules.organization_management.service.PositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.organization_management.vo.PositionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 职位表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-02-13
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionsMapper, Position> implements PositionService {

    @Autowired
    public PositionsMapper positionMapper;

    @Autowired
    public PositionsVoMapper positionsVoMapper;

    @Autowired
    public DeptMapper deptMapper;

    @Override
    public IPage<Position> selectPo(Page<Position> page) {

//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.like();

        // 查询所有职位
        IPage<Position> positionIPage = positionMapper.selectPage(page,null);
        //循环
        for (Position record : positionIPage.getRecords()) {
            // 按照职位id来查询所属部门
            List<PositionVo> positionVos = positionsVoMapper.selectPosition(record.getPositionId());

            // 声明一个部门idlist
            List<Integer> deptids=new ArrayList<>();
            // 声明一个部门名称list
            List<String> deptnames=new ArrayList<>();
            // 循环所查出来的 部门
            for (PositionVo positionVo : positionVos) {
                // 添加到 部门idlist
                deptids.add(Math.toIntExact(positionVo.getDeptId()));
                // 添加到 部门名称list
                deptnames.add(positionVo.getDeptName());
            }
            // 将部门id list 加入到实体类中的所属部门
            record.setDeptIds(deptids);
            // 将部门名称list 加入到实体类中的所属部门
            record.setDeptNames(deptnames);
        }

        return positionIPage;
    }

    //部门查询
    @Override
    public List<Map<Object, Object>> selectDept() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("DEPT_ID","DEPT_NAME");
        wrapper.eq("IS_DELETED",0);
        return deptMapper.selectMaps(wrapper);
    }
}

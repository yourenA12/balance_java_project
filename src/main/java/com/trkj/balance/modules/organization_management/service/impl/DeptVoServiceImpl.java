package com.trkj.balance.modules.organization_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.organization_management.mapper.DeptVoMapper;
import com.trkj.balance.modules.organization_management.service.DeptVoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.organization_management.vo.DeptVo;
import lombok.val;
import org.apache.ibatis.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 晚风
 * @since 2022-01-11
 */
@Service
public class DeptVoServiceImpl extends ServiceImpl<DeptVoMapper, DeptVo> implements DeptVoService {

    @Autowired
    private DeptVoMapper deptVoMapper;

    // 分页查询所有部门
    @Override
    public IPage<DeptVo> selectDeptVo(Page<DeptVo> page) {

        // 分页查询所有部门
        IPage<DeptVo> list = deptVoMapper.selectDeptVo(page);
        // 统计每个部门的人数
        List<Map<Long, Long>> maps = deptVoMapper.selectDeptNum();

        // 循环判断 所有部门
        for (DeptVo deptVo : list.getRecords()) {
            // 循环所有 人数
            for (Map<Long, Long> map : maps) {
                // 当人数不为空时
                // 转化类型
                String a = map.get("deptId") + "";
                // 转化类型
                String b = deptVo.getDeptId() + "";
                // 当循环出来的部门id 等于 每个部门的人数的部门id
                if (a.equals(b)) {
                    // 转化类型
                    String c = map.get("numbers") + "";
                    // 建当前部门的人数，放入实体类
                    deptVo.setEmpNum(Integer.parseInt(c));
                }
            }

        }
        return list;
    }


}

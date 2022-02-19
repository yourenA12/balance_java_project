package com.trkj.balance.modules.salary_management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.salary_management.entity.Business;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.mapper.BusinessMapper;
import com.trkj.balance.modules.salary_management.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 出差方案表 服务实现类
 * </p>
 *
 * @author 林落。
 * @since 2022-02-13
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    //新增出差方案
    @Override
    public int insertBusiness(Business business) {
        return businessMapper.insert(business);
    }

    //查询出差方案
    @Override
    public IPage<Business> selectBusiness(Page<Business> page) {
        return businessMapper.selectPage(page,null);
    }

    //修改出差方案状态
    @Override
    public int updateBusinessState(Business business) {
        return businessMapper.updateById(business);
    }

    //删除出差方案
    @Override
    public int deleteBusiness(Long id) {
        return businessMapper.deleteById(id);
    }

    //根据id查询出差信息
    @Override
    public Business selectBusinessId(Long id) {
        return businessMapper.selectById(id);
    }

    //修改出差信息
    @Override
    public int updateBusiness(Business business) {
        return businessMapper.updateById(business);
    }

    //查询出差方案名称
    @Override
    public List<Map<String, Object>> selectBusinessName() {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();

        queryWrapper.select("BUSINESS_ID","BUSINESS_NAME");
        queryWrapper.eq("IS_DELETED",0);
        return businessMapper.selectMaps(queryWrapper);
    }



}

package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.TransferVoMapper;
import com.trkj.balance.modules.examine_management.service.TranseferVoService;
import com.trkj.balance.modules.examine_management.vo.TransferVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferVoServicelmpl extends ServiceImpl<TransferVoMapper, TransferVo> implements TranseferVoService {
    @Autowired
    private TransferVoMapper transferVoMapper;

    //根据id 查询 人事异动
    @Override
    public List<TransferVo> findSelectTranseferById(Long id) {
        return transferVoMapper.findSelectTranseferById(id);
    }
}

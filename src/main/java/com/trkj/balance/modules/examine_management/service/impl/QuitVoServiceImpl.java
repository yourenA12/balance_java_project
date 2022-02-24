package com.trkj.balance.modules.examine_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trkj.balance.modules.examine_management.mapper.QuitVoMapper;
import com.trkj.balance.modules.examine_management.service.QuitVoService;
import com.trkj.balance.modules.examine_management.vo.QuitnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuitVoServiceImpl extends ServiceImpl<QuitVoMapper, QuitnVo> implements QuitVoService {
    @Autowired
    private QuitVoMapper quitVoMapper;

    //离职表实现类
    @Override
    public List<QuitnVo> findSelectById(Long id) {
        return quitVoMapper.findSelectById(id);
    }
}

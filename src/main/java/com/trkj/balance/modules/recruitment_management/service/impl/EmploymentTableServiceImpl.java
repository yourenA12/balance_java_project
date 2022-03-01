package com.trkj.balance.modules.recruitment_management.service.impl;



import com.trkj.balance.modules.recruitment_management.entity.EmploymentTable;
import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.trkj.balance.modules.recruitment_management.mapper.EmploymentsTableMapper;
import com.trkj.balance.modules.recruitment_management.mapper.ResumesMapper;
import com.trkj.balance.modules.recruitment_management.service.EmploymentTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 录用表 服务实现类
 * </p>
 *
 * @author 米西米西
 * @since 2022-03-01
 */
@Service
public class EmploymentTableServiceImpl extends ServiceImpl<EmploymentsTableMapper, EmploymentTable> implements EmploymentTableService {

    @Autowired
    private EmploymentsTableMapper employmentsTableMapper;

    @Autowired
    private ResumesMapper resumesMapper;

    //录用
    @Override
    @Transactional
    public int insertEmploymentTable(EmploymentTable employmentTable, Resume resume) {
        if(employmentsTableMapper.insert(employmentTable)>0){
            return resumesMapper.updateById(resume);
        }
       return 1;
    }
}

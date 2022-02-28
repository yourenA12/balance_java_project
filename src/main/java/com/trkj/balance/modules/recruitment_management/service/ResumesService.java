package com.trkj.balance.modules.recruitment_management.service;

import com.trkj.balance.modules.recruitment_management.entity.Resume;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 简历表 服务类
 * </p>
 *
 * @author 米西米西
 * @since 2022-02-24
 */
public interface ResumesService extends IService<Resume> {
    //修改状态
    int updateeliminate(Resume resume);
    //新简历转入淘汰库
    int updatexinjl(Resume resume);

}

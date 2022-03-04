package com.trkj.balance.modules.social_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import com.trkj.balance.modules.social_management.entity.InsuredDetail;
import com.trkj.balance.modules.social_management.service.InsuredDetailService;
import com.trkj.balance.modules.social_management.service.InsuredDetailVoService;
import com.trkj.balance.modules.social_management.vo.InsuredDetailVo;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 参保明细表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-02-28
 */
@Slf4j
@RestController
@RequestMapping("/insuredDetail")
public class InsuredDetailController {

    // 参保明细vo
    @Autowired
    private InsuredDetailVoService detailVoService;

    // 参保明细
    @Autowired
    private InsuredDetailService detailService;

    // 查询社保缴费明细
    @GetMapping("/selectInsuredDetail")
    public AjaxResponse selectInsuredDetail(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                            @RequestParam("staffNameSearch") String staffNameSearch,
                                            @RequestParam("deptIds") ArrayList deptIds,
                                            @RequestParam("stateSearch") String stateSearch,
                                            @RequestParam("scheme_name") String scheme_name,
                                            @RequestParam("date") String date){

        Page<InsuredDetailVo> page = new Page<>(currenPage,pagesize);
        IPage<InsuredDetailVo> list=detailVoService.selectInsuredDetail(page,staffNameSearch,deptIds,stateSearch,scheme_name,date);
        return AjaxResponse.success(list);

    }


    // 删除参保方案
    @DeleteMapping("/deleteInsuredAll/{ids}")
    public AjaxResponse deleteInsuredAll(@PathVariable("ids") ArrayList<Integer> ids){
        return AjaxResponse.success( detailService.deleteInsuredAll(ids) );
    }

    //查询参保明细
    @GetMapping("/selectDInsuredId/{id}/{date}")
    public AjaxResponse selectDInsuredId(@PathVariable("id") Long id,@PathVariable("date") String date){
        log.debug("1111111111");
        log.debug(id+"");
        log.debug(date);
        return AjaxResponse.success(detailVoService.selectInsuredDetailVo(id,date));
    }


    //根据id查询参保明细
    @GetMapping("/selectDInsuredbyId/{currenPage}/{pagesize}/{id}")
    public AjaxResponse selectDInsuredbyId(@PathVariable("currenPage") int currenPage, @PathVariable("pagesize") int pagesize, @PathVariable("id") Long id){

        Page<InsuredDetail> page = new Page<>(currenPage,pagesize);
        IPage<InsuredDetail> list=detailService.selectInsuredDetailPage(page,id);
        return AjaxResponse.success(list);

    }
}














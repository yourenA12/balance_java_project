package com.trkj.balance.modules.examine_management.controller;

import com.trkj.balance.modules.examine_management.service.OvertimeaskVoService;
import com.trkj.balance.modules.examine_management.service.QuitVoService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OvertimeaskVoController {
    @Autowired
    private OvertimeaskVoService overtimeaskVoService;

    // //加班详情
    @GetMapping("/OvertimeaskVoById/{id}")
    public AjaxResponse finSelectByid(@PathVariable("id")Long id){
        return AjaxResponse.success(overtimeaskVoService.findSelectByIdOvertimeask(id));
    }

}

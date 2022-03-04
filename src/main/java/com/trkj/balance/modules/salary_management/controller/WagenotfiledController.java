package com.trkj.balance.modules.salary_management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.entity.Education;
import com.trkj.balance.modules.salary_management.entity.Wagenotfiled;
import com.trkj.balance.modules.salary_management.service.WagenotfiledService;
import com.trkj.balance.modules.salary_management.vo.WagenotfiledVo;
import com.trkj.balance.modules.salary_management.entity.Compensation;
import com.trkj.balance.modules.salary_management.service.WagenotfiledVoService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 工资未归档表 前端控制器
 * </p>
 *
 * @author 林落。
 * @since 2022-03-02
 */
@RestController
@RequestMapping("/wagenotfiled")
public class WagenotfiledController {

    @Autowired
    private WagenotfiledVoService wagenotfiledVoService;

    @Autowired
    private WagenotfiledService wagenotfiledService;

    //查询未归档数据
    @GetMapping("/selectwagenotfiledVo")
    public AjaxResponse selectCompensation(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                           @RequestParam("seek") String seek){

        Page<WagenotfiledVo> page = new Page<>(currenPage,pagesize);
        IPage<WagenotfiledVo> list=wagenotfiledVoService.selectWagenotfiledVoPage(page,seek);
        return AjaxResponse.success(list);

    }

    //修改未归档未已归档
    @PutMapping("/updateWagenotfiledVo")
    public AjaxResponse updateWagenotfiledVo(@RequestBody Wagenotfiled wagenotfiled){
        return AjaxResponse.success(wagenotfiledService.updateWagenotfiledVo(wagenotfiled));
    }


    //查询归档数据
    @GetMapping("/selectwagenotfiledVos")
    public AjaxResponse selectwagenotfiledVos(@RequestParam("currenPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                              @RequestParam("seek") String seek){

        Page<WagenotfiledVo> page = new Page<>(currenPage,pagesize);
        IPage<WagenotfiledVo> list=wagenotfiledVoService.selectWagenotfiledVosPage(page,seek);
        return AjaxResponse.success(list);

    }


}


package com.trkj.balance.modules.social_management.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.balance.modules.employee_management.mapper.StaffMapper;
import com.trkj.balance.modules.social_management.entity.DefInsured;
import com.trkj.balance.modules.social_management.entity.DefScheme;
import com.trkj.balance.modules.social_management.service.DefInsuredService;
import com.trkj.balance.modules.social_management.service.InsuredDeptPostService;
import com.trkj.balance.modules.social_management.service.InsuredStaffService;
import com.trkj.balance.vo.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 默认参保方案表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-01-28
 */
@Slf4j
@RestController
@RequestMapping("/defInsured")
public class DefInsuredController {

    @Autowired
    private DefInsuredService defInsuredService;

    @Autowired
    private InsuredStaffService insuredStaffService;

    @Autowired
    private InsuredDeptPostService insuredDeptPostService;

    // 员工表
    @Autowired
    private StaffMapper staffMapper;

    @GetMapping("/aaa")
    public AjaxResponse aaa(){

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STAFF_ID").eq("DEPT_ID",0);
        wrapper.eq("POSITION_ID",0);
        List<Integer> aa = staffMapper.selectList(wrapper);
        log.error(aa.toString());
        log.debug("1111111111111");



        List<Map> bb = staffMapper.selectMaps(wrapper);
        log.error(bb.toString());
        log.debug("22222222222222");

        if(bb.size()>0){
            log.debug("xxxxxxxxxxxxxxxxxxxx");
        }

        for (Map map : bb) {
            log.debug( map.get("staffId") +"" );
        }

        return null;
    }

    // 查询所有参保方案
    @GetMapping("/selectAllPage")
    public AjaxResponse selectAllPage(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,
                                      @RequestParam("input") String name, @RequestParam("state") Object state){
        Page<DefInsured> page = new Page<>(currenPage,pagesize);
        IPage<DefInsured> list = defInsuredService.selectAllPage(page,name,state);
        return AjaxResponse.success(list);
    }

    // 修改参保方案状态
    @PutMapping("/updateDefInsuredState")
    public AjaxResponse updateDefInsuredState(@RequestBody DefInsured defInsured){
        return AjaxResponse.success( defInsuredService.updateDefInsuredState(defInsured) );
    }

    // 删除参保方案
    @DeleteMapping("/deleteDefInsured/{id}")
    public AjaxResponse deleteDefInsured(@PathVariable("id") int id){
        return AjaxResponse.success(defInsuredService.deleteDefInsured(id));
    }

    // 新增参保方案
    @PostMapping("/insertDefInsured")
    public AjaxResponse insertDefInsured(@RequestBody Map<Object, Object> map){

        // 默认参保方案
        DefInsured defInsured = JSON.parseObject(JSON.toJSONString(map.get("defInsured")), DefInsured.class);
        // 社保方案
        List<DefScheme> defScheme1 = JSON.parseArray(JSON.toJSONString(map.get("defScheme1")), DefScheme.class);
        // 公积金方案
        List<DefScheme> defScheme2 = JSON.parseArray(JSON.toJSONString(map.get("defScheme2")), DefScheme.class);
        // 基数上限
        int upper = JSON.parseObject(JSON.toJSONString(map.get("upper")), Integer.class);
        // 基数下限
        int lower = JSON.parseObject(JSON.toJSONString(map.get("lower")), Integer.class);

        List<Integer> deptIds = JSON.parseArray(JSON.toJSONString(map.get("deptIds")), Integer.class);
        List<Integer> postIds = JSON.parseArray(JSON.toJSONString(map.get("postIds")), Integer.class);
        List<Integer> staffIds = JSON.parseArray(JSON.toJSONString(map.get("staffIds")), Integer.class);

        for (DefScheme defScheme : defScheme2) {
            defScheme1.add(defScheme);
        }

        log.debug("1111111111111111111");

        log.debug(defInsured.toString());

        log.debug(defScheme1.toString());

        log.debug(defScheme2.toString());

        log.debug(upper+"");

        log.debug(lower+"");

        log.debug(deptIds.toString());

        log.debug(postIds.toString());

        log.debug(staffIds.toString());

        // 判断删除
        if(defInsured.getDefInsuredId()+""!="" && defInsured.getDefInsuredId()!=null){
            if( defInsuredService.deleteDefInsured(Math.toIntExact(defInsured.getDefInsuredId()))<1){
                return AjaxResponse.success("出错了，请稍后再试");
            }
        }

        String a=defInsuredService.selectDefInsuredNames(defInsured.getDefInsuredName());
        if(a!=null) return AjaxResponse.success(a+",重复");

        String b=insuredStaffService.selectInsuredStaffName(staffIds);
        if(b!=null) return AjaxResponse.success(b+",已设置参保方案");

        String c=insuredDeptPostService.selectInsuredDeptPost(deptIds,postIds);
        if(c!=null) return AjaxResponse.success(c+",已设置参保方案");

        return AjaxResponse.success(defInsuredService.insertDefInsured(defInsured,defScheme1,upper,lower,deptIds,postIds,staffIds) >0?"添加成功":"添加失败");
    }


    // 按参保方案id查询参保方案
    @GetMapping("/selectDefInsuredById/{id}")
    public AjaxResponse selectDefInsuredById(@PathVariable("id") int id){

        return AjaxResponse.success(defInsuredService.selectDefInsuredById(id));
    }

    // 按参保方案id查询方案
    @GetMapping("/selectDefSchemeById/{id}")
    public AjaxResponse selectDefSchemeById(@PathVariable("id") int id){
        return AjaxResponse.success(defInsuredService.selectDefSchemeById(id));
    }

    // 按参保方案id查询部门id
    @GetMapping("/selectDeptId/{id}")
    public AjaxResponse selectDeptId(@PathVariable("id") int id){
        return AjaxResponse.success(defInsuredService.selectDeptId(id));
    }

    // 按参保方案id查询职位id
    @GetMapping("/selectPostId/{id}")
    public AjaxResponse selectPostId(@PathVariable("id") int id){
        return AjaxResponse.success(defInsuredService.selectPostId(id));
    }

    // 按参保方案id查询员工
    @GetMapping("/selectStaffId/{id}")
    public AjaxResponse selectStaffId(@PathVariable("id") int id){
        return AjaxResponse.success(defInsuredService.selectStaffId(id));
    }


}


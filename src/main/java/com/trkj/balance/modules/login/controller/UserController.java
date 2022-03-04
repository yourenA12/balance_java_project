package com.trkj.balance.modules.login.controller;


import com.trkj.balance.modules.login.entity.Staff;
import com.trkj.balance.modules.login.service.UserService;
import com.trkj.balance.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author 友人A
 * @since 2022-03-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    // 员工
    @Autowired
    private UserService userService;

    // 登录
    @PostMapping("/toLogin")
    public AjaxResponse toLogin(@RequestBody Staff staff){
        return AjaxResponse.success(userService.toLogin(staff));
    }

    // 修改密码
    @PostMapping("/changePass")
    public AjaxResponse changePass(@RequestBody Staff staff){
        return AjaxResponse.success(userService.changePass(staff));
    }

}


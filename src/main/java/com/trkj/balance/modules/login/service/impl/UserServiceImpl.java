package com.trkj.balance.modules.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.balance.modules.login.entity.Staff;
import com.trkj.balance.modules.login.mapper.UserMapper;
import com.trkj.balance.modules.login.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author 友人A
 * @since 2022-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Staff> implements UserService {

    // 员工
    @Autowired
    private UserMapper userMapper;

    // 密码加密
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 登录
    @Override
    public Staff toLogin(Staff staff) {

        // 按照员工手机号查询员工数据
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("STAFF_PHONE",staff.getStaffPhone());
        Staff staff1 = userMapper.selectOne(wrapper);

        // 如果查询为空 则返回空
        if(staff1==null) return null;

//        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

//        String encode = passwordEncoder.encode(staff.getStaffPass()); // 加密
//        System.out.println("1222222222222222");
//        System.out.println(encode);

        boolean rusult = passwordEncoder.matches(staff.getStaffPass(),staff1.getStaffPass());// 解密

        if(rusult){
            staff1.setStaffPass("******");
            return staff1;
        }

        return null;
    }

    // 修改密码
    @Override
    public int changePass(Staff staff){

        String encode = passwordEncoder.encode(staff.getStaffPass()); // 加密
        staff.setStaffPass(encode);// 加密后的密码
        return userMapper.updateById(staff);// 按id修改

    }
}

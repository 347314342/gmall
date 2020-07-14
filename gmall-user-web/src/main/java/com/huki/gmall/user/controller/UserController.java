package com.huki.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.huki.gmall.bean.UmsMember;
import com.huki.gmall.bean.UmsMemberReceiveAddress;
import com.huki.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {


    @Reference
    UserService userService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return "hello";
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser()
    {
        List<UmsMember> umsMembers =userService.getAllUser();
        return umsMembers;
    }

    @RequestMapping("getReceiveAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId)
    {
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses =userService.getReceiveAddressByMemberId(memberId);
        return umsMemberReceiveAddresses;
    }
}

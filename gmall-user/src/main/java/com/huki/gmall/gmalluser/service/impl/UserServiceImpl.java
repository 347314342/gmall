package com.huki.gmall.gmalluser.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huki.gmall.bean.UmsMember;
import com.huki.gmall.bean.UmsMemberReceiveAddress;
import com.huki.gmall.gmalluser.mapper.UmsMemberReceiveAddressMapper;
import com.huki.gmall.gmalluser.mapper.UserMapper;
import com.huki.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //@Qualifier("UserMapper")
    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        //List<UmsMember> umsMembers =userMapper.selectAllUser();
        List<com.huki.gmall.bean.UmsMember> umsMembers=userMapper.selectAll();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
//        Example example = new Example(UmsMemberReceiveAddress.class);
//        example.createCriteria().andEqualTo("memberId",memberId);
//        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(example);

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses =umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        return umsMemberReceiveAddresses;
    }


}

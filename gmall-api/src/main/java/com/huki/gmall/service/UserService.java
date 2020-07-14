package com.huki.gmall.service;

import com.huki.gmall.bean.UmsMember;
import com.huki.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;


public interface UserService {


    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}

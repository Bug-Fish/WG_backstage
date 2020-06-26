package com.epi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.epi.entity.UserMember;
import com.epi.entity.vo.RegisterVo;

public interface UserMemberService extends IService<UserMember> {
    String login(UserMember userMember);

    void register(RegisterVo registerVo);
}

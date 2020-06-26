package com.epi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.epi.entity.UserMember;
import com.epi.entity.vo.RegisterVo;
import com.epi.handler.EpiException;
import com.epi.mapper.UserMemberMapper;
import com.epi.service.UserMemberService;
import com.epi.util.JwtUtils;
import com.epi.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserMemberServiceImpl extends ServiceImpl<UserMemberMapper, UserMember> implements UserMemberService {
    @Autowired
    UserMemberMapper userMemberMapper;

    @Override
    public String login(UserMember userMember) {
        String mobile = userMember.getMobile();
        String password = userMember.getPassword();
        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            throw new EpiException(20001,"登录信息不完整，登录失败！");
        }
        QueryWrapper<UserMember> wrapper=new QueryWrapper<>();
        wrapper.eq("mobile",mobile);

        UserMember mobileMember = baseMapper.selectOne(wrapper);
        if (mobileMember==null){
            throw new EpiException(20001,"手机号不存在！");
        }
        //if (!password.equals(mobileMember.getPassword())){
        if (!MD5.encrypt(password).equals(mobileMember.getPassword())){
            throw new EpiException(20001,"密码错误！");
        }
        if (mobileMember.getIsDisabled()){
            throw new EpiException(20001,"用户已被禁用！");
        }

        String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());

        return jwtToken;
    }

    @Override
    public void register(RegisterVo registerVo) {
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String password = registerVo.getPassword();
        String nickname = registerVo.getNickname();
        if (StringUtils.isEmpty(code)||StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)||StringUtils.isEmpty(nickname))
            throw new EpiException(20001,"注册信息不完整，注册失败！");

        QueryWrapper<UserMember> wrapper=new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Integer count = baseMapper.selectCount(wrapper);
        if (count>0){
            throw new EpiException(20001,"该手机号码已被注册！");
        }
        UserMember member=new UserMember();
        member.setMobile(mobile);
        member.setNickname(mobile);
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
        member.setAvatar("https://wx3.sinaimg.cn/mw690/634fd979ly1gfk38l3lhij24mo2m3b2b.jpg");
        baseMapper.insert(member);

    }
}

package com.epi.controller;

import com.epi.entity.UserMember;
import com.epi.entity.vo.RegisterVo;
import com.epi.service.UserMemberService;
import com.epi.util.JwtUtils;
import com.epi.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/epi")
@CrossOrigin
public class UserMemberController {
    @Autowired
    private UserMemberService userMemberService;
    @PostMapping("login")
    public R loginUser(@RequestBody UserMember userMember){
        String token=userMemberService.login(userMember);
        return R.ok().data("token",token);
    }

    @PostMapping("register")
    public R loginUser(@RequestBody RegisterVo registerVo){
        userMemberService.register(registerVo);
        return R.ok();
    }

    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request){
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        UserMember member = userMemberService.getById(memberId);
        return R.ok().data("userInfo",member);

    }
}

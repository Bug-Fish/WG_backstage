package com.epi.controller;

import com.epi.service.MsmService;
import com.epi.util.R;
import com.epi.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/epi")
@CrossOrigin
public class MsmController {
    @Autowired
    private MsmService msmService;

    @GetMapping("send/{phone}")
    public R sendMsm(@PathVariable String phone){
        String code= RandomUtil.getFourBitRandom();
        Map<String,Object> param=new HashMap<>();
        param.put("code",code);
        boolean isSend=msmService.send(param,phone);
        if (isSend==true){
            return R.ok();
        }else {
            return R.error().message("短信发送失败!");
        }
    }
}

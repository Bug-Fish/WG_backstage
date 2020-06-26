package com.epi.controller;

import com.epi.service.SenService;
import com.epi.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/epi")
public class SenController {
    @Autowired
    private SenService senService;
    @GetMapping("/sense")
    private R drawSense(){
        Map<String,Object> map = senService.getSense();

        return R.ok().data(map);
    }

}

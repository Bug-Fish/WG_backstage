package com.epi.controller;

import com.epi.entity.EpiGeneral;
import com.epi.service.GenService;
import com.epi.service.KmaskService;
import com.epi.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/epi")
public class KeyController {
    @Autowired
    private KmaskService kmaskService;
    @GetMapping("/keymaskDraw/{province}/{month}")
    private R keymaskDraw(@PathVariable String province,
                          @PathVariable String month){

        Map<String,Object> map = kmaskService.getData(province,month);

        return R.ok().data(map);

    }
}

package com.epi.controller;

import com.epi.util.R;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/wg/user")
public class WgLoginController {
    @PostMapping("login")
    public R login(){

        return R.ok().data("token","admin");
    }
    @GetMapping("info")
    public R info(){

        return R.ok().data("roles","渣渣育").data("name","education").data("avatar","https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
    }

}

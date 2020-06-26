package com.epi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.epi.entity.EpiGeneral;
import com.epi.entity.vo.GenQuery;
import com.epi.handler.EpiException;
import com.epi.service.GenService;
import com.epi.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/epi")
public class GeneralController {
    @Autowired
    private GenService genService;
//    @Autowired
//    private VoService voService;
    //    @GetMapping("/test/{id}")
//    private List<Test> query(@PathVariable Long id){
//        List<Test> testList=testService.findAll(id);
//        return testList;
//    }
    @GetMapping("/test")
    private R get(){
        List<EpiGeneral> epiGeneralList =genService.findAll();
//        try {
//            int i=131/0;
//        }catch (Exception e){
//            throw new EpiException(20001,"执行了自定义异常……");
//        }
        //Page<Test> query=testService.findProNoCriteria(current, limit);
        return R.ok().data("items", epiGeneralList);

    }
    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id){
        genService.removeById(id);

        //Page<Test> query=testService.findProNoCriteria(current, limit);
        //return R.ok().data("items", epiGeneralList);
    }
    @GetMapping("/pageGen/{current}/{limit}")
    private R pageListGen(@PathVariable long current,
                          @PathVariable long limit){
        Page<EpiGeneral> page=new Page<>(current,limit);
        genService.page(page,null);
        long total = page.getTotal();
        List<EpiGeneral> records = page.getRecords();

        return R.ok().data("total",total).data("record",records);
    }
    //条件查询带分页
    @PostMapping("/pageGenCondition/{current}/{limit}")
    private R pageListGenCon(@PathVariable long current,
                             @PathVariable long limit,
                             @RequestBody(required = false) GenQuery genQuery){
        Page<EpiGeneral> page=new Page<>(current,limit);
        QueryWrapper<EpiGeneral> queryWrapper=new QueryWrapper<>();
        long cue = genQuery.getCue();
        long dead = genQuery.getDead();
        long now = genQuery.getNow();
        long sum = genQuery.getSum();
        String provinceName = genQuery.getProvinceName();
        if (!StringUtils.isEmpty(provinceName)){
            queryWrapper.like("province_name",provinceName);
        }
        if (!StringUtils.isEmpty(cue)){
            queryWrapper.ge("cue",cue);
        }
        if (!StringUtils.isEmpty(dead)){
            queryWrapper.ge("dead",dead);
        }
        if (!StringUtils.isEmpty(now)){
            queryWrapper.ge("now",now);
        }
        if (!StringUtils.isEmpty(sum)){
            queryWrapper.ge("sum",sum);
        }
        genService.page(page,queryWrapper);
        long total = page.getTotal();
        List<EpiGeneral> records = page.getRecords();

        return R.ok().data("total",total).data("record",records);
    }
    @PostMapping("/addGen")
    private R addGen(@RequestBody EpiGeneral epiGeneral){
        boolean save = genService.save(epiGeneral);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }

    }

    //修改
    @GetMapping("/getGen/{id}")
    private R getGen(@PathVariable long id){
        EpiGeneral epiGeneral = genService.getById(id);
        return R.ok().data("general",epiGeneral);
    }
    @PostMapping("/modifyGen")
    private R modifyGen(@RequestBody EpiGeneral epiGeneral){
        boolean b = genService.updateById(epiGeneral);
        if (b){
            return R.ok();
        }else {
            return R.error();
        }
    }




//    @GetMapping("/datavo")
//    private DataVo dataVo(){
//        DataVo dataVos= voService.findAll();
//        return dataVos;
//    }
}

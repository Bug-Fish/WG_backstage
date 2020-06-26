package com.epi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.epi.entity.SenAna;
import com.epi.mapper.SenMapper;
import com.epi.service.SenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SenServiceImpl extends ServiceImpl<SenMapper, SenAna> implements SenService {
    @Autowired
    private SenMapper senMapper;
    @Override
    public Map<String, Object> getSense() {
        QueryWrapper<SenAna> wrapper=new QueryWrapper<>();
        wrapper.select("sum_jan","sum_feb","sum_mar","sum_apr","sum_may");
        List<SenAna> all=senMapper.selectList(wrapper);
        Map<String, Object> map=new HashMap<>();
        map.put("all",all);
        return map;
    }
}

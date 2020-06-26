package com.epi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.epi.entity.EpiGeneral;
import com.epi.mapper.GeneralMapper;
import com.epi.service.GenService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenServiceImpl extends ServiceImpl<GeneralMapper,EpiGeneral> implements GenService {
    @Autowired
    GeneralMapper generalMapper;

    //@Cacheable(key = "'findAllInfo'",value = "cache")
    @Override
    public List<EpiGeneral> findAll() {
        List<EpiGeneral> all=generalMapper.selectList(null);
        return all;
    }

    @Override
    public void addEpi() {
        EpiGeneral epiGeneral=new EpiGeneral();
        epiGeneral.setCue((long)21);
        epiGeneral.setDead((long)8997);
        epiGeneral.setDead((long) 6799);
        epiGeneral.setNow((long)69797);
        epiGeneral.setProvinceName("日本");
        int insert=generalMapper.insert(epiGeneral);
    }

    @Override
    public void modify() {
        EpiGeneral epiGeneral=new EpiGeneral();
        epiGeneral.setId(64);
        epiGeneral.setSum(23424);
        val rows = generalMapper.updateById(epiGeneral);

    }


}

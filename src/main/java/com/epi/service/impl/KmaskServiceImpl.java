package com.epi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.epi.entity.EpiGeneral;
import com.epi.entity.KeyMask;
import com.epi.mapper.GeneralMapper;
import com.epi.mapper.KmaskMapper;
import com.epi.service.KmaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KmaskServiceImpl extends ServiceImpl<KmaskMapper, KeyMask> implements KmaskService {
    @Autowired
    KmaskMapper kmaskMapper;

    @Override
    public List<KeyMask> findAll() {
        List<KeyMask> all=kmaskMapper.selectList(null);
        return all;
    }

    @Override
    public Map<String, Object> getData(String province, String month) {
        QueryWrapper<KeyMask> wrapper=new QueryWrapper<>();
        wrapper.select("province_name",month);
        List<KeyMask> keyMasks = baseMapper.selectList(wrapper);
        //返回两部分List集合
        List<String> provinceList=new ArrayList<>();
        List<Long> numList=new ArrayList<>();

        for (int i = 0; i < keyMasks.size(); i++) {
            KeyMask keyMask=keyMasks.get(i);
            provinceList.add(keyMask.getProvinceName());
            switch (month){
                case "maskfre_jan":
                    numList.add(keyMask.getMaskfreJan());
                    break;
                case "maskfre_feb":
                    numList.add(keyMask.getMaskfreFeb());
                    break;
                case "maskfre_mar":
                    numList.add(keyMask.getMaskfreMar());
                    break;
                case "maskfre_apr":
                    numList.add(keyMask.getMaskfreApr());
                    break;
                case "maskfre_may":
                    numList.add(keyMask.getMaskfreMay());
                    break;
                case "maskfre_sum":
                    numList.add(keyMask.getMaskfreSum());
                    break;
                default:
                    break;

            }

        }
        Map<String, Object> map=new HashMap<>();
        map.put("provinceList",provinceList);
        map.put("numList",numList);

        return map;
    }
}

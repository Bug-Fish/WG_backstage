package com.epi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.epi.entity.KeyMask;

import java.util.List;
import java.util.Map;

public interface KmaskService extends IService<KeyMask> {
    List<KeyMask> findAll();

    Map<String, Object> getData(String province, String month);
}

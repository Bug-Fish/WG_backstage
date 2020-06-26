package com.epi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.epi.entity.SenAna;

import java.util.Map;

public interface SenService extends IService<SenAna> {
    Map<String, Object> getSense();
}

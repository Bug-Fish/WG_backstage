package com.epi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.epi.entity.EpiGeneral;

import java.util.List;

public interface GenService extends IService<EpiGeneral> {
    List<EpiGeneral> findAll();
    void addEpi();
    void modify();
}

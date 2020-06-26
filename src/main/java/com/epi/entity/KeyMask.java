package com.epi.entity;

import lombok.Data;

@Data
public class KeyMask {
    private long id;
    private String provinceName;
    private long maskfreJan;
    private long maskfreFeb;
    private long maskfreMar;
    private long maskfreApr;
    private long maskfreMay;
    private long maskfreSum;
}

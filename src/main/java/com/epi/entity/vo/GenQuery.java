package com.epi.entity.vo;

import lombok.Data;

@Data
public class GenQuery {
    private long now;
    private long sum;
    private long cue;
    private long dead;
    private String provinceName;
}

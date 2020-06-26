package com.epi.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpiException extends RuntimeException{
    private Integer code;
    private String msg;
}

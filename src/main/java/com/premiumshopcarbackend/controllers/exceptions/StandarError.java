package com.premiumshopcarbackend.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandarError implements Serializable {
    public final long serialSerialUID = 1L;

    private String msg;

    private Integer statusHttp;

    private Long timeStamp;

}

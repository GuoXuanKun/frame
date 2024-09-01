package com.xenon.exceptions;


import com.xenon.exceptions.enumeration.ResponseEnum;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private ResponseEnum response;

    public BusinessException(ResponseEnum response){
        this.response = response;
    }

}

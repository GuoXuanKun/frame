package com.xenon.common;



import com.xenon.exceptions.enumeration.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wuyunbin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T data;

    public static Result<Object> success() {
        return success(null);
    }

    public static <T> Result<T> success(T t) {
        return success(ResponseEnum.SUCCESS, t);
    }

    public static <T> Result<T> success(ResponseEnum response, T t) {
        Result<T> result = new Result<>();
        result.success = true;
        result.code = response.getCode();
        result.message = response.getMessage();
        result.data = t;
        return result;
    }

    public static <T> Result<T> error(ResponseEnum response) {
        return error(response, null);
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.success = false;
        result.code = -1;
        result.message = message;
        result.data = null;
        return result;
    }


    public static <T> Result<T> error(ResponseEnum response, T t) {
        Result<T> result = new Result<>();
        result.success = false;
        result.code = response.getCode();
        result.message = response.getMessage();
        result.data = t;
        return result;
    }
}
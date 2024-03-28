package com.code.server.utils;

import com.code.server.constant.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ProsperousEnding-fhl
 * @create 2023-07-20-15:16
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息体")
public class ResultUtils<T> implements Serializable {

    /**
     * 响应码
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "响应标记：成功标记=0,失败1")
    private Integer code;

    /**
     * 响应信息
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "响应信息")
    private String message;

    /**
     * 响应数据
     */
    @Getter
    @Setter
    @ApiModelProperty(value = "响应数据")
    private T data;


    @Getter
    @Setter
    @ApiModelProperty(value = "返回状态")
    private boolean status;


    private ResultUtils(ResultCode resultCode, T data, boolean status) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
        this.status = status;
    }

    /**
     * 无数据成功返回
     *
     * @return
     */
    public static <T> ResultUtils success() {
        return new ResultUtils<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null, true);
    }

    /**
     * 带数据返回
     */
    public static <T> ResultUtils success(T data) {
        return new ResultUtils<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data, true);
    }

    /**
     * 失败
     */
    public static <T> ResultUtils fail() {
        return new ResultUtils<T>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), null, false);
    }

    /**
     * 失败
     */
    public static <T> ResultUtils fail(T data) {
        return new ResultUtils<T>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), data, false);
    }


    @Override
    public String toString() {
        return "ResultUtils [code=" + code + ", message=" + message + ", data=" + data + "]";
    }
}

package com.qhy.goods.dto;

import cn.hutool.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 统一返回结构
 *
 * @author qhy
 * @date 2021/12/28 17:52
 */
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> {

    @Schema(description = "状态码")
    private int code;
    @Schema(description = "消息")
    private String msg;
    @Schema(description = "数据")
    private T data;

    public static R<?> ok(int code, String msg, Object data) {
        return new R<>(code, msg, data);
    }

    public static R<?> error(int code, String msg, Object data) {
        return new R<>(code, msg, data);
    }


    public static R<?> ok(int code, String msg) {
        return ok(code, msg, null);
    }

    public static R<?> ok(String msg) {
        return ok(HttpStatus.HTTP_OK, msg, null);
    }

    public static R<?> ok(Object data) {
        return ok(HttpStatus.HTTP_OK, "操作成功", data);
    }

    public static R<?> error(int code, String msg) {
        return error(code, msg, null);
    }

    public static R<?> error(String msg) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, msg, null);
    }


    public static R<?> error(Object data) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, "操作失败", data);
    }
}

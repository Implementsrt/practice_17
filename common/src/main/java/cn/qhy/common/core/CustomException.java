// +----------------------------------------------------------------------
// | JavaWeb_Vue_Pro前后端分离旗舰版框架 [ JavaWeb ]
// +----------------------------------------------------------------------
// | 版权所有 2019~2020 南京JavaWeb研发中心
// +----------------------------------------------------------------------
// | 官方网站: http://www.javaweb.vip/
// +----------------------------------------------------------------------
// | 作者: 深圳汉云 <1175401194@qq.com>
// +----------------------------------------------------------------------

package cn.qhy.common.core;

import cn.hutool.http.HttpStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 自定义异常类
 *
 * @author null
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {

    private Integer code = HttpStatus.HTTP_INTERNAL_ERROR;

    private String message;

    public static CustomException msg(String message) {
        return new CustomException().setMessage(message);
    }

    public static CustomException codeMsg(int code, String message) {
        return new CustomException().setCode(code).setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

}

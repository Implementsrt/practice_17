package cn.qhy.common.util;


import cn.qhy.common.core.CustomException;

/**
 * @author qhy
 * @date 2021/12/29 16:06
 */
public class AssertUtil {

    public static void isTrue(boolean flag, String tips) {
        if (flag) {
            throw CustomException.msg(tips);
        }
    }

    public static void isTrue(boolean flag, int code, String tips) {
        if (flag) {
            throw CustomException.codeMsg(code, tips);
        }
    }

    public static void isNull(Object obj, String tips) {
        if (null == obj) {
            throw CustomException.msg(tips);
        }
    }
}

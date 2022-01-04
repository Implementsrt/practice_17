package cn.qhy.common.core;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qhy
 * @date 2021/12/29 15:34
 */
public class BaseController<S> {

    // 不知道从哪里有一个类继承了这个类，泛型为Object，MD等我有空了就搞定它

    @Autowired(required = false)
    protected S baseService;

}

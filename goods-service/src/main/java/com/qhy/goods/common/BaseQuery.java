package com.qhy.goods.common;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

/**
 * @author qhy
 * @date 2021/12/30 9:58
 */
@Data
public class BaseQuery {

    /*
     * page helper已经做了自动处理，只要mapper的参数中包含这个两个名称的属性不为空时，自动开始分页
     * 或者使用params配置项配置为对应的属性名称即可
     */

    @Hidden
    private Integer pageNum;
    @Hidden
    private Integer pageSize;

}

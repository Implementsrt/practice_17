package com.qhy.goods.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author qhy
 * @date 2021/12/28 17:24
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;

}

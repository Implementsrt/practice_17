package com.qhy.goods.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private LocalDateTime gmtCreate;

    @JsonIgnore
    private LocalDateTime gmtUpdate;

}

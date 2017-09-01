package com.glorystone.prod.model.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangwei on 2017/8/21.
 */
public @Getter @Setter class BaseModel implements Serializable {

    private Long tid;
    private Long createBy;
    private Long updateBy;
    private Date createAt;
    private Date updateAt;
    private Integer deleteFlag;

    public enum DeleteFlagEnum {
        NORMAL(0), DELETED(1);

        private Integer value;
        DeleteFlagEnum(int value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }
    }
}

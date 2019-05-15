package com.luo.imall.web.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author L99
 * @createDate 2019/4/16
 *
 */
@Data
@NoArgsConstructor
public class Page {
    private static final long serialVersionUID = 1L;

    /**
     *  偏移量
     */
    private Integer offset;

    /**
     * 当前页面条数
     */
    private Integer pageSize;

    /**
     * 页面起始
     * offset * pageSize
     */
    private Integer pageStart;

    public Page(Integer offset, Integer pageSize) {
        this.offset = offset;
        this.pageSize = pageSize;
        this.pageStart = offset * pageSize;
    }

    public Page(Integer offset, Integer pageSize, Integer pageStart) {
        this(offset, pageSize);
    }
}

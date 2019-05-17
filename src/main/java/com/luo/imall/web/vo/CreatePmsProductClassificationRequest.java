package com.luo.imall.web.vo;

import com.luo.imall.web.entity.PmsProductClassification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商品分类请求对象
 * @author L99
 * @createDate 2019/5/17
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePmsProductClassificationRequest {

    /** 分类id */
    private Long id;

    /** 分类名称 */
    private String name;

    /** 上级类别的 id */
    private Long parentId;

    /** 上级类别的名称*/
    private String parentName;

    /**
     * 将 CreatePmsProductClassificationRequest 对象转化为 PmsProductClassification 对象
     * @return
     */
    private PmsProductClassification toPmsProductClassification(){
        PmsProductClassification pmsProductClassification = new PmsProductClassification();
        pmsProductClassification.setId(id);
        pmsProductClassification.setName(name);
        pmsProductClassification.setParentId(parentId);
        pmsProductClassification.setParentName(parentName);
        return pmsProductClassification;
    }
}

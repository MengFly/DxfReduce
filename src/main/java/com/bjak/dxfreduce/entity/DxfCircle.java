package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector3;
import com.bjak.dxfreduce.entity.base.BaseDxfEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 圆
 *
 * @author wangp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DxfCircle extends BaseDxfEntity {

    /**
     * 圆心位置
     */
    private Vector3 center;
    /**
     * 半径
     */
    private double radius;


    @Override
    public String getEntityName() {
        return "CIRCLE";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbCircle";
    }

    @Override
    protected String getChildDxfStr() {
        return DxfLineBuilder.build()
                .append(10, center.getX())
                .append(20, center.getY())
                .append(30, center.getZ())
                .append(40, radius)
                .toString();
    }

}


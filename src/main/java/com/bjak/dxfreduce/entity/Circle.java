package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector3;
import com.bjak.dxfreduce.entity.base.BaseEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author wangp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends BaseEntity {

    private Vector3 center;
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


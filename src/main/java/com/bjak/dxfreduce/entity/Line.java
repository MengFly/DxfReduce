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
public class Line extends BaseEntity {
    private Vector3 startPoint;
    private Vector3 endPoint;

    @Override
    protected String getChildDxfStr() {
        return DxfLineBuilder.build()
                .append(10, startPoint.getX())
                .append(20, startPoint.getY())
                .append(30, startPoint.getZ())
                .append(11, endPoint.getX())
                .append(21, endPoint.getY())
                .append(31, endPoint.getZ())
                .toString();
    }

    @Override
    public String getEntityName() {
        return "LINE";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbLine";
    }
}

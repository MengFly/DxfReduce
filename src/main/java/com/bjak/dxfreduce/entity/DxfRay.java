package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector3;
import com.bjak.dxfreduce.entity.base.BaseDxfEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * 射线
 *
 * @author wangp
 */
@Getter
@Setter
public class DxfRay extends BaseDxfEntity {

    /**
     * 起始点位置
     */
    private Vector3 start;
    /**
     * 射线方向
     */
    private Vector3 direction;


    @Override
    protected String getChildDxfStr() {
        return DxfLineBuilder.build()
                .append(10, start.getX())
                .append(20, start.getY())
                .append(30, start.getZ())
                .append(11, direction.getX())
                .append(21, direction.getY())
                .append(31, direction.getZ())
                .toString();
    }

    @Override
    public String getEntityName() {
        return "RAY";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbRay";
    }
}

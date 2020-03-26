package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.entity.base.BaseEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;


/**
 * @author wangp
 */
public class Hatch extends BaseEntity {

    public enum HatchType {
        /**
         * Solid
         */
        SOLID;
    }

    private Solid solid;

    public static Hatch buildHatchBy(Circle circle) {
        Hatch hatch = new Hatch();
        hatch.solid = new Solid();
        hatch.solid.setCircle(circle);
        hatch.color = circle.getSolidColor() == null ? circle.getColor() : circle.getSolidColor();
        return hatch;
    }

    @Override
    protected String getChildDxfStr() {
        return DxfLineBuilder.build()
                .append(10, 0.0)
                .append(20, 0.0)
                .append(30, 0.0)
                .append(210, 0.0)
                .append(220, 0.0)
                .append(230, 1.0)
                .append(solid.getDxfStr())
                .toString();
    }

    @Override
    public String getEntityName() {
        return "HATCH";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbHatch";
    }

}

package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.entity.base.BaseDxfEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;


/**
 * @author wangp
 */
public class DxfHatch extends BaseDxfEntity {

    public enum HatchType {
        /**
         * Solid
         */
        SOLID;
    }

    private DxfSolid dxfSolid;

    public static DxfHatch buildHatchBy(DxfCircle dxfCircle) {
        DxfHatch dxfHatch = new DxfHatch();
        dxfHatch.dxfSolid = new DxfSolid();
        dxfHatch.dxfSolid.setDxfCircle(dxfCircle);
        dxfHatch.color = dxfCircle.getSolidColor() == null ? dxfCircle.getColor() : dxfCircle.getSolidColor();
        return dxfHatch;
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
                .append(dxfSolid.getDxfStr())
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

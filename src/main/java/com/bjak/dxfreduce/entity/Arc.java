package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Arc extends Circle {

    private double startAngle;
    private double endAngle;

    @Override
    protected String getChildDxfStr() {

        return DxfLineBuilder.build()
                .append(super.getChildDxfStr())
                .append(100, "AcDbArc")
                .append(50, startAngle)
                .append(51, endAngle)
                .toString();
    }

    @Override
    public String getEntityName() {
        return "ARC";
    }

}

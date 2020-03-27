package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * 圆弧
 *
 * @author wangp
 */
@Getter
@Setter
public class DxfArc extends DxfCircle {
    /**
     * 起始角度(0-360)
     */
    private double startAngle;
    /**
     * 结束角度(0-360)
     */
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

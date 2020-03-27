package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector3;
import com.bjak.dxfreduce.entity.base.BaseDxfEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * 椭圆
 *
 * @author wangp
 */
@Getter
@Setter
public class DxfEllipse extends BaseDxfEntity {

    /**
     * 中心点
     */
    private Vector3 centerPoint;
    /**
     * 长轴相对于中心点的坐标
     */
    private Vector3 majorAxisPoint;
    /**
     * 短轴相对于长轴的缩放比例
     */
    private double shortAxisScale = 1.0;
    /**
     * 图形是否闭合
     */
    private boolean close = true;
    /**
     * 开始角度（0-360），当图形闭合时默认为0
     */
    private double startAngle = 0;
    /**
     * 结束角度(0-360)，当图形闭合时，默认是360
     */
    private double endAngle = 360;


    @Override
    protected String getChildDxfStr() {
        DxfLineBuilder lineBuilder = DxfLineBuilder.build();
        lineBuilder
                .append(10, centerPoint.getX())
                .append(20, centerPoint.getY())
                .append(30, centerPoint.getZ())
                .append(11, majorAxisPoint.getX())
                .append(21, majorAxisPoint.getY())
                .append(31, majorAxisPoint.getZ())
                .append(40, shortAxisScale);
        if (close) {
            lineBuilder.append(41, 0);
            lineBuilder.append(42, 2 * Math.PI);
        } else {
            lineBuilder.append(41, startAngle / 180 * Math.PI);
            lineBuilder.append(42, endAngle / 180 * Math.PI);
        }

        return lineBuilder.toString();
    }

    @Override
    public String getEntityName() {
        return "ELLIPSE";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbEllipse";
    }
}

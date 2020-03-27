package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector3;
import com.bjak.dxfreduce.entity.base.BaseDxfEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * 文字
 * @author wangp
 */
@Getter
@Setter
public class DxfText extends BaseDxfEntity {

    /**
     * 不翻转
     */
    public static final int REVERSE_TYPE_NONE = 0;
    /**
     * 沿X轴方向镜像翻转
     */
    public static final int REVERSE_TYPE_X = 2;
    /**
     * 沿Y轴方向镜像翻转
     */
    public static final int REVERSE_TYPE_Y = 4;

//    public static final int ALIGN_HORIZONTAL_LEFT = 0;
//    public static final int ALIGN_HORIZONTAL_CENTER = 1;
//    public static final int ALIGN_HORIZONTAL_RIGHT = 2;

//    public static final int ALIGN_VERTICAL_BASE_LINE = 0;
//    public static final int ALIGN_VERTICAL_BASE_BOTTOM = 1;
//    public static final int ALIGN_VERTICAL_BASE_CENTER = 2;
//    public static final int ALIGN_VERTICAL_BASE_TOP = 3;


    /**
     * 文字的起始位置
     */
    private Vector3 startPoint;
    /**
     * 文字的高度
     */
    private double high = 0;
    /**
     * 文字的宽度
     */
    private int width = 1;
    /**
     * 文字内容
     */
    private String text;
    /**
     * 旋转角度
     */
    private double angle = 0;
    private double inclination = 0;
    private String textStyle = "标准";
    private int reverseType = REVERSE_TYPE_NONE;
    // 暂时不使用这两个属性
    //    private int alignHorizontal = ALIGN_HORIZONTAL_LEFT;
//    private int alignVertical = ALIGN_VERTICAL_BASE_LINE;
    // 这个值暂时也没用，只有当上面两个属性使用的时候这个值才有使用的必要
//    private Vector3 endPoint;


    @Override
    protected String getChildDxfStr() {
        DxfLineBuilder lineBuilder = DxfLineBuilder.build()
                .append(10, startPoint.getX())
                .append(20, startPoint.getY())
                .append(30, startPoint.getZ())
                .append(40, high)
                .append(1, text);
        if (angle != 0) {
            lineBuilder.append(50, angle);
        }
        if (width != 1) {
            lineBuilder.append(41, width);
        }
        if (inclination != 0) {
            lineBuilder.append(51, inclination);
        }
        if ("标准".equals(textStyle)) {
            lineBuilder.append(7, textStyle);
        }
        if (reverseType != REVERSE_TYPE_NONE) {
            lineBuilder.append(71, reverseType);
        }
        lineBuilder.append(100, getEntityClassName());
        return lineBuilder.toString();
    }

    @Override
    public String getEntityName() {
        return "TEXT";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbText";
    }
}

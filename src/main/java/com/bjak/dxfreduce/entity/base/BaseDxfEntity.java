package com.bjak.dxfreduce.entity.base;

import com.bjak.dxfreduce.entity.LineWidth;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import com.bjak.dxfreduce.util.DxfUtil;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * 所有Entity的基础类,其中定义了一些Entity的基础操作，作为组装Entity信息的中间桥梁也定义了
 * 所有Entity都应该具备的一些基础设置，包括1.颜色。2.线宽。3.是否填充。4.填充颜色
 * <br>
 * 所有的dxf文件的entity都应该去通过实现这个类来方便定义其结构
 *
 * @author wangp
 */
@Getter
@Setter
public abstract class BaseDxfEntity implements DxfEntity {
    protected long meta;
    /**
     * 颜色
     */
    protected Color color = Color.BLACK;
    /**
     * 线宽
     */
    protected LineWidth lineWidth = LineWidth.LW_0;
    /**
     * 是否填充
     */
    protected boolean solid = false;
    /**
     * 填充颜色
     */
    protected Color solidColor = null;
    /**
     * 图形透明度，取值范围为0-100,当alpha为0时，为不透明，当alpha为100的时候，图形将不可见
     */
    protected int alpha = 0;
    /**
     * 填充透明度
     */
    protected int solidAlpha = 0;


    @Override
    public String getDxfStr() {
        return DxfLineBuilder.build(getEntityName())
                .append(5, DxfUtil.formatMeta(meta))
                .append(330, "1F")
                .append(100, "AcDbEntity")
                .append(8, "0")
                .append(420, formatDxfColor(color))
                .append(440, alpha)
                .append(370, lineWidth.getCode())
                .append(100, getEntityClassName())
                .append(getChildDxfStr())
                .toString();
    }

    /**
     * 子类Entity的字符串格式，由继承此类的子类自己实现仅需实现其包含的数据项元组即可，无需返回子类名称信息，
     * 例如Circle对象仅需返回其坐标值与半径即可,例如：
     * <blockquote><pre>
     * 10
     * 0.0
     * 20
     * 0.0
     * 30
     * 0.0
     * 40
     * 50.0
     * </pre></blockquote>
     *
     * @return Entity数据元组字符串
     */
    protected abstract String getChildDxfStr();

    /**
     * format color to dxf type, case color hex code to integer
     *
     * @param color color
     * @return color
     */
    public static int formatDxfColor(Color color) {
        if (color == null) {
            color = Color.BLACK;
        }
        return (color.getRed() << 16) + (color.getGreen() << 8) + color.getBlue();
    }
}

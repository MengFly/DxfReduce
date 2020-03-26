package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.entity.base.Entity;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import com.bjak.dxfreduce.util.DxfUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 图案填充，目前仅仅支持实体颜色填充，不支持图案填充与渐变填充
 *
 * @author wangp
 */
@Getter
@Setter
public class Solid {
    private Circle circle;

    public String getDxfStr() {

        DxfLineBuilder builder = DxfLineBuilder.build(2, "SOLID")
                // 实体填充标志（实体填充 = 1；图案填充 = 0)
                .append(70, 1)
                // 关联性标志（关联 = 1；无关联 = 0）
                .append(71, 1)
                // 边界数
                .append(91, 1)
                // 边界路径类型标志0 = 默认；1 = 外部；2 = 多段线;4 = 导出；8 = 文本框；16 = 最外层
                .append(92, 1)
                // 下面是有关顶点的描述，93-多线段顶点数，Arr -（顶点数个顶点描述）
                .append(93, 1)
                // 下面的这一部分是填充的对象属性的描述
                // 边界类型 1 = 直线；2 = 圆弧；3 = 椭圆弧；4 = 样条曲线
                .append(72, 2)
                .append(10, circle.getCenter().getX())
                .append(20, circle.getCenter().getY())
                .append(30, circle.getCenter().getZ())
                .append(40, circle.getRadius());
        // 下面是圆弧的属性，50-起始角度，51-端点角度， 73-逆时针标志
        if (circle instanceof Arc) {
            builder.append(50, ((Arc) circle).getStartAngle());
            builder.append(51, ((Arc) circle).getEndAngle());
        } else {
            builder.append(50, 0.0).append(51, 360);
        }
        builder.append(73, 1)
                // 源边界对象数
                .append(97, 1)
                // 源边界对象的参照
                .append(330, DxfUtil.formatMeta(circle.getMeta()))
                // 图案填充样式：,0 = 填充“奇数奇偶校验”区域（普通样式）,1 = 仅填充最外层区域（“外部”样式）,2 = 填充整个区域（“忽略”样式）
                .append(75, 0)
                //填充图案类型：0 = 用户定义；1 = 预定义；2 = 自定义
                .append(76, 1)
                // 种子点数
                .append(98, 1)
                // 种子点位置 10-x, 20-y
                .append(10, circle.getCenter().getX())
                .append(20, circle.getCenter().getY());
        return builder.toString();
    }
}

package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector2;
import com.bjak.dxfreduce.entity.base.BaseDxfEntity;
import com.bjak.dxfreduce.util.DxfLineBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 多段线图元
 *
 * @author wangp
 */
@AllArgsConstructor
@Getter
@Setter
public class DxfLwPolyLine extends BaseDxfEntity {

    /**
     * 各个点的集合
     */
    private List<Vector2> points;
    private boolean isClose = false;

    public DxfLwPolyLine() {
        points = new ArrayList<>();
    }

    /**
     * 向多线段中添加一个坐标点
     *
     * @param p 坐标点
     */
    public void addPoint(Vector2 p) {
        points.add(p);
    }

    /***
     * 从多线段中移除一个坐标点
     * @param p 坐标点
     */
    public void removePoint(Vector2 p) {
        points.remove(p);
    }

    /**
     * 多线段图元中内容是否为空
     *
     * @return 若图元空不包含任何坐标点返回true
     */
    public boolean isEmpty() {
        return points.isEmpty();
    }

    @Override
    protected String getChildDxfStr() {
        DxfLineBuilder lineBuilder = DxfLineBuilder.build();
        lineBuilder.append(90, points.size());
        lineBuilder.append(70, isClose ? 1 : 0);
        lineBuilder.append(43, 0.0);
        for (Vector2 point : points) {
            lineBuilder.append(10, point.getX()).append(20, point.getY());
        }
        return lineBuilder.toString();
    }

    @Override
    public String getEntityName() {
        return "LWPOLYLINE";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbPolyline";
    }
}

package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector2;
import com.bjak.dxfreduce.entity.base.BaseEntity;
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
public class LwPolyLine extends BaseEntity {

    private List<Vector2> points;
    private boolean isClose = false;

    public LwPolyLine() {
        points = new ArrayList<>();
    }

    public void addPoint(Vector2 p) {
        points.add(p);
    }

    public void removePoint(Vector2 p) {
        points.remove(p);
    }

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

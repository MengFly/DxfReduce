package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.DxfCircle;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TestColor {

    public static void main(String[] args) {
        List<Color> colors = Arrays.asList(Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED);
        TestUtil.testEntity(null, "D:/test/test_color.dxf", i -> {
            DxfCircle circle = new DxfCircle(new Vector3(i * 100, 0, 0), 50);
            circle.setSolid(true);
            circle.setSolidColor(colors.get(i % colors.size()));
            return circle;
        });
    }
}

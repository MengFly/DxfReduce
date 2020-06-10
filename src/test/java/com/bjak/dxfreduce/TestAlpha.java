package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.DxfCircle;

public class TestAlpha {

    public static void main(String[] args) {

        TestUtil.testEntity(null, "D:/test/test_alpha.dxf", i -> {
            /// autoCad2010中，设置了透明度属性不起作用
            DxfCircle circle = new DxfCircle(new Vector3(i * 100, 0, 0), 100);
            circle.setSolid(true);
            circle.setSolidColor(TestUtil.randomColor());
            int alpha = TestUtil.random.nextInt(100);
            circle.setAlpha(alpha);
            circle.setSolidAlpha(100 - alpha);
            return circle;
        });
    }
}

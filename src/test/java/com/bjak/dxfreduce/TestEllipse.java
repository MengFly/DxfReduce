package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.DxfEllipse;

public class TestEllipse {

    public static void main(String[] args) {

        TestUtil.testEntity(null, "D:/test/test_ellipse.dxf", i -> {
            DxfEllipse dxfEllipse = new DxfEllipse();
            dxfEllipse.setCenterPoint(new Vector3(i * 200, 0, 0));
            dxfEllipse.setMajorAxisPoint(new Vector3(100, TestUtil.random.nextInt(50), 0));
            dxfEllipse.setClose(i % 5 != 0);
            dxfEllipse.setStartAngle(TestUtil.random.nextDouble() * 180);
            dxfEllipse.setEndAngle(180 + TestUtil.random.nextDouble() * 180);
            dxfEllipse.setShortAxisScale(0.3 + 0.7 * TestUtil.random.nextDouble());
            return dxfEllipse;
        });
    }
}

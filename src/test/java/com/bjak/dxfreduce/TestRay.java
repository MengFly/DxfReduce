package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.DxfRay;

public class TestRay {

    public static void main(String[] args) {
        TestUtil.testEntity(null, "D:/test/test_ray.dxf", i -> {
            DxfRay dxfRay = new DxfRay();
            dxfRay.setStart(Vector3.ZERO);
            dxfRay.setDirection(new Vector3(TestUtil.random.nextInt(10), TestUtil.random.nextInt(10), TestUtil.random.nextInt(10)));
            return dxfRay;
        });
    }
}

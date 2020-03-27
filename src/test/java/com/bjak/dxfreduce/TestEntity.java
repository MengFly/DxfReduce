package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.DxfCircle;

public class TestEntity {


    public static void main(String[] args) {
        testCircle();
    }

    private static void testCircle() {
        DxfCircle dxfCircle = new DxfCircle();
        dxfCircle.setCenter(new Vector3(100, 100, 100));
        dxfCircle.setRadius(100);
        dxfCircle.setMeta(1);
        System.out.println(dxfCircle.getDxfStr());
    }
}

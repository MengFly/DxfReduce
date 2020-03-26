package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.Circle;

public class TestEntity {


    public static void main(String[] args) {
        testCircle();
    }

    private static void testCircle() {
        Circle circle = new Circle();
        circle.setCenter(new Vector3(100, 100, 100));
        circle.setRadius(100);
        circle.setMeta(1);
        System.out.println(circle.getDxfStr());
    }
}

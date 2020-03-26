package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.Circle;

import java.io.IOException;

public class TestEntityBuilder {

    public static void main(String[] args) throws IOException {
        DxfDocument builder = new DxfDocument("E:\\testDxf\\test_circle.dxf");
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
            circle.setCenter(new Vector3(100 + i * 500, 100, 100));
            circle.setRadius(100);
            builder.addEntity(circle);
        }
        builder.save("E:\\testDxf\\new_entity.dxf", true);
        builder.close();
    }
}

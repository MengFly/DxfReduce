package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.DxfCircle;

import java.io.IOException;

public class TestEntityBuilder {

    public static void main(String[] args) throws IOException {
        DxfDocWriter builder = new DxfDocWriter("E:\\testDxf\\test_circle.dxf");
        for (int i = 0; i < 10; i++) {
            DxfCircle dxfCircle = new DxfCircle();
            dxfCircle.setCenter(new Vector3(100 + i * 500, 100, 100));
            dxfCircle.setRadius(100);
            builder.addEntity(dxfCircle);
        }
        builder.save("E:\\testDxf\\new_entity.dxf", true);
        builder.close();
    }
}

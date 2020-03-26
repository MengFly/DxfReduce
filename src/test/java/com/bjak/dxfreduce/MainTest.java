package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.*;
import com.bjak.dxfreduce.util.FileUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MainTest {

    public static void main(String[] args) {
        Random random = new Random();
        String dxfFile = "E:\\testDxf\\test4.dxf";
        try (DxfDocument dxfDocument = new DxfDocument(dxfFile, StandardCharsets.UTF_8)) {
            for (int i = 0; i < 50; i++) {
                Color randomColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                LineWidth lineWidth = LineWidth.values()[random.nextInt(LineWidth.values().length)];
                // test add Circle
                Vector3 center = new Vector3(200 + i * 100, random.nextInt(200), 100);
                Circle circle = new Circle(center, 50);
                circle.setLineWidth(lineWidth);
                circle.setColor(randomColor);
                circle.setSolid(i % 3 == 0);
                circle.setSolidColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                dxfDocument.addEntity(circle);

                // test add Circle solid
                Circle circle2 = new Circle(new Vector3(200 + i * 100, -250, 100), 50);
                circle2.setLineWidth(lineWidth);
                circle2.setColor(randomColor);
                circle2.setSolid(i % 3 == 0);
                dxfDocument.addEntity(circle2);

                // test add line
                Line line = new Line(new Vector3(2600, 1000, 100), center);
                line.setColor(randomColor);
                line.setLineWidth(lineWidth);
                dxfDocument.addEntity(line);

                // test add lwPolyLine
                LwPolyLine lwPolyLine = new LwPolyLine();
                lwPolyLine.addPoint(new Vector2(i * 100, 1200));
                lwPolyLine.addPoint(new Vector2(50 + i * 100, 1200));
                lwPolyLine.addPoint(new Vector2(60 + i * 100, 1200 - 50));
                lwPolyLine.addPoint(new Vector2(10 + i * 100, 1200 - 50));
                lwPolyLine.setClose(i % 5 != 0);
                lwPolyLine.setLineWidth(lineWidth);
                lwPolyLine.setColor(randomColor);
                dxfDocument.addEntity(lwPolyLine);

                // test add text
                Text text = new Text();
                text.setText((char) (65 + random.nextInt(26)) + "哈哈");
                text.setAngle(random.nextInt(360));
                text.setHigh(10 + random.nextInt(10));
                text.setInclination(random.nextInt(45));
                text.setWidth(1 + random.nextInt(2));
                text.setColor(randomColor);
                text.setStartPoint(new Vector3(i * 100, 1400, 100));
                dxfDocument.addEntity(text);

                // test add arc
                Arc arc = new Arc();
                arc.setCenter(new Vector3(200 + i * 100, 1600, 100));
                arc.setRadius(100);
                arc.setStartAngle(random.nextInt(90));
                arc.setEndAngle(180 + random.nextInt(180));
                arc.setColor(randomColor);
                arc.setLineWidth(lineWidth);
                arc.setSolid(i % 5 == 0);
                dxfDocument.addEntity(arc);
            }
            String generateNewDxf = "E:\\testDxf\\test_generate.dxf";
            String entitiesFilePath = "E:\\testDxf\\test_generate_entities.dxf";
            FileUtil.deleteFile(new File(generateNewDxf));
            FileUtil.deleteFile(new File(entitiesFilePath));
            dxfDocument.save(generateNewDxf, true);
            dxfDocument.saveEntities(entitiesFilePath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

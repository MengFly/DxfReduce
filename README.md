## dxf_reduce

dxf文件处理库，可以创建、加载dxf文件，并向其中添加新的图元。目前可以添加进去的图元有：
+ Arc
+ Circle
+ Line
+ LwPolyLine
+ Text

支持对图元进行填充的图元有
+ Arc
+ Circle


### 使用：
#### 1. 创建一个新的dxf文件
```java
public class TestCreateDxf {

    public static void main(String[] args) {
        Random random = new Random();
        try (DxfDocument dxfDocument = new DxfDocument()) {
            for (int i = 0; i < 50; i++) {
                Color randomColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                LineWidth lineWidth = LineWidth.values()[random.nextInt(LineWidth.values().length)];
                Vector3 center = new Vector3(200 + i * 100, random.nextInt(200), 100);
                // 添加圆形
                Circle circle = new Circle(center, 50);
                // 设置线宽
                circle.setLineWidth(lineWidth);
                // 设置颜色
                circle.setColor(randomColor);
                // 设置是否进行填充
                circle.setSolid(i % 3 == 0);
                // 设置填充的颜色
                circle.setSolidColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                // 添加图元
                dxfDocument.addEntity(circle);

                // 添加线段
                Line line = new Line(new Vector3(2600, 1000, 100), center);
                line.setColor(randomColor);
                line.setLineWidth(lineWidth);
                dxfDocument.addEntity(line);

                // 添加多线段
                LwPolyLine lwPolyLine = new LwPolyLine();
                // 添加多线段各个顶点
                lwPolyLine.addPoint(new Vector2(i * 100, 1200));
                lwPolyLine.addPoint(new Vector2(50 + i * 100, 1200));
                lwPolyLine.addPoint(new Vector2(60 + i * 100, 1200 - 50));
                lwPolyLine.addPoint(new Vector2(10 + i * 100, 1200 - 50));
                // 设置是否是闭合图形
                lwPolyLine.setClose(i % 5 != 0);
                lwPolyLine.setLineWidth(lineWidth);
                lwPolyLine.setColor(randomColor);
                dxfDocument.addEntity(lwPolyLine);

                // 添加文字
                Text text = new Text();
                text.setText((char) (65 + random.nextInt(26)) + "哈哈");
                // 设置旋转角度
                text.setAngle(random.nextInt(360));
                // 设置高度
                text.setHigh(10 + random.nextInt(10));
                // 设置倾斜角度
                text.setInclination(random.nextInt(45));
                // 设置宽度
                text.setWidth(1 + random.nextInt(2));
                text.setColor(randomColor);
                // 设置绘制点位置
                text.setStartPoint(new Vector3(i * 100, 1400, 100));
                dxfDocument.addEntity(text);

                // 添加弧形
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
            String generateNewDxf = "E:\\testDxf\\test_empty_generate.dxf";
            String entitiesFilePath = "E:\\testDxf\\test_empty_generate_entities.dxf";
            // 保存dxf文件
            dxfDocument.save(generateNewDxf, true);
            // 仅仅保存图元信息
            dxfDocument.saveEntities(entitiesFilePath, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

#### 2. 加载一个已经存在的文件
```java
public class TestCreateDxf {

    public static void main(String[] args) {
        try (DxfDocument dxfDocument = new DxfDocument(path)) {
            // body code, same as before code
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

#### 3. 存储的dxf文件示例
![2020-03-26_164450.png](2020-03-26_164450.png)
package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.LineWidth;
import com.bjak.dxfreduce.entity.base.BaseDxfEntity;
import com.bjak.dxfreduce.util.FileUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.function.Function;

public class TestUtil {
    public static Random random = new Random();

    public static Color randomColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static LineWidth randomLw() {
        return LineWidth.values()[random.nextInt(LineWidth.values().length)];
    }

    public static void testEntity(String dxfFilePath, String generateNewDxf, Function<Integer, BaseDxfEntity> fun) {
        try (DxfDocWriter dxfDocWriter = new DxfDocWriter(dxfFilePath, StandardCharsets.UTF_8)) {
            for (int i = 0; i < 50; i++) {
                BaseDxfEntity apply = fun.apply(i);
//                apply.setColor(randomColor());
//                apply.setLineWidth(randomLw());
                dxfDocWriter.addEntity(apply);
            }
            FileUtil.deleteFile(new File(generateNewDxf));
            dxfDocWriter.save(generateNewDxf, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

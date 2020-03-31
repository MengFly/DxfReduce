package com.bjak.dxfreduce;

import com.bjak.dxfreduce.entity.DxfXLine;

public class TestXline {

    public static void main(String[] args) {
        TestUtil.testEntity(null, "D:/test/test_xline.dxf", i -> {
            DxfXLine xLine = new DxfXLine();
            xLine.setStart(Vector3.ZERO);
            xLine.setDirection(new Vector3(-5 + TestUtil.random.nextInt(10),
                    -5 + TestUtil.random.nextInt(10), 0));
            return xLine;
        });
    }
}

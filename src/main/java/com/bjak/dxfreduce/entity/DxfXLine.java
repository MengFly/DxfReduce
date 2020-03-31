package com.bjak.dxfreduce.entity;

import com.bjak.dxfreduce.Vector3;
import lombok.Getter;
import lombok.Setter;

/**
 * 构造线
 *
 * @author wangp
 */
@Getter
@Setter
public class DxfXLine extends DxfRay {

    @Override
    public String getEntityName() {
        return "XLINE";
    }

    @Override
    public String getEntityClassName() {
        return "AcDbXline";
    }
}

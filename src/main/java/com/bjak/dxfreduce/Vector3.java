package com.bjak.dxfreduce;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Vector for 3 dimension
 *
 * @author wangp
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Vector3 {

    private double x;
    private double y;
    private double z;

    public static Vector3 ZERO = new Vector3(0, 0, 0);
}

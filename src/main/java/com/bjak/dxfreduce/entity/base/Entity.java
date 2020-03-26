package com.bjak.dxfreduce.entity.base;

/**
 * @author wangp
 */
public interface Entity {

    String getDxfStr();

    void setMeta(long meta);

    String getEntityName();

    String getEntityClassName();
}

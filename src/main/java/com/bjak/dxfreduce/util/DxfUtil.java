package com.bjak.dxfreduce.util;

import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author wangp
 */
@Log4j
public class DxfUtil {

    public static boolean isPairNameEquals(String[] pair, String name) {
        if (pair == null) {
            return false;
        }
        return Objects.equals(name, pair[1].trim());
    }

    public static String formatMeta(long meta) {
        return StringUtil.appendStart('0', 3, Long.toHexString(meta)).toUpperCase();
    }

    public static long readMaxMeta(String dxfFilePath) {
        long maxMeta = 0;
        try (BufferedReader br = StreamUtil.getFileReader(dxfFilePath)) {
            while (true) {
                String[] pair = StreamUtil.readNextPair(br);
                if (pair == null) {
                    break;
                }
                if ("5".equals(pair[0].trim())) {
                    maxMeta = Math.max(maxMeta, Long.parseLong(pair[1].trim(), 16));
                }
            }
        } catch (IOException e) {
            log.error("read maxMeta error", e);
        }
        return maxMeta;
    }
}

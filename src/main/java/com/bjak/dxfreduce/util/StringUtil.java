package com.bjak.dxfreduce.util;

public class StringUtil {

    /**
     * append line with  line separators 'CRLF'
     *
     * @param buffer will append content buffer
     * @param lines  lines
     */
    public static void appendLnCrLf(StringBuffer buffer, String... lines) {
        buffer.append(appendLnCrLf(lines));
    }

    /**
     * append line with  line separators 'CRLF'
     *
     * @param lines lines
     */
    public static String appendLnCrLf(String... lines) {
        StringBuilder result = new StringBuilder();
        for (String str : lines) {
            result.append(str).append("\r\n");
        }
        return result.toString();
    }


    /**
     * append chart to res start, until the result length equals strLength
     * @param start the chart you want append rec start
     * @param strLength output result length
     * @param res res
     * @return append to strLength by start chart
     */
    public static String appendStart(char start, int strLength, String res) {
        if (res.length() >= strLength) {
            return res;
        }
        int len = strLength - res.length();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < len; i++) {
            buffer.append(start);
        }
        buffer.append(res);
        return buffer.toString();
    }


}

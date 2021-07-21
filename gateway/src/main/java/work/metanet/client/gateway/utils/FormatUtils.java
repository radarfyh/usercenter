package work.metanet.client.gateway.utils;

/**
 * @Description 字符串格式化
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */

public interface FormatUtils {

    /**
     * 将字符串用中括号括起来
     * @param s 字符串
     * @return [s]
     */
    static String wrapStringWithBracket(String s) {
        return "[" + s + "] ";
    }

}

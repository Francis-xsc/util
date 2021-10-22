package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsc
 * @time 2021/10/10 - 22:21
 */
public class PageUtil {
    /**
     * 生成应展示的页码（5页）
     * @param current   当前页码
     * @param total     总页数
     * @return
     */
    public static List<Integer> getShowedPages(int current, int total) {
        List<Integer> res = new ArrayList<>();
        int min,max;
        if (total <= 5) {
            min=1;
            max=total;
        } else if (current <= 2) {
            min = 1;
            max = 5;
        } else if (current + 2 > total) {
            min = total - 4;
            max = total;
        } else {
            min=current-2;
            max=current+2;
        }
        for (int i = min; i <= max; i++) {
            res.add(i);
        }
        return res;
    }
}

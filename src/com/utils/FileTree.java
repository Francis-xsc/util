package com.utils;

import java.io.File;
import java.util.*;
import java.util.List;

/**
 * @author xsc
 * @time 2021/10/22 - 16:21
 */
public class FileTree {
    /**
     * 生成文件目录树
     * windows自带 cmd-> tree /f
     * @param file  文件夹
     */
    public static void fileTree(File file) {
        ftree(file,0);
    }

    /**
     * 生成文件目录树
     * @param path 文件夹路径
     */
    public static void fileTree(String path) {
        ftree(new File(path), 0);
    }

    public static void ftree(File file, int depth) {
        List<File> files = Arrays.asList(file.listFiles());
        files.sort(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile()) {
                    return -1;
                }
                if (o1.isFile() && o2.isDirectory()) {
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (int i = 0; i < files.size(); i++) {
            for (int j = 0; j < depth; j++) {
                System.out.print("|\t");
            }
            if (i == files.size() - 1) {
                System.out.print("└──\t");
                System.out.println(files.get(i).getName());
            } else {
                System.out.println("├──\t" + files.get(i).getName());
            }
            if (files.get(i).isDirectory()) {
                ftree(files.get(i), depth + 1);
            }
        }
    }
}

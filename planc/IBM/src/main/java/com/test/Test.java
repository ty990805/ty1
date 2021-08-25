package com.test;

import com.planc.pojo.Data;
import com.planc.service.read.ReadFormat;

import java.io.File;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        ReadFormat readFormat = new ReadFormat();
        File format = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/planc/format.txt");
        List<String> strings = readFormat.txt2data(format);
        System.out.println(strings);

        File file = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/planc/test.txt");
        ReadParam readParam = new ReadParam();
        List<Data> data = readParam.format2Param(strings, file);
        System.out.println(data);
    }
}

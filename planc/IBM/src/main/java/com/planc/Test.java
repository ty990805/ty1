package com.planc;

import com.planc.pojo.Data;
import com.planc.service.read.ReadFormat;
import com.planc.service.read.ReadParam;

import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // 存储读到的 statement_key
        List<String> statement_key = new ArrayList<>();

        ReadFormat readFormat = new ReadFormat();
        File format = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/planc/format.txt");
        statement_key = readFormat.txt2data(format);

        for (String s:statement_key){
            System.out.println(s);
        }

//        statement_key.add("KERNELSTACKS");
//        statement_key.add("MOUNT");

        List<Data> statement = new ArrayList<>();
        ReadParam readParam = new ReadParam();
        File data = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/planc/test.txt");
        List<Data> data1 = readParam.format2Param(statement_key, data);
        for(Data d:data1){
            System.out.println(d.toString());
        }
    }
}

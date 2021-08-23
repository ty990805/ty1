package com.jie.Test;


import com.jie.Pojo.Pojo;
import com.jie.service.read.Read;
import com.jie.service.search.Impl.SearchImpl;
import com.jie.service.search.Search;
import com.jie.Pojo.Data2;
import com.jie.service.read.ReadParam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
//        List<Pojo> list = new ArrayList<>();
//        // 将文件读取到 pojo
//        Read read = new Read();
//        File f = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/planc/data.txt");
//        list = read.txt2String(f);
//        Search search = new SearchImpl();
//        search.showAll(list);

        List<Data2> statement = new ArrayList<>();
        ReadParam readParam = new ReadParam();
        File file = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/jie/test.txt");
        List<Data2> data1 = readParam.test(file);
        for(Data2 d:data1){
            System.out.println(d.toString());
        }


    }

}

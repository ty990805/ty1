package com.planc;

import com.planc.pojo.Data;
import com.planc.pojo.ParamMember;
import com.planc.pojo.Syntas;
import com.planc.service.search.DataSearch;
import com.planc.service.search.Impl.DataSearchImpl;
import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // 由 format 获得 statement
        File format = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/planc/format.txt");
        Syntas syntas = new Syntas(format);
        List<String> statement_key = syntas.getStatement();

        for (String s:statement_key){
            System.out.println(s);
        }

        File file = new File("/Users/wujie/IdeaProjects/IBM/src/main/java/com/planc/test.txt");
        ParamMember paramMember = new ParamMember(statement_key,file);
        List<Data> statement = paramMember.getStatement();
        for(Data d:statement){
            System.out.println(d.toString());
        }


        // statement
        String statement_ = "MOUNT";
        // 指定 searchKey  实际中由前端传入
        List<String> searchKey = new ArrayList<>(Arrays.asList("TYPE","MKDIR","MODE"));

        // 构造 filter 实际中需要前端传入
        List<String> sub1 = new ArrayList<>(Arrays.asList("TYPE:ZFS"));
        List<String> sub2 = new ArrayList<>(Arrays.asList("UNMOUNTMOUNTPOINT:/&SYSNAME/etc"));
        List<List<String>> filter = new ArrayList<>();
        filter.add(sub1);
        filter.add(sub2);

        DataSearch dataSearch = new DataSearchImpl();
        // 无 filter
        // List<String> send = dataSearch.searchByKey(statement, statement_,searchKey);

        List<String> send = dataSearch.search(statement,statement_);

        // 有 filter
        // List<String> send = dataSearch.search(statement, statement_,searchKey,filter);

//        List<String> send = new ArrayList<>();
//        for(String s_k :statement_key){
//            System.out.println("ALL   statement_key------>  " +  s_k);
//            List<String> s = dataSearch.search(statement,s_k,searchKey,filter);
//            if (!s.isEmpty()){
//                System.out.println("statement_key------>  " + s_k);
//                System.out.println(s);
//            }
//        }

        for(String s:send){
            System.out.println(s);
        }
    }
}

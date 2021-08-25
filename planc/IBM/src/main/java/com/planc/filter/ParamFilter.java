package com.planc.filter;

import com.planc.common.Kmp;
import java.util.ArrayList;
import java.util.List;

public class ParamFilter {
    public static void main(String[] args) {
        List<List<String>> filter = new ArrayList<List<String>>();
        for (int i = 0; i < 4; i++) {
            List<String> str = new ArrayList<String>();
            for (int j = 0; j < 3; j++) {
                str.add("{"+String.valueOf(j+10)+"}");
            }
            filter.add(str);
        }
        ParamFilter paramFilter = new ParamFilter();
        paramFilter.filter(filter.get(0),filter);
    }

    public List<String> filter(List<String> statement_value,List<List<String>> filter){

//        对 filter 的内容通过条件进行连接
//        for (int i = 0; i < filter.size(); i++) {
//            System.out.println(filter.get(i));
//        }
//        System.out.println("filter的层数为"+filter.size());

        String s1 = "";
//        System.out.println("state -------");
//        for(String s:statement_value){
//            System.out.println(s);
//        }
        List<String> filter_ = new ArrayList<>();
        combine(filter, s1 , 0,filter_);

//        System.out.println("filter -------");
//        for(String f:filter_){
//            System.out.println(f);
//        }
//        for(List<String> s:filter){
//            for(String s_ : s){
//                System.out.println(s_);
//            }
//        }
//        String kmpMatch = Kmp.kmpMatch(statement_value, filter);
        List<String> result = new ArrayList<>();
        for(String sta:statement_value){
            for(String fil:filter_){
                if(Kmp.kmpMatch(sta, fil)){
                    result.add(sta);
                }
            }
        }
//        for(String re:result){
//            System.out.println(re);
//        }
        return result;
    }

    public static String combine(List<List<String>> filter, String s1, int i,List<String> filter_){

        if (i < filter.size()){

            List<String> str = filter.get(i);//获得filter中第i行

            for (int j = 0; j < str.size(); j++) {

                //如果此时filter已经达到最后一行的条件，进行匹配并且输出

                if(i == filter.size()-1){
//                    Kmp.kmpMatch(statement_value, filter);
                    // System.out.println("-------------");
                    // System.out.println(s1 + " " + str.get(j).substring(0,str.get(j).length())+ " 的查找结果为 " );
                    filter_.add(s1 + " " + str.get(j).substring(0,str.get(j).length()));
                    continue;
                }
                //继续递归调用，进行filter的拼接
                combine( filter, s1 +" " + str.get(j).substring(0,str.get(j).length()) ,i+1,filter_);

            }
        }
        return null;
    }
}

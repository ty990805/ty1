package com.jie.service.search.Impl;

import com.jie.Pojo.Pojo;
import com.jie.service.search.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchImpl implements Search {
    // 显示所有的 pojo 信息
    @Override
    public void showAll(List<Pojo> list) {
        for(int i = 0; i < list.size(); i++){
            Pojo p = list.get(i);
            System.out.println("第" + i + "个 pojo" + "\n"+ "statement：" + p.getStatement());
            List<String> s = p.getValue();
            System.out.println("Value: ");
            for(String s_ :s){
                System.out.println(s_);
            }
            System.out.println("\n");
        }
    }

    // 指定 statement
    @Override
    public List<String> findByStetament(List<Pojo> list, String statement) {
        for(int i = 0; i < list.size(); i++){
            Pojo p = list.get(i);
            if(p.getStatement().equals(statement)){
                return p.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> findByStateAndValue(List<Pojo> list, String statement, List<String> listSub) {
        return null;
    }

    @Override
    public List<Pojo> findByValue(List<Pojo> list, List<String> listSub) {
        return null;
    }

}

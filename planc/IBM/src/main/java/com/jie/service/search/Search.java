package com.jie.service.search;

import com.jie.Pojo.Pojo;

import java.util.List;

public interface Search {
    // 返回所有的 pojo
    void showAll(List<Pojo> list);

    // 获取指定 statement 的 pojo 的所有 value
    List<String> findByStetament(List<Pojo> list,String statement);

    // 指定 statement 以及部分 value
    List<String> findByStateAndValue(List<Pojo> list,String statement,List<String> listSub);

    // 指定 value
    List<Pojo> findByValue(List<Pojo> list,List<String> listSub);
}

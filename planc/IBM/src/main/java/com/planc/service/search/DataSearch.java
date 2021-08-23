package com.planc.service.search;

import com.planc.pojo.Data;
import java.util.List;

public interface DataSearch {
    // 测试
    void showAllParam(List<Data> list);

    // filter 是 statement_key
    List<String> search(List<Data> list,String statement_key);

    // filter 是 statement_key 和 statement_value
    // 需要遍历所有 statement_value 的情况
    List<String> search(List<Data> list,String statement_key,List<List<String>> filter);

    // 指定 statement 以及 key
    List<String> search(List<Data> list,String statement_key,List<String> searchKey,List<List<String>> filter);

    // filter 以及 searchKey
    List<String> searchByKey(List<Data> list,String statement_key,List<String> searchKey);

}

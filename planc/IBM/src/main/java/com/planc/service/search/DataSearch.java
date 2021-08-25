package com.planc.service.search;

import com.planc.pojo.Data;
import java.util.List;
import java.util.Map;

public interface DataSearch {
    // 测试
    void showAllParam(List<Data> list);

    // filter 是 statement_key
    List<String> search(List<Data> list,String statement_key);



    // 指定 statement 以及 key
    List<String> search(List<Data> list, String statement_key, List<String> searchKey, List<List<String>> filter);

    // filter 以及 searchKey
    List<String> searchByKey(List<Data> list,String statement_key,List<String> searchKey);

}

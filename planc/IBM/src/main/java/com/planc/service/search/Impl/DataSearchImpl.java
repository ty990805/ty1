package com.planc.service.search.Impl;

import com.planc.common.Kmp;
import com.planc.filter.ParamFilter;
import com.planc.pojo.Data;
import com.planc.service.search.DataSearch;
import java.util.List;


public class DataSearchImpl implements DataSearch {
    // 测试
    @Override
    public void showAllParam(List<Data> list) {

    }

    // 指定 statement_key
    @Override
    public List<String> search(List<Data> list, String statement_key) {

        return null;
    }

    @Override
    public List<String> searchByKey(List<Data> list, String statement_key, List<String> searchKey) {

        Kmp.kmpSearch(null,null);

        return null;
    }


    // 指定 statement_key 和 filter
    @Override
    public List<String> search(List<Data> list, String statement_key, List<List<String>> filter) {
        // 对 filter 进行解析
        ParamFilter paramFilter = new ParamFilter();

        List<String> stringList = paramFilter.filter(null, null);
        // 根据解析结果查数据
        return null;
    }

    @Override
    public List<String> search(List<Data> list, String statement_key, List<String> searchKey, List<List<String>> filter) {

        List<String> search = search(list, statement_key, filter);

        Kmp.kmpSearch(null,null);

        return null;
    }

}

package com.planc.service.search.Impl;

import com.planc.common.Kmp;
import com.planc.filter.ParamFilter;
import com.planc.pojo.Data;
import com.planc.service.search.DataSearch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataSearchImpl implements DataSearch {
    // 测试
    @Override
    public void showAllParam(List<Data> list) {
        for(Data s:list){
            System.out.println(s);
        }
    }

    // 指定 statement_key
    @Override
    public List<String> search(List<Data> list, String statement_key) {
        // 获取 statement_key 对应的 value
        List<String> statement_value = new ArrayList<>();
        for(Data s:list){
            if(s.getStatement_key().equals(statement_key)){
                statement_value.add(s.getStatement_value());
            }
        }
        // 封装结果
        List<String> result = new ArrayList<>();
        for(String s:statement_value){
            result.add(res_statement(s));
        }
        return result;
    }

    @Override
    public List<String> searchByKey(List<Data> list, String statement_key, List<String> searchKey) {
        // 获取 statement_key 对应的 value
        List<String> statement_value = new ArrayList<>();

        for(Data sub:list){
            if(sub.getStatement_key().equals(statement_key)){
                statement_value.add(sub.getStatement_value());
            }
        }
        List<String> result = new ArrayList<>();
        // 存储 searchKey 和 value
        Map<String,String> value = new HashMap<>();
        List<Map<String,String>> value_map = new ArrayList<>();
        for(String s:statement_value){
            for(String s_:searchKey){
                // 根据 searchKey 进行查找
                value = Kmp.kmpSearch(s, s_);
                value_map.add(value);
            }
            // 封装数据
            StringBuffer sb = new StringBuffer(res_statement(statement_key, s));
            if(!value_map.isEmpty()){
                sb.append(" values:");
                for(Map<String,String> m :value_map){
                    res_values(sb,m);
                }
            }
            result.add(sb.toString());
            value_map = new ArrayList<>();
        }
//        for(String s:result){
//            System.out.println(s);
//        }
        return result;
    }

    @Override
    public List<String> search(List<Data> list, String statement_key, List<String> searchKey, List<List<String>> filter) {
        List<String> result = new ArrayList<>();

        // 获取 statement_key 对应的 value
        List<String> statement_value = new ArrayList<>();
        for(Data sub:list){
            if(sub.getStatement_key().equals(statement_key)){
                statement_value.add(sub.getStatement_value());
            }
        }

        // 对 filter 进行解析
        ParamFilter paramFilter = new ParamFilter();
        // 返回经过 filter 的结果
        List<String> search = paramFilter.filter(statement_value, filter);

        Map<String,String> value = new HashMap<>();
        List<Map<String,String>> value_map = new ArrayList<>();
        // searchKey 不为空
        if(!(searchKey == null)){
            for(String s:search){
                for(String s_:searchKey){
                    // 根据 searchKey 查找
                    value = Kmp.kmpSearch(s, s_);
                    value_map.add(value);
                }
                // 封装数据
                StringBuffer sb = new StringBuffer(res_statement(statement_key, s));
                if(!value_map.isEmpty()){
                    sb.append(" values:");
                    for(Map<String,String> m :value_map){
                        res_values(sb,m);
                    }
                }
                result.add(sb.toString());
                value_map = new ArrayList<>();
            }
        }
//        for(String s:result){
//            System.out.println(s);
//        }
        return result;
    }

    // 封装数据
    public String res_statement(String statement_key,String res){
        Map<String,String> r = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        if(res !=null){
            sb.append("statement:").append(statement_key).append(" ").append(res);
        }
        return sb.toString();
    }

    public String res_statement(String statement_key){
        StringBuffer sb = new StringBuffer();
        sb.append("statement:").append(statement_key);
        return sb.toString();
    }

    public String res_values(StringBuffer res, Map<String,String> value){
        for(String s :value.keySet()){
            res.append("{ key:").append(s).append(",").append("value:").append(value.get(s)).append("}");
        }
        return res.toString();
    }

}

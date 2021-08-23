package com.test;

import com.planc.pojo.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReadParam {
    public List<Data> format2Param(Set<String> statement_key,File file){
        List<Data> list = new ArrayList<>();
        Data data = new Data();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            String s;
            while ((s = br.readLine()) != null){
                // 遇到新 statement_key ，保存旧信息
                if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' && data.getNum() >= 1){
                    data.setStatement_value(sb.toString());
                    list.add(data);
                    data = new Data();
                    sb = new StringBuffer();
                }
                // 处理 statement 行数据
                if((s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' )) {
                    String[] ss = s.trim().split("\\s+");
                    String[] s_ = ss[0].split("[^a-zA-Z_]");
                    // 判断 statement_key 是否存在
                    if(statement_key.contains(s_[0])){
                        data.setStatement_key(ss[0]);
                        for(int i = 1; i < ss.length; i++) {
                            sb.append(ss[i]);
                        }
                    }
                }else if(data.getNum() >= 1){    // 存在 statement_key 时，保存后面的信息
                    String[] ss = s.trim().split("\\s+");
                    for(int i = 0; i < ss.length; i++) {
                        sb.append(ss[i]);
                    }
                }
            }
            if(!sb.toString().isEmpty()){
                data.setStatement_value(sb.toString());
                list.add(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}

package com.jie.service.read;

import com.jie.Pojo.Pojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Read {
    public List<Pojo> txt2String(File file){
        // 最终数据
        List<Pojo> list = new ArrayList<>();
        try{
            // 临时变量
            Pojo pojo = new Pojo();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            StringBuffer value = new StringBuffer();
            String statement = null;
            List<String> sub_list = new ArrayList<>();
            // 读文本
            while ((s= br.readLine()) != null){
                // 处理 statement 以及该行的 value
                if(!Character.isSpaceChar(s.charAt(0))){
                    // 按照空格划分
                    String[] s_sub = s.split("\\s* ");
                    // 判断是否遇到新的 statement
                    if(!s_sub[0].equals(statement) && statement != null){
                        // 保存旧信息
                        // sub_list.add(value.toString());
                        pojo.setStatement(statement);
                        pojo.setValue(sub_list);
                        list.add(pojo);
                        // 重新初始化临时变量
                        pojo = new Pojo();
                        sub_list = new ArrayList<>();
                        value = new StringBuffer();
                    }
                    // 头信息
                    statement = s_sub[0];
                    // 存储该行剩下信息
                    for(int i = 1; i < s_sub.length; i++){
                        value.append(s_sub[i]);
                    }
                }else{
                    // 非头行
                    String[] s_sub = s.split("\\s* ");
                    String s1 = s_sub[1];
                    char c = s1.charAt(0);
                    // 根据开头是否为字母，判断是否新加 string
                    if(c >='a' && c<='z' ||  c >='A' && c<='Z'){
                        // 保存旧 string
                        sub_list.add(value.toString());
                        // 清空 stringbuffer，保存新 string
                        value = new StringBuffer();
                        for(int i = 1; i < s_sub.length;i++){
                            value.append(s_sub[i]);
                        }
                    }else{
                        // 将其放入 stringbuffer
                        for(int i = 1; i < s_sub.length;i++){
                            value.append(s_sub[i]);
                        }
                    }
                }
            }
            sub_list.add(value.toString());
            pojo.setStatement(statement);
            pojo.setValue(sub_list);
            list.add(pojo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

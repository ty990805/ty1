package com.planc.service.read;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadFormat {
    // 处理 statement 之前无缩进的情况
    public List<String> txt2data(File file){
        // 从 paramLib 提取 statement
        List<String> statement_key = new ArrayList<>();
        try {
            String statement = null;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null){
                if(!Character.isSpaceChar(s.charAt(0))){
                    Character q = s.charAt(0);
                    String[] s_sub;
                    if(q.equals('{')){
                        s_sub = s.split("[^a-zA-Z_()]");
                    }else {
                        s_sub = s.split("[^a-zA-Z_(){}]");
                    }
                    // s_sub = s.split("[^a-zA-Z_(){}]");
                    statement = s_sub[0];
                    A:for(String s_ :s_sub){
                        if(s_.matches("\\s*")){
                        }else {
                            for(Character c: s_.toCharArray()){
                                if(c.equals('(') || c.equals('{')){
                                    statement = "";
                                    break A;
                                }
                            }
                            statement = s_;
                            break;
                        }
                    }
                    if (!statement.isEmpty()){
                        statement_key.add(statement);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement_key;
    }
}

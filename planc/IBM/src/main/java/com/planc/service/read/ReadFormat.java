package com.planc.service.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
                    String[] s_sub = s.split("[^a-zA-Z_]");
                    statement = s_sub[0];
                    for(String s_ :s_sub){
                        if(s_.matches("\\s*")){
                        }else {
                            statement = s_;
                            break;
                        }
                    }
                    statement_key.add(statement);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statement_key;
    }
}

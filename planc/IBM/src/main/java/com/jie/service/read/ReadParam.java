package com.jie.service.read;

import com.jie.Pojo.Data2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadParam {
    public List<Data2> test(File file){
        List<Data2> list = new ArrayList<>();
        Data2 data2 = new Data2();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            String s;
            while ((s = br.readLine()) != null){
                if(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' && Data2.Num >= 1){
                    data2.setStatement_value(sb.toString());
                    list.add(data2);
                    data2 = new Data2();
                    sb = new StringBuffer();
                }
                if(s.charAt(0) == '\\') {
                    list.add(data2);
                }
                if((s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' )) {
                    String[] ss = s.trim().split("\\s+");
                    data2.setStatement_key(ss[0]);
                    for(int i = 1; i < ss.length; i++) {
                        sb.append(ss[i]);
                    }
                }else{
                    String[] ss = s.trim().split("\\s+");
                    for(int i = 0; i < ss.length; i++) {
                        sb.append(ss[i]);
                    }
                }
            }
            data2.setStatement_value(sb.toString());
            list.add(data2);
        }catch (Exception e){
            e.printStackTrace();
        }


        return list;
    }
}

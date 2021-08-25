package com.planc.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//    public static String kmpMatch(String mainString,String filter){
//
//        return null;
//    }
//
//    public static Map<String,String> kmpSearch(String mainString,String searchKey){
//
//        return null;
//    }



public class Kmp {

    //ADD DSN:DSN1
    //ADD VOL(VOL1) DSN(DSN1)
    public static boolean kmpMatch(String mainString,String filter){
        String[] subStr = filter.split("[^A-Za-z]");
        for(String sub:subStr){
            if(!mainString.contains(sub)){
                return false;
            }
        }
        return true;
    }

    public static Map<String,String> kmpSearch(String mainString,String searchKey){
        int stringStart = kmpClass.kmpMatch(mainString,searchKey);
        int p = stringStart + searchKey.length() + 1;
        StringBuilder sb = new StringBuilder();
        while(mainString.charAt(p) != ')'){
            sb.append(mainString.charAt(p));
            p++;
        }
        String value = sb.toString();
        HashMap<String,String> map = new HashMap<>();
        map.put(searchKey,value);
        return map;
    }

    public static void main(String[] args){
        String mainString = "FILESYSTEM('&OMVSHLQ..SVT.&SYSNUMB..SSHTEST.ZFS') TYPE(ZFS) MODE(RDWR) UNMOUNT MOUNTPOINT('/&SYSNAME/sshtest')";
        String filter = "TYPE:NFS MODE:RDWR";
//        List<String> l = getFilterArray(filter);
//        for(String s : l){
//            System.out.println(s);
//        }
        String searchKey = "MKDIR";
        Map<String,String> map = new HashMap<>();
        map = kmpSearch(mainString,searchKey);
        System.out.println("searchkey: " + searchKey + "  mapKeyResult :" + map.get(searchKey));
        System.out.println(filter);
        System.out.println(kmpMatch(mainString,filter));
    }
}




class kmpClass {

    public static int kmpMatch(String mainS, String subS) {
        char[] mainStr = mainS.toCharArray();
        char[] subStr = subS.toCharArray();
        int[] next = getNext(subS);
        int i = 0, j = 0;
        while (i < mainStr.length && j < subStr.length) {
            if (mainStr[i] == subStr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
                if (j == -1) {
                    i++;
                    j++;
                }
            }
        }
        if (j == subStr.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String s) {
        int[] next = new int[s.length()];
        char[] subStr = s.toCharArray();
        if (subStr.length >= 2) {
            next[0] = -1;
            next[1] = 0;
        }
        int j, len;
        for (int i = 2; i < subStr.length; i++) {
            for (len = i - 1; len >= 1; len--) {
                for (j = 0; j < len; j++) {
                    if (subStr[j] != subStr[j + i - len]) {
                        break;
                    }
                }
                if (j == len) {
                    next[i] = len;
                    break;
                }
            }
            if (len == 0) {
                next[i] = 0;
            }
        }
        return next;
    }
}

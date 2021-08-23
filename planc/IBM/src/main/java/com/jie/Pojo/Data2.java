package com.jie.Pojo;

public class Data2 {
    String statement_key;
    String statement_value;
    public static int Num = 0;

    @Override
    public String toString() {
        return "Data2{" +
                "statement_key='" + statement_key + '\'' +
                ", statement_value='" + statement_value + '\'' +
                '}';
    }

    public String getStatement_key() {
        return statement_key;
    }

    public void setStatement_key(String statement_key) {
        this.statement_key = statement_key;
        Data2.Num++;
    }

    public String getStatement_value() {
        return statement_value;
    }

    public void setStatement_value(String statement_value) {
        this.statement_value = statement_value;
    }

    public Data2() {
    }

    public Data2(String statement_key, String statement_value) {
        this.statement_key = statement_key;
        this.statement_value = statement_value;
    }
}

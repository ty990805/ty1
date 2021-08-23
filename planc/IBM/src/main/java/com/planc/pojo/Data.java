package com.planc.pojo;


public class Data {
    private String statement_key;
    private String statement_value;
    private int Num = 0;

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    @Override
    public String toString() {
        return "Data{" +
                "statement_key='" + statement_key + '\'' +
                ", statement_value='" + statement_value + '\'' +
                '}';
    }

    public String getStatement_key() {
        return statement_key;
    }

    public void setStatement_key(String statement_key) {
        this.statement_key = statement_key;
        Num++;
    }

    public String getStatement_value() {
        return statement_value;
    }

    public void setStatement_value(String statement_value) {
        this.statement_value = statement_value;
    }

    public Data() {
    }

    public Data(String statement_key, String statement_value) {
        this.statement_key = statement_key;
        this.statement_value = statement_value;
    }
}

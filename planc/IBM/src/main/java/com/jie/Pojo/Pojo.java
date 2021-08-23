package com.jie.Pojo;

import java.util.List;

public class Pojo {
    private String statement;
    private List<String> value;

    @Override
    public String toString() {
        return "Pojo{" +
                "statement='" + statement + '\'' +
                ", value=" + value +
                '}';
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public Pojo() {
    }

    public Pojo(String statement, List<String> value) {
        this.statement = statement;
        this.value = value;
    }
}

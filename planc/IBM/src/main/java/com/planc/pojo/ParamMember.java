package com.planc.pojo;

import com.planc.service.read.ReadParam;

import java.io.File;
import java.util.List;

public class ParamMember {
    private List<Data> statement;

    public ParamMember(List<String> statement,File file) {
        ReadParam readParam = new ReadParam();
        this.statement = readParam.format2Param(statement,file);
    }

    public List<Data> getStatement() {
        return statement;
    }
}

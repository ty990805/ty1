package com.planc.pojo;



import com.planc.service.read.ReadFormat;

import java.io.File;
import java.util.List;

public class Syntas {
    private List<String> statement;

    public Syntas() {
    }

    public Syntas(File file) {
        ReadFormat readFormat = new ReadFormat();
        this.statement = readFormat.txt2data(file);
    }

    public List<String> getStatement() {
        return statement;
    }

}

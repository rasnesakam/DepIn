package com.emakas.depIn.test.cases.case2.repository;

import com.emakas.depIn.test.cases.case2.dbContext.DbContext;

import java.util.List;

public class SimpleRepository implements Repository{
    private DbContext context;


    @Override
    public List<String> getDatas() {
        return context.getDatas();
    }

    @Override
    public void createData(String str) {
        context.getDatas().add(str);
    }
}

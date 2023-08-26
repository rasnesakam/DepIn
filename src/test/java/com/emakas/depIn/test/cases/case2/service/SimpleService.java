package com.emakas.depIn.test.cases.case2.service;

import com.emakas.depIn.test.cases.case2.repository.Repository;

import java.util.List;

public class SimpleService implements Service{

    private Repository repository;

    @Override
    public void create(String str) {
        repository.createData(str);
    }

    @Override
    public List<String> getAll() {
        return repository.getDatas();
    }
}

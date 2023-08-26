package com.emakas.depIn.test.cases.case2.dbContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DbContext {
    private final String DbString;

    private final List<String> datas = new ArrayList<>(Arrays.asList(
            "Hello, DepIn"
    ));

    public List<String> getDatas(){
        return this.datas;
    }
    public DbContext(String dbString) {
        DbString = dbString;
    }
}

package com.emakas.depIn.utils.mappers.maps;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ClassMaps {
    private final List<ClassMap> classMaps;

    public ClassMaps(List<ClassMap> classMaps) {
        this.classMaps = classMaps;
    }

    public ClassMaps()
    {
        this.classMaps = new ArrayList<>();
    }

    public void addClassMap(ClassMap map)
    {
        this.classMaps.add(map);
    }

    public List<ClassMap> getClassMapsBy(@Nullable Predicate<ClassMap> predicate){
        if (predicate != null){
            return classMaps.stream().filter(predicate).collect(Collectors.toList());
        }
        else return classMaps;
    }

    public Optional<ClassMap> getClassMap(@NotNull Predicate<ClassMap> predicate){
        return classMaps.stream().filter(predicate).findFirst();
    }
}

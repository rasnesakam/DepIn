package com.experimentalsoftwares.depInJava.core;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import com.experimentalsoftwares.depInJava.utils.shared.DependentHolder;
import static com.experimentalsoftwares.depInJava.core.ClassMapContext.InjectTypes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DepIn {

    private ClassMapContext context;

    private DepIn(){}

    public static DepIn JsonContext(String classMapFile){
        DepIn depIn = new DepIn();
        depIn.context = new ClassMapContext();
        depIn.context.setClassMapsFromJSON(classMapFile);
        return depIn;
    }

    public <T> T getInstance(String identifier){
        try{
            Class<T> target = context.getTargetClass(identifier);

            Map<ClassMapContext.InjectTypes, List<DependentHolder>> dependents
                    = context.getDependents(identifier);

            // Instantiate dependencies
            dependents.forEach((k,v)->{
                for (DependentHolder holder : v){
                    if (holder.getPredefined() == null){
                        holder.setPredefined(getInstance(holder.getCls().getName()));
                    }
                }
            });

            // Create instance builder with target class
            InstanceBuilder<T> builder = InstanceBuilder.init(target);

            // Inject constructor args
            if (dependents.get(ARG) != null)
                builder.withArgs(
                        dependents.get(ARG)
                                .stream()
                                .map(DependentHolder::getPredefined)
                                .toArray()
                );

            // Inject setter dependencies
            if (dependents.get(SET) != null)
                builder.withSetters(
                        dependents.get(SET)
                                .stream()
                                .collect(
                                        Collectors.toMap(DependentHolder::getLabel,DependentHolder::getPredefined)
                                )
                );

            // Inject field dependencies
            if (dependents.get(FIELD) != null)
                builder.withFields(
                        dependents.get(FIELD)
                                .stream()
                                .collect(
                                        Collectors.toMap(DependentHolder::getLabel,DependentHolder::getPredefined)
                                )
                );

            return builder.build();
        }catch (ClassNotFoundException e){
            throw new ClassBuildException(e.getMessage());
        }
    }
}

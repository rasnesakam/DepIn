package com.experimentalsoftwares.depInJava.core;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import com.experimentalsoftwares.depInJava.utils.shared.DependentHolder;
import static com.experimentalsoftwares.depInJava.core.ClassMapContext.InjectTypes.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>DepIn</h1>
 * <p>DepIn is useful for instantiate complex class structures</p>
 * @author Ensar Makas
 */
public class DepIn {

    private final ClassMapContext context;

    private DepIn(ClassMapContext context){
        this.context = context;
    }

    private void instantiateDependents(Map<ClassMapContext.InjectTypes,List<DependentHolder>> dependents)   {
        dependents.forEach((k,v)->{
            for (DependentHolder holder : v){
                if (holder.getInstance() == null){
                    holder.setInstance(generateInstance(holder.getCls().getName()));
                }
            }
        });
    }

    private void injectConstructor(InstanceBuilder<?> builder,
                                   Map<ClassMapContext.InjectTypes,List<DependentHolder>> dependents)
    {
        if (dependents.get(ARG) != null)
        {
            builder.withArgs(
                    dependents.get(ARG)
                            .stream()
                            .map(DependentHolder::getInstance)
                            .toArray()
            );
        }
    }

    private void injectSetters(InstanceBuilder<?> builder,
                                   Map<ClassMapContext.InjectTypes,List<DependentHolder>> dependents)
    {
        if (dependents.get(SET) != null)
        {
            builder.withSetters(
                    dependents.get(SET)
                            .stream()
                            .collect(
                                    Collectors.toMap(DependentHolder::getLabel,DependentHolder::getInstance)
                            )
            );
        }
    }

    private void injectFields(InstanceBuilder<?> builder,
                               Map<ClassMapContext.InjectTypes,List<DependentHolder>> dependents)
    {
        if (dependents.get(FIELD) != null)
        {
            builder.withFields(
                    dependents.get(FIELD)
                            .stream()
                            .collect(
                                    Collectors.toMap(DependentHolder::getLabel,DependentHolder::getInstance)
                            )
            );
        }
    }

    public static DepIn JsonContext(String path){
        DepIn depIn = new DepIn(ClassMapContext.fromJson(path));
        return depIn;
    }

    public <T> T generateInstance(String identifier){
        try{
            Class<T> target = context.getTargetClass(identifier);
            Map<ClassMapContext.InjectTypes, List<DependentHolder>> dependents;
            InstanceBuilder<T> builder = InstanceBuilder.init(target);

            dependents = context.getDependents(identifier);
            instantiateDependents(dependents);
            injectConstructor(builder,dependents);
            injectSetters(builder,dependents);
            injectFields(builder, dependents);


            return builder.build();
        }catch (ClassNotFoundException e){
            throw new ClassBuildException(e.getMessage());
        }
    }
}

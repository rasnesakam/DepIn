package com.experimentalsoftwares.depInJava.core;

import com.experimentalsoftwares.depInJava.utils.exceptions.ClassBuildException;
import com.experimentalsoftwares.depInJava.utils.mappers.maps.ClassMap;
import com.experimentalsoftwares.depInJava.utils.mappers.maps.ClassMaps;
import com.experimentalsoftwares.depInJava.utils.mappers.maps.MapBuilder;
import com.experimentalsoftwares.depInJava.utils.shared.DependentHolder;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ClassMapContext {
    private ClassMaps classMaps;

    /**
     * <p>
     *     Get dependent class or objects of identified class with identifier <b>identifier</b>
     * </p>
     * <p>
     *     If <b>identifier</b> starts with <b>":d/"</b>,<b>":f/"</b>,<b>":i/"</b>,<b>":s/"</b> or<br>
     *     <b>":x/"</b>, That means the identifier is predefined value.
     * </p>
     * <table border="1">
     *   <tr>
     *     <td> :d/ </td> <td>Predefined <b>double</b> values</td>
     *   </tr>
     *   <tr>
     *     <td> :f/ </td> <td>Predefined <b>float</b> values</td>
     *   </tr>
     *   <tr>
     *     <td> :i/ </td> <td>Predefined <b>integer</b></td>
     *   </tr>
     *   <tr>
     *     <td> :s/ </td> <td>Predefined <b>string</b> values</td>
     *   </tr>
     *   <tr>
     *     <td> :x/ </td> <td>Predefined <b>integer</b> values represented by hexadecimal values</td>
     *   </tr>
     * </table>
     * <p>
     *     Else, identifier will be search in ClassMap. If couldn't found there, identifier will be use as class name <br>
     *     If couldn't find anything, {@link ClassBuildException} will be thrown
     * </p>
     *
     * @author Ensar MAKAS
     * @since 03.04.2022
     * @param identifier String identifier for target class
     * @return {@link DependentHolder} for holding dependent object, class and their labels
     */
    private DependentHolder getDependent(String identifier){
        DependentHolder holder = new DependentHolder();
        if (identifier.startsWith(":")){
            switch (identifier.substring(0,3)){
                case ":d/" -> holder.setPredefined(Double.parseDouble(identifier.substring(3)));
                case ":f/" -> holder.setPredefined(Float.parseFloat(identifier.substring(3)));
                case ":i/" -> holder.setPredefined(Integer.parseInt(identifier.substring(3)));
                case ":s/" -> holder.setPredefined(identifier.substring(3));
                case ":x/" -> holder.setPredefined(Integer.parseInt(identifier.substring(3),16));
            }
        }
        else {
            try {
                holder.setCls(getTargetClass(identifier));
            } catch (ClassNotFoundException e) {
                throw new ClassBuildException(String.format(
                        "Dependent with identifier '%s' couldn't resolved",
                        identifier
                ));
            }
        }
        return holder;
    }


    /**
     * <p>
     *     Searches <b>identifier</b> in {@link ClassMaps}
     * </p>
     * <p>
     *     If identifier starts with "@", that means the identifier represents the id of a {@link ClassMap}<br>
     *     Program will search {@link ClassMap} with given id
     * </p>
     * <p>
     *     If identifier starts with "#", that means the identifier represents the reference (ref) of a {@link ClassMap}
     *     <br>
     *     Program will search {@link ClassMap} by it's ref
     * </p>
     * <p>
     *     By default, program will search {@link ClassMap} by it's target
     * </p>
     * @author Ensar MAKAS
     * @since 03.04.2022
     * @param identifier
     * @return {@link Optional<ClassMap>: Optional ClassMap}
     */
    private Optional<ClassMap> getClassMap(String identifier){
        return  classMaps.getClassMap(
                classMap -> switch (identifier.substring(0,1)){
                    case "@" -> classMap.id != null && classMap.id.equals(identifier.substring(1));
                    case "#" -> classMap.ref != null && classMap.ref.equals(identifier.substring(1));
                    default -> classMap.target != null && classMap.target.equals(identifier.substring(1));
                }
        );
    }

    public enum InjectTypes{
        ARG,FIELD,SET
    }


    public void setClassMapsFromJSON(String classMapsPath){
        this.classMaps = MapBuilder.fromJsonMap(classMapsPath);
    }

    /**
     * <p>
     *      Searches <b>identifier</b> in defined class maps. If couldn't found, use identifier as class name and <br>
     *      try to create Class with type <b>T</b>.<br>
     *      If all fail, The exception <b>{@link ClassNotFoundException}</b> will be thrown
     * </p>
     * @param identifier
     * @param <T>
     * @return Class with type T
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("unchecked")
    public <T> Class<T> getTargetClass(String identifier) throws ClassNotFoundException {
        Class<?> cls;
        Optional<ClassMap> optionalClassMap = getClassMap(identifier);
        String target = optionalClassMap.isPresent() ? optionalClassMap.get().target : identifier;
        try{
            cls = Class.forName(target);
        }catch (ClassNotFoundException e){
            throw new ClassNotFoundException(String.format(
                    "Couldn't find class '%s'",
                    target
            ));
        }
        try {
            return (Class<T>) cls;
        } catch (ClassCastException e) {
            throw new ClassNotFoundException("Class types does not match");
        }
    }

    /**
     * <p>
     *      Gets dependents for spesific identifier. It holds dependents with injection types
     * </p>
     * @author Ensar MAKAS
     * @since 03.04.2022
     * @param identifier
     * @return
     */
    public Map<InjectTypes, List<DependentHolder>> getDependents(String identifier){

        Map<InjectTypes,List<DependentHolder>> dependentsMap
                = new HashMap<>();
        Optional<ClassMap> classMap = getClassMap(identifier);
        if (classMap.isPresent()){

            // Constructor args
            if (classMap.get().args != null){
                List<DependentHolder> dependentHolders = new ArrayList<>();
                for (String s : classMap.get().args){
                    dependentHolders.add(getDependent(s));
                }
                dependentsMap.put(InjectTypes.ARG,dependentHolders);
            }

            // Setters
            if (classMap.get().setters != null){
                List<DependentHolder> dependentHolders = new ArrayList<>();
                for (Map.Entry<String,String> entry : classMap.get().setters.entrySet()){
                    DependentHolder holder = getDependent(entry.getValue());
                    holder.setLabel(entry.getKey());
                    dependentHolders.add(holder);
                }
                dependentsMap.put(InjectTypes.SET,dependentHolders);
            }

            // Fields
            if (classMap.get().fields != null){
                List<DependentHolder> dependentHolders = new ArrayList<>();
                for (Map.Entry<String,String> entry : classMap.get().fields.entrySet()){
                    DependentHolder holder = getDependent(entry.getValue());
                    holder.setLabel(entry.getKey());
                    dependentHolders.add(holder);
                }
                dependentsMap.put(InjectTypes.FIELD,dependentHolders);
            }

        }
        else throw new ClassBuildException(String.format(
                "Dependent with identifier '%s' couldn't resolved",
                identifier
        ));
        return dependentsMap;
    }

}

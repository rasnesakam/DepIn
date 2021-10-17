package com.experimentalsoftwares.depInJava.utils.resolvers;

import com.experimentalsoftwares.depInJava.utils.exceptions.ResolverException;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMaps;

public class MapResolver {

    private ClassMaps classMaps;

    public ClassHolder resolve(ClassMap classMap){
        try{
            Class target = Class.forName(classMap.getTargetClassName());
            ClassHolder[] holders;
            if(classMap.getConstructor() != null){


            }
            else if (classMap.getSetters().size() > 0){

            }
            else if (classMap.getFields().size() > 0){

            }
        }
        catch (Exception e){
            throw new ResolverException("This map couldn't resolved. ",e);
        }
        return null;
    }

    public ClassHolder resolveById(){
        return null;
    }
    public ClassHolder resolveByReference(){
        return null;
    }
}

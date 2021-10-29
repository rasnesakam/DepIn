package com.experimentalsoftwares.depInJava.utils.resolvers;

import com.experimentalsoftwares.depInJava.utils.exceptions.ResolverException;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMap;
import com.experimentalsoftwares.depInJava.utils.mappers.abstracts.ClassMaps;

public class MapResolver {

    private ClassMaps classMaps;

    /**
     *
     * @param classMap map of the requested
     * @return Array of {@link Class} arrays that length of 3. First element is target,
     */
    public ClassBundle resolve(ClassMap classMap){
         ClassBundle bundle = new ClassBundle();
        try{
            Class targetClass = Class.forName(classMap.getTargetClassName());

        }
        catch (Exception e){
            throw new ResolverException("This map couldn't resolved. ",e);
        }
        return null;
    }

    public ClassBundle resolveById(){
        return null;
    }
    public ClassBundle resolveByReference(){
        return null;
    }
}

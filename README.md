# DepIn

DepIn is a Dependency Injection library for java
---

## What Is Dependency Injection
Dependency injection simply means that providing dependencies to spesific instances automatically.  
And the dependency means instances that the particular instance needs to do it's job.

## Simple usage
The simples usage of this library is:

```Java

DefaultClass defaultClass = InstanceBuilder.init(DefaultClass.class).build();

```

This way, we create a `defaultClass` instance with all dependencies.  
Note that we create dependencies of this instance **from scratch**.
  
If we want to pass spesific argument to instance's constructor method, we may use:

We use `withArgs(Object... args)` chain method for injecting arguments with constructor

```Java
ExampleClass ec = InstanceBuilder
        .init(ExampleClass.class)
        .withArgs("ConstructorStringArg")
        .build();
```

There is other ways to instantiate classes. For example, setters.
We can simply inject dependencies with setters like this:

Firstly, we need a map to store and match setter and their arguments

```Java

Map<String,Object> setterMap;

```
And then, we need to describe our setter methods and their arguments

```Java

setterMap.put("setSecretString","Selam");

```

Finally, we can use our map in `withSetters(Map<String,Object> setters)` chain method to create instance

```Java
ExampleClass ec = InstanceBuilder
        .init(ExampleClass.class)
        .withSetters(setterMap)
        .build();

```

We can similarly inject our dependencies directly with fields.  
We just use `withFields(Map<String,Object> setters)` chain method.  
This is inject the spesific fields that named in map with the corresponding object arguments

## Advanced Use Cases
There is better ways to use this library.  
Firstly, let's checkout `ClassMaps` and `ClassMap` classes. You can check it out them from [ClassMaps doc] and [ClassMap doc].  
`ClassMaps` instances holds bunch of several `ClassMap` instances.  
`ClassMap` instances are using for store datas of instance of the class that will be injected.
`ClassMap` instances have some fields like `id`, `ref`, `target`,`args`,`fields` and `setters`.  
Library uses these fields to identify classes and their dependencies.


[ClassMaps Doc]: /docs/CLassMaps.md
[ClassMap doc]: /docs/ClassMap.md
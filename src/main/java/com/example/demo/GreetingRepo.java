package com.example.demo;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GreetingRepo {
    private static Map<Long, Greeting> greetingMap = new HashMap<Long, Greeting>();

    static {
        initGreet();
    }

    private static void initGreet()
    {
        Greeting greet1 = new Greeting(1, "a");
        Greeting greet2 = new Greeting(2, "b");
        Greeting greet3 = new Greeting(3, "c");

        greetingMap.put(greet1.getId(), greet1);
        greetingMap.put(greet2.getId(), greet2);
        greetingMap.put(greet3.getId(), greet3);
    }

    public Greeting findByID(Long id){
        return greetingMap.get(id);
    }

    public List<Greeting> getAllGreetings() {
        Collection<Greeting> c = greetingMap.values();
        List<Greeting> list = new ArrayList<Greeting>();
        list.addAll(c);
        return list;
    }

    public Greeting save(Greeting newGreeting){
        greetingMap.put(newGreeting.getId(), newGreeting);
        return newGreeting;
    }

    public void delete(Long id){
        greetingMap.remove(id);
    }
}

package com.example.demo3;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends Application {

}









//    private Set<Object> singleton = new HashSet<Object>();
//
//    public HelloApplication() {
////        this.singleton.add(new HelloResource());
//        this.singleton.add(new Feed());
//    }
//    @Override
//    public Set<Object> getSingletons() {
//        return singleton;
//    }
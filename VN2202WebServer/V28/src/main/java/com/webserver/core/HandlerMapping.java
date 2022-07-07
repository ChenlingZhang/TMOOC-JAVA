package com.webserver.core;

import com.webserver.annotation.Controller;
import com.webserver.annotation.RequestMapping;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private static Map<String,MethodMpping> mapping = new HashMap<>();
    static {
        initMapping();
    }

    private static void initMapping(){
        try {
            File dir = new File(
                    DispatcherServlet.class.getClassLoader().getResource("./com/webserver/controller").toURI()
            );
            File[] files = dir.listFiles(f->f.getName().endsWith(".class"));
            for (File file : files) {
                String fileName = file.getName();
                String className = fileName.substring(0,fileName.indexOf("."));
                Class cls = Class.forName("com.webserver.controller."+className);
                if (cls.isAnnotationPresent(Controller.class)){
                    Method[] methods = cls.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)){
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            String annotationValue = requestMapping.value();
                            Object o = cls.newInstance();
                            MethodMpping methodMpping = new MethodMpping(method,o);
                            mapping.put(annotationValue,methodMpping);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MethodMpping getMethod(String path){
        return mapping.get(path);
    }

    public static class MethodMpping{
        private Method method;
        private Object controller;

        public MethodMpping(Method method, Object controller) {
            this.method = method;
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }
    }
}

package com.mycompany.springbasic1102.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DymProxy {//動態代理

    private Object object;

    public DymProxy(Object object) {
        this.object = object;
    }

    public Object getProxy() {
        //獲取當前類別的類加載器，用來加載代理物件所屬的類別
        ClassLoader loader = object.getClass().getClassLoader();
        //獲取當前物件所實作的物件
        Class[] intefaces = object.getClass().getInterfaces();
        //處理者
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               //加入公用程式
               // System.out.printf("Log A... 呼叫的方法: %s, 放置的參數: %s\n", method.getName(), Arrays.toString(args));
               MyLogger.before(object.getClass(), method.getName(), args);
               Object result=method.invoke(object, args);//代理調用目標物件的方法
                //System.out.println("Log B...");
                MyLogger.end(object.getClass(), method.getName(), result);
                return result;
            }
        };

        return Proxy.newProxyInstance(loader, intefaces, h);
    }
}
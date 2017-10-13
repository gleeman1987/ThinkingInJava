package chapter15generics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/13
 * Mail:zhengjun1987@outlook.com
 */
class MixinProxy implements InvocationHandler {
    Map<String,Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object,Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String name = method.getName();
                if (!delegatesByMethod.containsKey(name)) {
                    delegatesByMethod.put(name,pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy = [ null ], method = [" + method + "], args = [" + args + "]");
        String name = method.getName();
        Object delegate = delegatesByMethod.get(name);
        return method.invoke(delegate,args);
    }

    public static Object newInstance(TwoTuple... pairs){
        Class[] classes = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            classes[i] = (Class) pairs[i].second;
        }
        return Proxy.newProxyInstance(pairs[0].first.getClass().getClassLoader(),classes,new MixinProxy(pairs));
    }
}

public class DynamicProxyMixins {
    public static void main(String[] args) {
        TwoTuple[] pairs = {new TwoTuple(new BasicImpl(),Basic.class),new TwoTuple(new TimeStampImpl(),TimeStamped.class),new TwoTuple(new SerialNumberedImpl(),SerialNumbered.class)};
        Object mixin = MixinProxy.newInstance(pairs);
        Basic basic = (Basic) mixin;
        SerialNumbered serialNumbered = (SerialNumbered) mixin;
        TimeStamped timeStamped = (TimeStamped) mixin;
        System.out.println("-------------------------------");
        basic.set("放牛与天气");
        System.out.println("basic.get() = " + basic.get());
        System.out.println("timeStamped.getStamp() = " + timeStamped.getStamp());
        System.out.println("serialNumbered = " + serialNumbered.getSerialNumber());
    }
}

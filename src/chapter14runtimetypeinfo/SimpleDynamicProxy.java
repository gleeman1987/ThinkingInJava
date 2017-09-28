package chapter14runtimetypeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("billie_jean");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        System.out.println("-------------------------------");
        Interface newProxyInstance = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(realObject));
        consumer(newProxyInstance);
    }
}

class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxyHandler.invoke  proxy = [" + proxy.getClass() + "], method = [" + method + "], args = [" + args + "]");
        if (args != null) {
            for (Object arg : args) {
                System.out.println("arg = " + arg);
            }
        }
        return method.invoke(proxied,args);
    }
}

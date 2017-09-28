package chapter14runtimetypeinfo;

import chapter14runtimetypeinfo.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/9/24.
 */
public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        System.out.println("a = " + a);//a = chapter14runtimetypeinfo.packageaccess.C@610455d6
        System.out.println(a.getClass().getCanonicalName());//chapter14runtimetypeinfo.packageaccess.C@610455d6
        a.f();//public C.f()
//        if (a instanceof chapter14runtimetypeinfo.packageaccess.C) {
//
//        }
            callHiddenMethods(a,"g");//public C.g()
            callHiddenMethods(a,"u");//package C.u()
            callHiddenMethods(a,"v");//protected C.v()
            callHiddenMethods(a,"w");//private C.w()
    }

    static void callHiddenMethods(Object object,String methodName) throws Exception {
        Method method = object.getClass().getDeclaredMethod(methodName);
//        public Method[] getMethods()返回某个类的所有公用（public）方法包括其继承类的公用方法，当然也包括它所实现接口的方法。
//        public Method[] getDeclaredMethods()对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。当然也包括它所实现接口的方法。
        method.setAccessible(true);
        Object invoke = method.invoke(object);
        System.out.println("invoke = " + invoke);//invoke = null
    }
}

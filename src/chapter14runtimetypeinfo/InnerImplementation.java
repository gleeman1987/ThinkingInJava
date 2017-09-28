package chapter14runtimetypeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InnerImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = InnerA.createA();
        a.f();
        invokeHiddenMethod(a,"g");
        invokeHiddenMethod(a,"u");
        invokeHiddenMethod(a,"v");
        invokeHiddenMethod(a,"w");
//        public C.f()
//        public C.g()
//        package C.u()
//        protected C.v()
//        private C.w()
    }

    static void invokeHiddenMethod(Object object,String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method declaredMethod = object.getClass().getDeclaredMethod(methodName);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(object);
    }
}

class InnerA {
    private static class C implements A {

        @Override
        public void f() {
            System.out.println("public C.f()");
        }

        public void g(){
            System.out.println("public C.g()");
        }

        void u(){
            System.out.println("package C.u()");
        }

        protected void v(){
            System.out.println("protected C.v()");
        }

        private void w(){
            System.out.println("private C.w()");
        }
    }

    public static A createA(){
        return new C();
    }
}

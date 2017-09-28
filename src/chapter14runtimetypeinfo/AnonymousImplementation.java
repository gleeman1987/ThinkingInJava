package chapter14runtimetypeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnonymousImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = AnonymousA.createA();
        a.f();
        invokeHiddenMethod(a,"g");
        invokeHiddenMethod(a,"u");
        invokeHiddenMethod(a,"v");
        invokeHiddenMethod(a,"w");
//        public A.f()
//        public A.g()
//        package A.u()
//        protected A.v()
//        private A.w()
    }

    static void invokeHiddenMethod(Object object,String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method declaredMethod = object.getClass().getDeclaredMethod(methodName);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(object);
    }
}

class AnonymousA {

    public static A createA(){
        return new A(){
            @Override
            public void f() {
                System.out.println("public A.f()");
            }

            public void g(){
                System.out.println("public A.g()");
            }

            void u(){
                System.out.println("package A.u()");
            }

            protected void v(){
                System.out.println("protected A.v()");
            }

            private void w(){
                System.out.println("private A.w()");
            }
        };
    }
}

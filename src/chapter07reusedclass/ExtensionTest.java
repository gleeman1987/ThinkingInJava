package chapter07reusedclass;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/5/22.
 */
public class ExtensionTest {
    public static void main(String[] args) {
        ExtensionTest extensionTest = new ExtensionTest();
        extensionTest.test();
    }

    private void test() {
        Cartoon cartoon = new Cartoon();
        cartoon.flow();
    }


    class Art{
        String name;
        public Art(String name) {
            this.name = name;
            System.out.println("Art.Art");
        }

        public Art() {
            System.out.println("Art.EmptyConstructor");
        }

        void flow(){
            System.out.println("Art.flow");
        }
    }

    class Drawing extends Art {
        public Drawing() {
            System.out.println("Drawing.Constructor");
        }

        public Drawing(String name) {
            this.name = name;
            System.out.println("Drawing.Drawing");
        }

        @Override
        void flow() {
            super.flow();
            System.out.println("Drawing.flow");
        }
    }

    class Cartoon extends Drawing{
        public Cartoon() {
            super();
            System.out.println("Cartoon.Constructor");
        }


        @Override
        void flow() {
            super.flow();
            System.out.println("Cartoon.flow");
            System.out.println("name = "+name);
        }
    }
}

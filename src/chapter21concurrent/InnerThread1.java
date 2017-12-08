package chapter21concurrent;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/12/8
 * Mail:zhengjun1987@outlook.com
 */
public class InnerThread1 {
    private int countdown = 5;
    private Inner inner;
    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(MyUtils.getCurrentTime() +this);
                    if (countdown-- == 0) {
                        return;
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e){
                System.out.println(MyUtils.getCurrentTime() + "e = " + e);
            }
        }

        @Override
        public String toString() {
            return getName()+"("+countdown+")";
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

class InnerThread2 {
    private int countdown = 5;
    private Thread thread;

    public InnerThread2(String name) {
        thread = new Thread(name){
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println(MyUtils.getCurrentTime() +this);
                        if (countdown-- == 0) {
                            return;
                        }
                        Thread.sleep(100);
                    }
                } catch (Exception e){
                    System.out.println(MyUtils.getCurrentTime() + "e = " + e);
                }
            }

            @Override
            public String toString() {
                return getName()+"("+countdown+")";
            }
        };
        thread.start();
    }
}

class InnerRunnable1 {
    private int countdown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        this.inner = new Inner(name);
    }

    private class Inner implements Runnable {
        private Thread thread;

        public Inner(String name) {
            this.thread = new Thread(this,name);
            this.thread.start();
        }

        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(MyUtils.getCurrentTime() +this);
                    if (countdown-- == 0) {
                        return;
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e){
                System.out.println(MyUtils.getCurrentTime() + "e = " + e);
            }
        }

        @Override
        public String toString() {
            return thread.getName()+"("+countdown+")";
        }
    }
}

class InnerRunnable2 {
    private int countdown = 5;
    private Thread thread;

    public InnerRunnable2(String name) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        System.out.println(MyUtils.getCurrentTime() +this);
                        if (countdown-- == 0) {
                            return;
                        }
                        Thread.sleep(100);
                    }
                } catch (Exception e){
                    System.out.println(MyUtils.getCurrentTime() + "e = " + e);
                }
            }

            @Override
            public String toString() {
                return thread.getName()+"("+countdown+")";
            }
        },name);
        thread.start();
    }
}

class ThreadMethod{
    private int countdown = 5;
    private Thread thread;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask(){
        if (thread == null) {
            thread = new Thread(name){
                @Override
                public void run() {
                    try {
                        while (true){
                            System.out.println(MyUtils.getCurrentTime() +this);
                            if (countdown-- == 0) {
                                return;
                            }
                            Thread.sleep(100);
                        }
                    } catch (Exception e){
                        System.out.println(MyUtils.getCurrentTime() + "e = " + e);
                    }
                }

                @Override
                public String toString() {
                    return thread.getName()+"("+countdown+")";
                }
            };
        }
        thread.start();
    }
}


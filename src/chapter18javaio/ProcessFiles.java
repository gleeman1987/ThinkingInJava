package chapter18javaio;

import java.io.File;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/14
 * Mail:zhengjun1987@outlook.com
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(){
        processDirectoryTree(new File("."));
    }

    public void processDirectoryTree(File file) {
        for (File f : Directory.walk(file.getAbsolutePath(),".*\\."+ext)) {
            strategy.process(f);
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        },"java").start();
    }
}

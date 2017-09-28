package chapter13charsequence;

public class DirectoryNameSplit {
    public static void main(String[] args) {
        String[] strings = "http://www.cnblogs.com/dyllove98/archive/2013/06/20/3147033.html".split("/");
        System.out.println("strings[strings.length-1] = " + strings[strings.length - 1]);
    }
}

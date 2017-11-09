package chapter17containeradvanced;

import java.util.*;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/9
 * Mail:zhengjun1987@outlook.com
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();
        strings.add("An Object");//第16行和第17行分别同时操作同一个容器,引发同步修改异常
        try {
            String next = iterator.next();//java.util.ConcurrentModificationException
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

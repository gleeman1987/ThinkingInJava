package chapter10innerclass.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/7/6.
 */
public class Controller {
    private List<Event> list = new ArrayList<Event>();

    public boolean add(Event event) {
        return list.add(event);
    }

    public void run(){
        while (list.size() > 0){
            for (Event event : list) {
                if (event.ready()) {
                    System.out.println(event);
                    event.action();
                    list.remove(event);
                }
            }
        }
    }
}

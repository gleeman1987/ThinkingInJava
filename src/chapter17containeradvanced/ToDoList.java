package chapter17containeradvanced;

import java.util.PriorityQueue;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/28
 * Mail:zhengjun1987@outlook.com
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem>{
    static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(char primary, int secondary, String item) {
            this.primary = primary;
            this.secondary = secondary;
            this.item = item;
        }

        @Override
        public String toString() {
            return "ToDoItem{" +
                    "primary=" + primary +
                    ", secondary=" + secondary +
                    ", item='" + item + '\'' +
                    '}';
        }

        @Override
        public int compareTo(ToDoItem o) {
            if (primary > o.primary) {
                return +1;
            }
            if (primary == o.primary) {
                if (secondary > o.secondary) {
                    return +1;
                } else if (secondary == o.secondary){
                    return 0;
                }
            }
            return -1;
        }
    }

    public void add(char c,int i,String s){
        super.add(new ToDoItem(c,i,s));
    }

    public static void main(String[] args) {
        ToDoList toDoItems = new ToDoList();
        toDoItems.add('C',4,"扔垃圾");
        toDoItems.add('A',2,"喂猫");
        toDoItems.add('A',3,"东方不败");
        toDoItems.add('C',3,"喂狗");
        toDoItems.add('A',1,"令狐冲");
        toDoItems.add('B',4,"不胜人生一场醉");
        toDoItems.add('C',2,"断弦");
        toDoItems.add('C',1,"飞龙在天");
        for (int i = 0; i < toDoItems.size(); i++) {
            System.out.println(toDoItems.peek());
        }
        while (!toDoItems.isEmpty())
            System.out.println(toDoItems.remove());
    }

}

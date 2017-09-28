package chapter10innerclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/6/29.
 */
public class BallGame {
    static class Match{
        private int i,j,sum,product;

        public Match(int i, int j) {
            this.i = i;
            this.j = j;
            sum = i+j;
            product = i*j;
        }

        public int getSum() {
            return sum;
        }

        public int getProduct() {
            return product;
        }

        @Override
        public String toString() {
            return "Match{" +
                    "i=" + i +
                    ", j=" + j +
                    ", sum=" + sum +
                    ", product=" + product +
                    '}';
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            integers.add(i+1);
        }
        ArrayList<Match> matches = new ArrayList<Match>();
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i+1; j < integers.size(); j++) {
                Match match = new Match(integers.get(i), integers.get(j));
//                System.out.println(match);
                matches.add(match);
            }
        }
        HashMap<Integer, ArrayList<Match>> integerMatchHashMap = new HashMap<Integer, ArrayList<Match>>();
        for (Match match : matches) {
            int product = match.getProduct();
            if (integerMatchHashMap.containsKey(product)) {
                integerMatchHashMap.get(product).add(match);
            }else {
                ArrayList<Match> matchArrayList = new ArrayList<Match>();
                matchArrayList.add(match);
                integerMatchHashMap.put(product,matchArrayList);
            }
        }

        Set<Integer> integerSet = integerMatchHashMap.keySet();
        for (Integer integer : integerSet) {
            ArrayList<Match> matchArrayList = integerMatchHashMap.get(integer);
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<Integer, Integer>();
            if (matchArrayList.size() > 1) {
                System.out.print("积:"+integer +"\t\t");
                for (Match match : matchArrayList) {
                    System.out.print(match.getSum()+"\t");
                    int sum = match.getSum();
//                    integerIntegerHashMap.
                    if (integerIntegerHashMap.containsKey(sum)) {
                        Integer integer1 = integerIntegerHashMap.get(sum);
                        integerIntegerHashMap.put(sum,integer1+1);
                    } else {
                        integerIntegerHashMap.put(sum,1);
                    }
                }
                System.out.println();
//                for (Integer integer1 : integerIntegerHashMap.keySet()) {
//                    System.out.println("和"+integer1+"出现次数:"+integerIntegerHashMap.get(integer1));
//                }
            }
        }
    }
}

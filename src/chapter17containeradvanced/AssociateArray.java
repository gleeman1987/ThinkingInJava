package chapter17containeradvanced;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class AssociateArray<K,V> {
    private Object[][] pairs;
    private int index;

    public AssociateArray(int length) {
        this.pairs = new Object[length][2];
    }

    public void put(K k,V v){
        if (index >= pairs.length) {
            throw new IndexOutOfBoundsException();
        }
        pairs[index++]=new Object[]{k,v};
    }

    public V get(K k){
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0].equals(k))
                return (V) pairs[i][1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pairs.length; i++) {
            stringBuilder.append(pairs[i][0].toString());
            stringBuilder.append(":");
            stringBuilder.append(pairs[i][1].toString());
            if (i < pairs.length -1)
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        AssociateArray<String, String> stringStringAssociateArray = new AssociateArray<>(6);
        stringStringAssociateArray.put("天下风云出我辈","一入江湖岁月催");
        stringStringAssociateArray.put("皇图霸业笑谈中","不胜人生一场醉");
        stringStringAssociateArray.put("沧海一声笑","滔滔两岸潮");
        stringStringAssociateArray.put("浮沉随浪","只记今朝");
        stringStringAssociateArray.put("苍生笑","不在寂寥");
        stringStringAssociateArray.put("豪情仍在","痴痴笑笑");

        System.out.println(stringStringAssociateArray);
        System.out.println();
        System.out.println(stringStringAssociateArray.get("皇图霸业笑谈中"));
    }
}

package chapter17containeradvanced;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/6
 * Mail:zhengjun1987@outlook.com
 */
public class TestParam {
    public final int size;
    public final int loops;

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    @Override
    public String toString() {
        return "TestParam{" +
                "size=" + size +
                ", loops=" + loops +
                '}';
    }

    public static TestParam[] array(int... values){
        int size = values.length / 2;
        TestParam[] testParams = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            testParams[i] = new TestParam(values[n++],values[n++]);
        }
        for (int i = 0; i < testParams.length; i++) {
            System.out.println("i = " + testParams[i]);
        }
        return testParams;
    }

    public static TestParam[] array(String... values){
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}

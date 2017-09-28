package chapter13charsequence;

public class FornatizedOutput {
    public static void main(String[] args) {
        int d = (1<<16)-1;
        double f = Math.PI;
        System.out.printf("Row1:[%d %f]\n",d,f);//Row1:[65535 3.141593]
        System.out.format("Row1:[%s %f]\n",d,f);//Row1:[65535 3.141593]
        System.out.println("Row1:["+d+" "+f+"]");

    }
}

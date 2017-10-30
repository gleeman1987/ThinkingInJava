package chapter17containeradvanced;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/30
 * Mail:zhengjun1987@outlook.com
 */
public class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog #"+number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Groundhog && ((Groundhog) obj).number== this.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}

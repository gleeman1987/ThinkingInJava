package chapter15generics;

import chapter14runtimetypeinfo.People;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/11
 * Mail:zhengjun1987@outlook.com
 */
public class ComparablePet implements Comparable<ComparablePet> {
    private People people;
    private String name;

    @Override
    public int compareTo(ComparablePet comparablePet) {
        return this.name.compareTo(comparablePet.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComparablePet that = (ComparablePet) o;

        if (people != null ? !people.equals(that.people) : that.people != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = people != null ? people.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

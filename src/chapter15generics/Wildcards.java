package chapter15generics;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/10/10
 * Mail:zhengjun1987@outlook.com
 */
public class Wildcards {
    static void rawArgs(Holder holder,Object arg){
        holder.set(arg);
        Object o = holder.get();
        System.out.println("holder.get() = " + o);
    }

    static void unboundedArg(Holder<?> holder,Object arg){
//        holder.set(arg);
        System.out.println("holder.get() = " + holder.get());
    }

    static <T> T exact1(Holder<T> holder){
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder,T item){
        holder.set(item);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder,T arg){
//        holder.set(arg);无法接受类型为T的参数,类型可能不匹配
        return holder.get();
    }

    static <T> Object wildSupertyoe(Holder<? super T> holder,T arg){
        holder.set(arg);
        Object object = holder.get();//只能返回Object对象
        return holder.get();
    }



    public static void main(String[] args) {
        Holder raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        rawArgs(raw,lng);
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bounded,lng);

        unboundedArg(raw,lng);
        unboundedArg(qualified,lng);
        unboundedArg(unbounded,lng);
        unboundedArg(bounded,lng);

        System.out.println("------------------------------------------");

        System.out.println("exact1(raw) = " + exact1(raw));
        System.out.println("exact1(qualified) = " + exact1(qualified));
        System.out.println("exact1(unbounded) = " + exact1(unbounded));
        System.out.println("exact1(bounded) = " + exact1(bounded));

        System.out.println("------------------------------------------");

        System.out.println("exact2(raw,2L) = " + exact2(raw, 2L));
        System.out.println("exact2(qualified,2L) = " + exact2(qualified, 2L));
//        System.out.println("exact2(unbounded,2L) = " + exact2(unbounded, 2L));类型不匹配
//        System.out.println("exact2(bounded,2L) = " + exact2(bounded, 2L));类型不匹配

        System.out.println("------------------------------------------");

        System.out.println("wildSubtype(raw,3L) = " + wildSubtype(raw, 3L));
        System.out.println("wildSubtype(qualified,3L) = " + wildSubtype(qualified, 3L));
        System.out.println("wildSubtype(unbounded,3L) = " + wildSubtype(unbounded, 3L));
        System.out.println("wildSubtype(bounded,3L) = " + wildSubtype(bounded, 3L));

        System.out.println("------------------------------------------");

        System.out.println("wildSupertyoe(raw,4L) = " + wildSupertyoe(raw, 4L));
        System.out.println("wildSupertyoe(qualified,4L) = " + wildSupertyoe(qualified, 4L));
//        System.out.println("wildSupertyoe(unbounded,4L) = " + wildSupertyoe(unbounded, 4L));
//        System.out.println("wildSupertyoe(bounded,4L) = " + wildSupertyoe(bounded, Long.valueOf(4L)));

    }
//        holder.get() = 1
//        holder.get() = 1
//        holder.get() = 1
//        holder.get() = 1
//        holder.get() = 1
//        holder.get() = 1
//        holder.get() = 1
//        holder.get() = 1
//        ------------------------------------------
//    exact1(raw) = 1
//    exact1(qualified) = 1
//    exact1(unbounded) = 1
//    exact1(bounded) = 1
//            ------------------------------------------
//    exact2(raw,2L) = 2
//    exact2(qualified,2L) = 2
//            ------------------------------------------
//    wildSubtype(raw,3L) = 2
//    wildSubtype(qualified,3L) = 2
//    wildSubtype(unbounded,3L) = 1
//    wildSubtype(bounded,3L) = 1
//            ------------------------------------------
//    wildSupertyoe(raw,4L) = 4
//    wildSupertyoe(qualified,4L) = 4
}

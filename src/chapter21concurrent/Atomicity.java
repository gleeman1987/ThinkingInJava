package chapter21concurrent;

/**
 * Author:Zheng Jun
 * E-mail:zhengjun1987@outlook.com
 * Date:2017/12/10
 * Project:ThinkingInJava
 */
public class Atomicity {
    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}

//zhengjuns-MacBook-Pro:chapter21concurrent zhengjun$ javap -c Atomicity.class
//Compiled from "Atomicity.java"
//public class chapter21concurrent.Atomicity {
//        int i;
//
//public chapter21concurrent.Atomicity();
//        Code:
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: return
//
//        void f1();
//        Code:
//        0: aload_0
//        1: dup
//        2: getfield      #2                  // Field i:I
//        5: iconst_1
//        6: iadd
//        7: putfield      #2                  // Field i:I
//        10: return
//
//        void f2();
//        Code:
//        0: aload_0
//        1: dup
//        2: getfield      #2                  // Field i:I
//        5: iconst_3
//        6: iadd
//        7: putfield      #2                  // Field i:I
//        10: return
//        }

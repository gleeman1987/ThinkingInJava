package chapter13charsequence.regularexpress;

import java.util.Arrays;

public class Splitting {
    public static final String knights = "Then,when you have found the Shrubberry, you must cut down the mightest tree in the forest with ... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
//[Then,when, you, have, found, the, Shrubberry,, you, must, cut, down, the, mightest, tree, in, the, forest, with, ..., a, herring!]
//[Then, when, you, have, found, the, Shrubberry, you, must, cut, down, the, mightest, tree, in, the, forest, with, a, herring]
//[The, whe, you have found the Shrubberry, you must cut dow, the mightest tree i, the forest with ... a herring!]
    }
}

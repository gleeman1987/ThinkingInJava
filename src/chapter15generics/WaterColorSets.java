package chapter15generics;

import java.util.EnumSet;

public class WaterColorSets {
    public static void main(String[] args) {
        EnumSet<WaterColor> set1 = EnumSet.range(WaterColor.BRILLIANT_RED, WaterColor.VIRIDIAN_HUE);
        System.out.println("set1 = " + set1);
        System.out.println("set1.size() = " + set1.size());
        EnumSet<WaterColor> set2 = EnumSet.range(WaterColor.CERULEAN_BLUE_HUE, WaterColor.BURNT_UMBER);
        System.out.println("set2 = " + set2);
        System.out.println("set2.size() = " + set2.size());

        System.out.println("Sets.difference(set1,set2) = " + Sets.difference(set1, set2));
        System.out.println("Sets.difference(set2,set1) = " + Sets.difference(set2, set1));
        System.out.println("Sets.union(set1,set2) = " + Sets.union(set1, set2));
        System.out.println("Sets.intersection(set1,set2) = " + Sets.intersection(set1, set2));
        System.out.println("Sets.complement(set1,set2) = " + Sets.complement(set1, set2));
//        set1 = [BRILLIANT_RED, CRIMSON, MAGNTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE]
//        set1.size() = 11
//        set2 = [CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER, BURNT_UMBER]
//        set2.size() = 11
//        Sets.difference(set1,set2) = [CRIMSON, VIOLET, ROSE_MADDER, BRILLIANT_RED, MAGNTA]
//        Sets.difference(set2,set1) = [YELLOW_OCHRE, BURNT_UMBER, SAP_GREEN, RAW_UMBER, BURNT_SIENNA]
//        Sets.union(set1,set2) = [YELLOW_OCHRE, BURNT_UMBER, SAP_GREEN, CRIMSON, VIRIDIAN_HUE, VIOLET, PHTHALO_BLUE, PERMANENT_GREEN, ROSE_MADDER, BURNT_SIENNA, MAGNTA, COBALT_BLUE_HUE, RAW_UMBER, CERULEAN_BLUE_HUE, BRILLIANT_RED, ULTRAMARINE]
//        Sets.intersection(set1,set2) = [COBALT_BLUE_HUE, VIRIDIAN_HUE, PHTHALO_BLUE, PERMANENT_GREEN, CERULEAN_BLUE_HUE, ULTRAMARINE]
//        Sets.complement(set1,set2) = [YELLOW_OCHRE, BURNT_UMBER, SAP_GREEN, VIRIDIAN_HUE, PHTHALO_BLUE, PERMANENT_GREEN, BURNT_SIENNA, COBALT_BLUE_HUE, RAW_UMBER, CERULEAN_BLUE_HUE, ULTRAMARINE]
    }
}

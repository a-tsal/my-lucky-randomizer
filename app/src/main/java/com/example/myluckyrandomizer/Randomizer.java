package com.example.myluckyrandomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {

    public static String randomize(int min, int max, int n, boolean replacement) {

        String res = "";

        if (min >= max)
            res = "Error: The minimum possible number cannot be greater or equal to the maximum passible number";

        else {
            int length = (max - min) + 1;
            int[] elements = new int[length];
            if (length < n && replacement == false)
                res = "Error: If the replacement is off, then the range of the possible numbers cannot be less than the numbers to be drawn";
            else {
                for (int i = 0; i < length; i++) elements[i] = min + i;
                List<Integer> drawnList = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    int index;
                    Random rand = new Random();
                    index = rand.nextInt(length);
                    if (replacement == false)
                        while (drawnList.contains(elements[index])) index = rand.nextInt(length);
                    drawnList.add(elements[index]);
                    if (i == 0) res = res + drawnList.get(i);
                    else res = res + ", " + drawnList.get(i);
                }
            }
        }
        return res;
    }
}

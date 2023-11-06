package org.example;

import java.util.ArrayList;

public class BubbleSorting implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = 0; j < input.size() - i - 1; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }
        return input;
    }
}

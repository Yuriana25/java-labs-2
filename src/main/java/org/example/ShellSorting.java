package org.example;

import java.util.ArrayList;

public class ShellSorting implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        for (int gap = input.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < input.size(); i += 1) {
                int temp = input.get(i);
                int j;
                for (j = i; j >= gap && input.get(j - gap) > temp; j -= gap) {
                    input.set(j, input.get(j - gap));
                }
                input.set(j, temp);
            }
        }
        return input;
    }
}

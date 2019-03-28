package com.adiaz.search.loosecoupled;

import java.util.Arrays;

public class SortAlgorithmImplB implements SortAlgorithm {
    @Override
    public void sort(int[] numbers) {
        //imagine this is a different sorting algorithm.
        Arrays.sort(numbers);
    }
}

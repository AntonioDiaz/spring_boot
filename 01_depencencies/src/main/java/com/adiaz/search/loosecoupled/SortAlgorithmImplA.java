package com.adiaz.search.loosecoupled;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SortAlgorithmImplA implements SortAlgorithm {
    @Override
    public void sort(int[] numbers) {
        Arrays.sort(numbers);
    }
}

package com.adiaz.search.loosecoupled;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BinarySearchImplAdvanced {

    SortAlgorithm sortAlgorithm;

    public BinarySearchImplAdvanced (SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int search (int[] numbers, int numberToSearchFor) {
        sortAlgorithm.sort(numbers);
        return Arrays.binarySearch(numbers, numberToSearchFor);
    }

}

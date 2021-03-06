package com.adiaz.search.loosecoupled;

import java.util.Arrays;

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

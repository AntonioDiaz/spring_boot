package com.adiaz.search.coupled;

import java.util.Arrays;

public class BinarySearchImpl {

    public int search(int[] numbers, int numberToSearch) {
        Arrays.sort(numbers);
        return Arrays.binarySearch(numbers, numberToSearch);
    }

}

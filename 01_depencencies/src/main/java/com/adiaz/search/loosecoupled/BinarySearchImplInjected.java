package com.adiaz.search.loosecoupled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BinarySearchImplInjected {

    @Inject
    SortAlgorithm sortAlgorithm;

    public int search (int[] numbers, int numberToSearchFor) {
        sortAlgorithm.sort(numbers);
        return Arrays.binarySearch(numbers, numberToSearchFor);
    }

}

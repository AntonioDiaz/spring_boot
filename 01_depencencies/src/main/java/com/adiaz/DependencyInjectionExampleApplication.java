package com.adiaz;

import com.adiaz.search.coupled.BinarySearchImpl;
import com.adiaz.search.loosecoupled.BinarySearchImplAdvanced;
import com.adiaz.search.loosecoupled.SortAlgorithm;
import com.adiaz.search.loosecoupled.SortAlgorithmImplA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionExampleApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(DependencyInjectionExampleApplication.class, args);

        //SpringApplication.run(Application.class, args);
        BinarySearchImpl binarySearch = new BinarySearchImpl();
        int found = binarySearch.search(new int[]{3, 5, 1}, 3);
        System.out.println(
                "Number found in position (after sort): " + found);

        SortAlgorithm sortAlgorithm = new SortAlgorithmImplA();
        BinarySearchImplAdvanced binarySearchImplAdvanced = new BinarySearchImplAdvanced(sortAlgorithm);
        found = binarySearchImplAdvanced.search(new int[]{3, 5, 1}, 3);
        System.out.println(
                "Number found in position (after sort): " + found);

        BinarySearchImplAdvanced bean = applicationContext.getBean(BinarySearchImplAdvanced.class);
        System.out.println(
                "Number found in position (after sort): " + bean.search(new int[]{3, 5, 1}, 3));

        System.out.println("Beans created in context");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("bean -> " + beanDefinitionName);
        }
    }

}

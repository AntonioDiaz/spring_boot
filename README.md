# Spring and Spring Boot training examples

## 01 - Dependencies

* The objective is to create a system with **loosely coupled** classes.  
* We will use **Spring dependency injection**. Steps:  
 1. Create interface:
```java
public interface SortAlgorithm {
    void sort (int[] numbers);
}
```
 2. Create implementation and add the **@Component** annotation
```java
@Component
public class SortAlgorithmImplA implements SortAlgorithm {
    @Override
    public void sort(int[] numbers) {
        Arrays.sort(numbers);
    }
}
```
 3. Create another class that uses the previous component.  
```java
@Component
public class BinarySearchImplInjected {

    SortAlgorithm sortAlgorithm;

    public int search (int[] numbers, int numberToSearchFor) {
        sortAlgorithm.sort(numbers);
        return Arrays.binarySearch(numbers, numberToSearchFor);
    }
}
```
 4. Create the class that uses the beans  
   * **@SpringApplication** includes **@ComponentScan**: tells Spring to look for beans in this directory.
   * **@component** tells Spring to look in this directory. A Spring managed bean candidate for auto-detection via classpath scanning.
   * Component subtypes:
     * **@Controller**: a Spring MVC web controller.
     * **@Repository**: data manager / storage (DAO, DDD).
     * **@Service**: provide business logic - a (stateless) facade.
   * **@Primary**: when declaring beans, you can avoid autowiring ambiguity by designating one candidate bean as primary bean.

```java
@SpringBootApplication
public class DependencyInjectionExampleApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(DependencyInjectionExampleApplication.class, args);

        BinarySearchImplInjected bean = applicationContext.getBean(BinarySearchImplInjected.class);
        System.out.println(
                "Number found in position (after sort): " + bean.search(new int[]{3, 5, 1}, 3));

        System.out.println("Beans created in context");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println("bean -> " + beanDefinitionName);
        }
    }
}
```

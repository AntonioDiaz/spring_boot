# Spring and Spring Boot training examples
<!-- TOC START min:2 max:3 link:true asterisk:false update:true -->
- [01 - Dependencies](#01---dependencies)
    - [@component](#component)
    - [Beans scope](#beans-scope)
    - [CommandLineRunner](#commandlinerunner)
<!-- TOC END -->



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
### @component
tells Spring to look in this directory. A Spring managed bean candidate for auto-detection via classpath scanning.
* Component subtypes:
  * **@Controller**: a Spring MVC web controller.
  * **@Repository**: data manager / storage (DAO, DDD).
  * **@Service**: provide business logic - a (stateless) facade.
* **@Primary**: when declaring beans, you can avoid autowiring ambiguity by designating one candidate bean as primary bean.

### Beans scope
* Singleton: one instance of the bean is created for the entire application.
* Prototype: one instance of the bean is created every time the bean is injected into or retrieve from the Spring application context.
* Session: in a web app, one instance of the bean is created for each session.
* Request: in a web app, one instance of the bean is created for each request.

### CommandLineRunner
* Use to indicate that a bean should be run when it is contained within a SpringApplication.
* Multiple CommandLineRunner beans can be defined within the same application context and can be ordered using the Ordered Interface or @Order annotation.

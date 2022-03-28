package ru.niatomi.beans;

/**
 * @author niatomi
 */
public class BeanD {
    @PostConstruct
    public void initMethod() {
        System.out.println("Bean D init method");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Bean D destroy method");
    }
}

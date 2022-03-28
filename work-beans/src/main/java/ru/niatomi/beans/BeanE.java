package ru.niatomi.beans;

/**
 * @author niatomi
 */
@Component
@Scope("prototype")
public class BeanE {
    @PostConstruct
    public void initMethod() {
        System.out.println("Bean E init method");
    }

    @PreDestroy
    public void destroyMethod() {
        System.out.println("Bean E destroy method");
    }
}

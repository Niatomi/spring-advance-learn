package ru.niatomi.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

package ru.niatomi.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author niatomi
 */
@Component
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

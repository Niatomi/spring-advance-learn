package ru.niatomi.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author niatomi
 */
@Component
public class BeanB {

    @Autowired
    private BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }

    @Getter
    private BeanC beanC;

    @Lookup
    public BeanC createBeanC() {
        return null;
    }

}

package ru.niatomi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.niatomi.beans.BeanA;
import ru.niatomi.beans.BeanB;

/**
 * @author niatomi
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                    "ru.niatomi.beans"
                );

        BeanA beanA = context.getBean(BeanA.class);
        BeanB beanB = context.getBean(BeanB.class);
        beanB.showBeanCString("Hello");
    }
}

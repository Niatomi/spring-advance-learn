package ru.niatomi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.niatomi.beans.BeanA;
import ru.niatomi.beans.BeanB;
import ru.niatomi.beans.BeanD;
import ru.niatomi.beans.BeanE;

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

        BeanD beanD = context.getBean(BeanD.class);
        BeanE beanE = context.getBean(BeanE.class);

        context.close();
    }
}

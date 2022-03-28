package ru.niatomi.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author niatomi
 */
@Component
@Scope("prototype")
public class BeanC {

    @Setter
    @Getter
    private String string;
}

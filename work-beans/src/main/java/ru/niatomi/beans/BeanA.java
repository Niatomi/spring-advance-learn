package ru.niatomi.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author niatomi
 */
@Component
@NoArgsConstructor
public class BeanA {

    private String string;

    public void setString(String string) {
        this.string = string;
    }
}

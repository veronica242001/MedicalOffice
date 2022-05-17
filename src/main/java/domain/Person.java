package domain;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String email;

    public abstract String getName();

}

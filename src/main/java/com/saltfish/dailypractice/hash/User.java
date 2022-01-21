package com.saltfish.dailypractice.hash;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Objects;

/**
 * 用户
 *
 * @author saltfish
 * @date 2021/6/22 10:16
 */
@Data
@Accessors(chain = true)
public class User {

    private String id;
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}

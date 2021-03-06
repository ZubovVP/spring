package ru.zubov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 27.08.2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private int id;
    private Model model;
    private String telephone_number;
    private Person person;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", model=" + model +
                ", telephone_number='" + telephone_number + '\'' +
                ", personId=" + person.getId() +
                '}';
    }
}

package ru.zubov.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 27.08.2021.
 */
@Data
@AllArgsConstructor
public class Contact {
    private int id;
    private Model model;
    private String telephone_number;
    private Person person;
}

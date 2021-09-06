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
public class Model {
    private int id;
    private String model;
}

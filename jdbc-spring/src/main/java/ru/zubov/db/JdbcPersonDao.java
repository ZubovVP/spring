package ru.zubov.db;

import ru.zubov.db.PersonDao;

import javax.sql.DataSource;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $.
 * Date: 02.09.2021.
 */
public class JdbcPersonDao implements PersonDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String findLastNameById(int id) {
        return null;
    }
}

package ru.zubov.db.annotation;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import ru.zubov.db.PersonDao;
import ru.zubov.models.Person;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Intellij IDEA.
 * User: Vitaly Zubov.
 * Email: Zubov.VP@yandex.ru.
 * Version: $Id$.
 * Date: 14.09.2021.
 */
@Repository("personDao")
public class AnnotationJdbcPersonDao implements PersonDao {
    private Log log = LogFactory.getLog(AnnotationJdbcPersonDao.class);
    private DataSource dataSource;

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public String findLastNameById(int id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public List<Person> findAllWithDetail() {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Person person) {

    }
}

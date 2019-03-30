package com.datajdbc;

import com.datajdbc.jdbc.PersonJdbcDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataJdbcApplicationTests {

    @Autowired
    PersonJdbcDAO personJdbcDAO;

    @Test
    public void contextLoads() {
    }

    @Test
    public void dbtest() {
        assertNotNull(personJdbcDAO);
        assertEquals(3,  personJdbcDAO.findAll().size());
    }
}

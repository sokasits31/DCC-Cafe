package com.doorCreekCafe.persistence;

import com.doorCreekCafe.entity.TestHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ejb.Local;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class TestHistoryDaoTests {




    TestHistoryDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        com.doorCreekCafe.test.util.Database database = com.doorCreekCafe.test.util.Database.getInstance();
        database.runSQL("usersTestData.sql");
        dao = new TestHistoryDao();
    }

    @Test
    void getAllUsersSuccess() {

        List<TestHistory> tests = dao.getAllTests();
        assertEquals(25, tests.size());

    }

    /**
     * Verify successful retrieval of a testHistory
     */
    @Test
    void getByIdSuccess() {
        LocalDate expectedDate = LocalDate.parse("2018-10-08");
        TestHistory retreivedTest = dao.getId(3);
        assertEquals(2,retreivedTest.getUserId());
        assertEquals(expectedDate, retreivedTest.getTestDate());
        assertEquals(1, retreivedTest.getTestLevel());
        assertEquals(3,retreivedTest.getMenuIdTested());
       // assertEquals("00:00:45", retreivedTest.getResponseTimeInSeconds());
    }

    /**
     * Verify successful insert of a testHistory
     */
    @Test
    void insertSuccess() {

        // Create Child Object
        LocalDate testDate = LocalDate.parse("2018-11-01");


        TestHistory newTest = new TestHistory(2, testDate, 3, 77, 67);

        int id = dao.insert(newTest);
        assertNotEquals(0,id);

        TestHistory insertedTest = dao.getId(id);
        assertEquals( 77, insertedTest.getMenuIdTested());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of testHistory
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getId(3));
        assertNull(dao.getId(3));
    }


    /**
     * Verify that we can update a TestHistory
     */
    @Test
    void saveOrUpdateSuccess() {
        TestHistory testHistory = dao.getId(1);
        testHistory.setResponseTimeInSeconds(99);
        dao.saveOrUpdate(testHistory);
        TestHistory updatedUser = dao.getId(1);
        assertEquals(99, testHistory.getResponseTimeInSeconds());
    }
}
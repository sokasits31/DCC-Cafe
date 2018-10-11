package com.doorCreekCafe.persistence;

import com.doorCreekCafe.entity.TestScore;
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

        List<TestScore> tests = dao.getAllTests();
        assertEquals(25, tests.size());

    }

    /**
     * Verify successful retrieval of a testScore
     */
    @Test
    void getByIdSuccess() {
        LocalDate expectedDate = LocalDate.parse("2018-10-08");
        TestScore retreivedTest = dao.getId(3);
        assertEquals(2,retreivedTest.getId());
        assertEquals(expectedDate, retreivedTest.getTestDate());
        assertEquals(1, retreivedTest.getTestLevel());
        assertEquals(3,retreivedTest.getMenuIdTested());
       // assertEquals("00:00:45", retreivedTest.getResponseTimeInSeconds());
    }

    /**
     * Verify successful insert of a testScore
     */
    //@Test
    //void insertSuccess() {

        // Create Child Object
 //       LocalDate testDate = LocalDate.parse("2018-11-01");


//        TestScore newTest = new TestScore(2, testDate, 3, 77, 67);

  //      int id = dao.insert(newTest);
    //    assertNotEquals(0,id);

        //TestScore insertedTest = dao.getId(id);
        //assertEquals( 77, insertedTest.getMenuIdTested());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    //}
    /**
     * Verify successful delete of testScore
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getId(3));
        assertNull(dao.getId(3));
    }


    /**
     * Verify that we can update a TestScore
     */
    @Test
    void saveOrUpdateSuccess() {
        TestScore testScore = dao.getId(1);
        testScore.setResponseTimeInSeconds(99);
        dao.saveOrUpdate(testScore);
        TestScore updatedUser = dao.getId(1);
        assertEquals(99, testScore.getResponseTimeInSeconds());
    }
}
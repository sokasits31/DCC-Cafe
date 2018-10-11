package com.doorCreekCafe.persistence;

import com.doorCreekCafe.entity.TestScore;
import com.doorCreekCafe.entity.TestScore;
import com.doorCreekCafe.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class TestScoreDaoTests {


    TestScoreDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        com.doorCreekCafe.test.util.Database database = com.doorCreekCafe.test.util.Database.getInstance();
        database.runSQL("usersTestData.sql");
        dao = new TestScoreDao();
    }

    @Test
    void getAllTestScoresSuccess() {

        List<TestScore> tests = dao.getAllTests();
        assertEquals(25, tests.size());

    }



    /**
     * Verify successful retrieval of a testScore
     */
    @Test
    void getByIdSuccess() {
        
        TestScore retreivedTest = dao.getId(10);
        assertEquals(10,retreivedTest.getResponseTimeInSeconds());
    }

    /**
     * Verify successful insert of a testScore
     */
    @Test
    void insertSuccess() {

        //Get User
        UserDao userDao = new UserDao();
        User user = userDao.getId(1);

        //Create Test Score
        TestScore newTest = new TestScore(LocalDate.parse("2018-09-05"),  1, 25, 99, user);

        //Synce user and test Score
        user.addTestScore(newTest);

        //add score to database
        int id = dao.insert(newTest);
        assertNotEquals(0,id);

        //get inserted score from database
        TestScore insertedTestScore = dao.getId(id);

        assertEquals( 25, insertedTestScore.getMenuIdTested());
        assertNotNull(insertedTestScore.getUser());
        assertEquals("Heather", insertedTestScore.getUser().getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }




    /**
     * Verify successful delete of testScore
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getId(1));
        assertNull(dao.getId(1));
    }


    /**
     * Verify that we can update a TestScore
     */
    @Test
    void saveOrUpdateSuccess() {
        TestScore testScore = dao.getId(2);
        testScore.setMenuIdTested(20);

        dao.saveOrUpdate(testScore);

        TestScore updatedTestScore = dao.getId(2);
        assertEquals(20, updatedTestScore.getMenuIdTested());
    }
}
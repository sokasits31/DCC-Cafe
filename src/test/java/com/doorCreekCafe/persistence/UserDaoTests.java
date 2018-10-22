package com.doorCreekCafe.persistence;

import com.doorCreekCafe.entity.TestScore;
import com.doorCreekCafe.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class UserDaoTests {


    UserDao dao;
    GenericDao genericDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        com.doorCreekCafe.test.util.Database database = com.doorCreekCafe.test.util.Database.getInstance();
        database.runSQL("usersTestData.sql");
        dao = new UserDao();
        genericDao = new GenericDao(User.class);

    }

    @Test
    void getAllUsersSuccess() {
        List<User> tests = genericDao.getAll();
        assertEquals(3, tests.size());

    }



    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        
        User retreivedUser = (User)genericDao.getById(3);
        assertEquals(3,retreivedUser.getId());
        //assertEquals("vol", retreivedUser.getRole().toString());
        assertEquals("lea.sokasits@gmail.com", retreivedUser.getEmailAddress());
        assertEquals("Lea", retreivedUser.getFirstName());
        assertEquals("Sokasits", retreivedUser.getLastName());
        assertEquals(1, retreivedUser.getSkillLevel());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        // Create object
        User newTest = new User("vol", "new@gmail.com", "joe", "blow", 3);

        // Insert object to table
        int id = (int)genericDao.insert(newTest);
        assertNotEquals(0,id);

        User insertedUser = (User) genericDao.getById(11);
        assertEquals( "Heather", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithTestSuccess() {

        //Create Parent Data
        User newUser = new User("vol", "new@gmail.com", "joe", "blow", 3);

        //Create child
        LocalDate testDate = LocalDate.parse("2018-01-01");
        TestScore testScore = new TestScore(testDate, 1, 12, 89,newUser);

        // Sync Child to parent
        newUser.addTestScore(testScore);

        // Insert record and get Id
        int id = (int) genericDao.insert(newUser);
        assertNotEquals(0,id);

        User insertedUser = (User) genericDao.getById(1);
        assertEquals( "Heather", insertedUser.getFirstName());
        assertEquals(1,newUser.getTestScores().size());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }


    /**
     * Verify that we can update a User
     */
    @Test
    void saveOrUpdateSuccess() {
        User user = (User) genericDao.getById(2);
        user.setFirstName("Hector");

        genericDao.saveOrUpdate(user);

        User updatedUser = (User) genericDao.getById(2);
        assertEquals("Hector", updatedUser.getFirstName());
    }

    @Test
    void getByLikeSuccess() {
        List<User> tests = genericDao.getByPropertyLike("emailAddress","gmail.com");
        assertEquals(3, tests.size());

    }

    @Test
    void getByEqualSuccess() {
        List<User> tests = genericDao.getByPropertyEqual("emailAddress","steve.sokasits@gmail.com");
        assertEquals(1, tests.size());

    }
}
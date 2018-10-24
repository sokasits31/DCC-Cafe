package com.doorCreekCafe.persistence;

import com.doorCreekCafe.entity.Role;
import com.doorCreekCafe.entity.TestScore;
import com.doorCreekCafe.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class UserDaoTests {


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
        genericDao = new GenericDao(User.class);

    }

    /**
     * Verify that we we can get all rows
     */
    @Test
    void getAllUsersSuccess() {
        List<User> tests = genericDao.getAll();
        assertEquals(3, tests.size());

    }



    /**
     * Verify that we can get by id
     */
    @Test
    void getByIdSuccess() {
        
        User retreivedUser = (User)genericDao.getById(3);
        assertEquals(3,retreivedUser.getId());
        //assertEquals("vol", retreivedUser.getRole().toString());
        assertEquals("Lea.sokasits@gmail.com", retreivedUser.getEmailAddress());
        assertEquals("Lea", retreivedUser.getFirstName());
        assertEquals("Sokasits", retreivedUser.getLastName());
        assertEquals(2, retreivedUser.getSkillLevel());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("new@gmail.com", "joe", "blow", 2, 2240024, "newuser", "college1");

        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);

        User insertedUser = (User) genericDao.getById(id);
        //assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert new row (Parent then child)
     */
    @Test
    void insertWithTestSuccess() {

        String userName = "newUserId";

        //Create Parent Data
        User newUser = new User("new@gmail.com", "joe", "blow", 2, 2240024, userName, "college1");

        //Create children
        LocalDate testDate = LocalDate.parse("2018-01-01");
        TestScore testScore = new TestScore(testDate, 1, 12, 89,newUser);
        Role role = new Role(newUser,"vol", userName);

        // add children to parent
        newUser.addTestScore(testScore);
        newUser.addRole(role);

        // Insert record and get Id
        int id = (int) genericDao.insert(newUser);
        assertNotEquals(0,id);

        User insertedUser = (User) genericDao.getById(id);
        assertEquals( "new@gmail.com", insertedUser.getEmailAddress());
        assertEquals(1,newUser.getTestScores().size());

        //TestScore testscore = (TestScore) genericDao.getById()
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete a row (Parent cascade to children)
     */
    @Test
    void deleteSuccess() {

        genericDao.delete(genericDao.getById(2));

        //Check parent
        assertNull(genericDao.getById(2));

        //Check child
        GenericDao score = new GenericDao(TestScore.class);
        List<TestScore> scores = score.getAll();
        assertEquals(9,scores.size());

    }




    /**
     * Verify that we can update a row
     */
    @Test
    void saveOrUpdateSuccess() {
        User user = (User) genericDao.getById(2);
        user.setFirstName("Hector");

        genericDao.saveOrUpdate(user);

        User updatedUser = (User) genericDao.getById(2);
        assertEquals("Hector", updatedUser.getFirstName());
    }


    /**
     * Verify that we can get row(s) based on "Like"
     */
    @Test
    void getByLikeSuccess() {
        List<User> tests = genericDao.getByPropertyLike("emailAddress","gmail.com");
        assertEquals(3, tests.size());

    }

    /**
     * Verify that we can get row based on "Equal"
     */
    @Test
    void getByEqualSuccess() {
        List<User> tests = genericDao.getByPropertyEqual("emailAddress","steve.sokasits@gmail.com");
        assertEquals(1, tests.size());

    }
}
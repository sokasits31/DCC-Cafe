package com.doorCreekCafe.persistence;

import com.doorCreekCafe.entity.Menu;
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


class MenuDaoTests {


    MenuDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        com.doorCreekCafe.test.util.Database database = com.doorCreekCafe.test.util.Database.getInstance();
        database.runSQL("usersTestData.sql");
        dao = new MenuDao();
    }

    @Test
    void getAllMenusSuccess() {

        List<Menu> tests = dao.getAllMenus();
        assertEquals(25, tests.size());

    }



    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        
        Menu retreivedMenu = dao.getId(3);
        assertEquals(3,retreivedMenu.getId());
        //assertEquals("vol", retreivedMenu.getRole().toString());
        assertEquals("Mocha 12 oz", retreivedMenu.getDescription());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {


        Menu newMenu = new Menu("New Menu", "Test Desc", "Cool", 5.23, 1);
        int id = dao.insert(newMenu);
        assertNotEquals(0,id);

        Menu insertedMenu = dao.getId(26);
        assertEquals( "Cool", insertedMenu.getAltDescripton());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }



    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getId(1));
        assertNull(dao.getId(1));
    }


    /**
     * Verify that we can update a User
     */
    @Test
    void saveOrUpdateSuccess() {
        Menu menu = dao.getId(9);
        menu.setDescription("Steamer 99 oz");

        dao.saveOrUpdate(menu);

        Menu updatedMenu = dao.getId(9);
        assertEquals("Steamer 99 oz", updatedMenu.getDescription());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Menu> menuItems = dao.getByPropertyEqual("catagory", "Espresso Drinks");
        assertEquals(15, menuItems.size());
        assertEquals(1, menuItems.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Menu> menuItems = dao.getByPropertyLike("catagory", "Espr");
        assertEquals(15, menuItems.size());
    }
}
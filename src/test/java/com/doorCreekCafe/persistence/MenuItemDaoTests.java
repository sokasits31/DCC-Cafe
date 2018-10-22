package com.doorCreekCafe.persistence;

import com.doorCreekCafe.entity.MenuCategory;
import com.doorCreekCafe.entity.MenuItem;
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


class MenuItemDaoTests {


    MenuItemDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        com.doorCreekCafe.test.util.Database database = com.doorCreekCafe.test.util.Database.getInstance();
        database.runSQL("usersTestData.sql");
        System.out.println("tttttttttttttttttttttttttttttttttttttttttt");
        dao = new MenuItemDao();
        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
    }

    @Test
    void getAllMenusSuccess() {

        List<MenuItem> tests = dao.getAllMenus();
        assertEquals(25, tests.size());

    }



    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        
        MenuItem retreivedMenu = dao.getId(3);
        assertEquals(3,retreivedMenu.getId());
        //assertEquals("vol", retreivedMenu.getRole().toString());
        assertEquals("Mocha 12oz", retreivedMenu.getDescription());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        System.out.println("1111111111111111111111111111111111111");
        MenuCategory menuCategory = new MenuCategory();
        System.out.println("2222222222222222222222222222222");
        menuCategory.setId(1);


        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        MenuItem newMenu = new MenuItem("New Item", "Cool", 5.23, 1,"A4", menuCategory);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        int id = dao.insert(newMenu);
        assertNotEquals(0,id);

        MenuItem insertedMenu = dao.getId(30);
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
        MenuItem menuItem = dao.getId(9);
        menuItem.setDescription("Steamer 99 oz");

        dao.saveOrUpdate(menuItem);

        MenuItem updatedMenu = dao.getId(9);
        assertEquals("Steamer 99 oz", updatedMenu.getDescription());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<MenuItem> menuItems = dao.getByPropertyEqual("catagory", "Espresso Drinks");
        assertEquals(15, menuItems.size());
        assertEquals(1, menuItems.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<MenuItem> menuItems = dao.getByPropertyLike("catagory", "Espr");
        assertEquals(15, menuItems.size());

    }


}
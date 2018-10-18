package com.doorCreekCafe.persistence;


import com.doorCreekCafe.entity.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


public class MenuDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get menu by id
     */
    public Menu getId(int id) {
        Session session = sessionFactory.openSession();
        Menu menu = session.get( Menu.class, id );
        session.close();
        return menu;
    }

    /**
     * update menu
     * @param menu  Menu to be inserted or updated
     */
    public void saveOrUpdate(Menu menu) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(menu);
        transaction.commit();
        session.close();
    }

    /**
     * update menu
     * @param menu  Menu to be inserted or updated
     */
    public int insert(Menu menu) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(menu);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a menu
     * @param menu Menu to be deleted
     */
    public void delete(Menu menu) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(menu);
        transaction.commit();
        session.close();
    }


    /** Return a list of all menuItems
     *
     * @return All menuItems
     */
    public List<Menu> getAllMenus() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = builder.createQuery( Menu.class );

        Root<Menu> root = query.from( Menu.class );
        List<Menu> menuItems = session.createQuery( query ).getResultList();

        logger.debug("The list of all menu items:  " + menuItems);
        session.close();

        return menuItems;
    }

    /**
     * Get menu by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Menu> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for menu with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = builder.createQuery( Menu.class );
        Root<Menu> root = query.from( Menu.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Menu> menuItems = session.createQuery( query ).getResultList();

        session.close();
        return menuItems;
    }

    /**
     * Get menu by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Menu> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for menu with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Menu> query = builder.createQuery( Menu.class );
        Root<Menu> root = query.from( Menu.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Menu> menuItems = session.createQuery( query ).getResultList();
        session.close();
        return menuItems;
    }

}


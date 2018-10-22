package com.doorCreekCafe.persistence;


import com.doorCreekCafe.entity.MenuItem;
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


public class MenuItemDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get menuItem by id
     */
    public MenuItem getId(int id) {
        Session session = sessionFactory.openSession();
        MenuItem menuItem = session.get( MenuItem.class, id );
        session.close();
        return menuItem;
    }

    /**
     * update menuItem
     * @param menuItem  MenuItem to be inserted or updated
     */
    public void saveOrUpdate(MenuItem menuItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(menuItem);
        transaction.commit();
        session.close();
    }

    /**
     * update menuItem
     * @param menuItem  MenuItem to be inserted or updated
     */
    public int insert(MenuItem menuItem) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(menuItem);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a menuItem
     * @param menuItem MenuItem to be deleted
     */
    public void delete(MenuItem menuItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(menuItem);
        transaction.commit();
        session.close();
    }


    /** Return a list of all menuItems
     *
     * @return All menuItems
     */
    public List<MenuItem> getAllMenus() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuItem> query = builder.createQuery( MenuItem.class );

        Root<MenuItem> root = query.from( MenuItem.class );
        List<MenuItem> menuItems = session.createQuery( query ).getResultList();

        logger.debug("The list of all menuItem items:  " + menuItems);
        session.close();

        return menuItems;
    }

    /**
     * Get menuItem by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<MenuItem> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for menuItem with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuItem> query = builder.createQuery( MenuItem.class );
        Root<MenuItem> root = query.from( MenuItem.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<MenuItem> menuItems = session.createQuery( query ).getResultList();

        session.close();
        return menuItems;
    }

    /**
     * Get menuItem by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<MenuItem> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for menuItem with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuItem> query = builder.createQuery( MenuItem.class );
        Root<MenuItem> root = query.from( MenuItem.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<MenuItem> menuItems = session.createQuery( query ).getResultList();

        logger.debug("menuItems:" + menuItems);

        session.close();
        return menuItems;
    }


}


package com.doorCreekCafe.persistence;


import com.doorCreekCafe.entity.MenuCatagory;
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


public class MenuCatagoryDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get menuCatagory by id
     */
    public MenuCatagory getId(int id) {
        Session session = sessionFactory.openSession();
        MenuCatagory menuCatagory = session.get( MenuCatagory.class, id );
        session.close();
        return menuCatagory;
    }

    /**
     * update menuCatagory
     * @param menuCatagory  MenuCatagory to be inserted or updated
     */
    public void saveOrUpdate(MenuCatagory menuCatagory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(menuCatagory);
        transaction.commit();
        session.close();
    }

    /**
     * update menuCatagory
     * @param menuCatagory  MenuCatagory to be inserted or updated
     */
    public int insert(MenuCatagory menuCatagory) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(menuCatagory);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a menuCatagory
     * @param menuCatagory MenuCatagory to be deleted
     */
    public void delete(MenuCatagory menuCatagory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(menuCatagory);
        transaction.commit();
        session.close();
    }


    /** Return a list of all users
     *
     * @return All users
     */
    public List<MenuCatagory> getAllUsers() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuCatagory> query = builder.createQuery( MenuCatagory.class );

        Root<MenuCatagory> root = query.from( MenuCatagory.class );
        List<MenuCatagory> users = session.createQuery( query ).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Get menuCatagory by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<MenuCatagory> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for menuCatagory with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuCatagory> query = builder.createQuery( MenuCatagory.class );
        Root<MenuCatagory> root = query.from( MenuCatagory.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<MenuCatagory> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }

    /**
     * Get menuCatagory by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<MenuCatagory> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for menuCatagory with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuCatagory> query = builder.createQuery( MenuCatagory.class );
        Root<MenuCatagory> root = query.from( MenuCatagory.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<MenuCatagory> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

}


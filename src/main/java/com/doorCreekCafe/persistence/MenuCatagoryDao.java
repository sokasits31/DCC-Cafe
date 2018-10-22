package com.doorCreekCafe.persistence;


import com.doorCreekCafe.entity.MenuCategory;
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
     * Get MenuCategory by id
     */
    public MenuCategory getId(int id) {
        Session session = sessionFactory.openSession();
        MenuCategory MenuCategory = session.get( MenuCategory.class, id );
        session.close();
        return MenuCategory;
    }

    /**
     * update MenuCategory
     * @param MenuCategory  MenuCategory to be inserted or updated
     */
    public void saveOrUpdate(MenuCategory MenuCategory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(MenuCategory);
        transaction.commit();
        session.close();
    }

    /**
     * update MenuCategory
     * @param MenuCategory  MenuCategory to be inserted or updated
     */
    public int insert(MenuCategory MenuCategory) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(MenuCategory);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a MenuCategory
     * @param MenuCategory MenuCategory to be deleted
     */
    public void delete(MenuCategory MenuCategory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(MenuCategory);
        transaction.commit();
        session.close();
    }


    /** Return a list of all users
     *
     * @return All users
     */
    public List<MenuCategory> getAllUsers() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuCategory> query = builder.createQuery( MenuCategory.class );

        Root<MenuCategory> root = query.from( MenuCategory.class );
        List<MenuCategory> users = session.createQuery( query ).getResultList();

        logger.debug("The list of users " + users);
        session.close();

        return users;
    }

    /**
     * Get MenuCategory by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<MenuCategory> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for MenuCategory with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuCategory> query = builder.createQuery( MenuCategory.class );
        Root<MenuCategory> root = query.from( MenuCategory.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<MenuCategory> users = session.createQuery( query ).getResultList();

        session.close();
        return users;
    }

    /**
     * Get MenuCategory by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<MenuCategory> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for MenuCategory with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MenuCategory> query = builder.createQuery( MenuCategory.class );
        Root<MenuCategory> root = query.from( MenuCategory.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<MenuCategory> users = session.createQuery( query ).getResultList();
        session.close();
        return users;
    }

}


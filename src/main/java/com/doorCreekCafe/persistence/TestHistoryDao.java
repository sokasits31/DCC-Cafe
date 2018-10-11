package com.doorCreekCafe.persistence;


import com.doorCreekCafe.entity.TestHistory;
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


public class TestHistoryDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get userTestHistory by id
     */
    public TestHistory getId(int id) {
        Session session = sessionFactory.openSession();
        TestHistory testHistory = session.get( TestHistory.class, id );
        session.close();
        return testHistory;
    }

    /**
     * update userTestHistory
     * @param testHistory  UserTestHistory to be inserted or updated
     */
    public void saveOrUpdate(TestHistory testHistory) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(testHistory);
        session.close();
    }

    /**
     * update userTestHistory
     * @param testHistory  UserTestHistory to be inserted or updated
     */
    public int insert(TestHistory testHistory) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(testHistory);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a userTestHistory
     * @param testHistory UserTestHistory to be deleted
     */
    public void delete(TestHistory testHistory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(testHistory);
        transaction.commit();
        session.close();
    }


    /** Return a list of all userTests
     *
     * @return All userTests
     */
    public List<TestHistory> getAllTests() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestHistory> query = builder.createQuery( TestHistory.class );

        Root<TestHistory> root = query.from( TestHistory.class );
        List<TestHistory> userTests = session.createQuery( query ).getResultList();

        logger.debug("The list of all test and questions detail " + userTests);
        session.close();

        return userTests;
    }

    /**
     * Get userTestHistory by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<TestHistory> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for userTestHistory with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestHistory> query = builder.createQuery( TestHistory.class );
        Root<TestHistory> root = query.from( TestHistory.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<TestHistory> userTests = session.createQuery( query ).getResultList();

        session.close();
        return userTests;
    }

    /**
     * Get userTestHistory by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<TestHistory> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for userTestHistory with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestHistory> query = builder.createQuery( TestHistory.class );
        Root<TestHistory> root = query.from( TestHistory.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<TestHistory> userTests = session.createQuery( query ).getResultList();
        session.close();
        return userTests;
    }

}


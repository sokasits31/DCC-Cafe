package com.doorCreekCafe.persistence;


import com.doorCreekCafe.entity.TestScore;
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
    public TestScore getId(int id) {
        Session session = sessionFactory.openSession();
        TestScore testScore = session.get( TestScore.class, id );
        session.close();
        return testScore;
    }

    /**
     * update userTestHistory
     * @param testScore  UserTestHistory to be inserted or updated
     */
    public void saveOrUpdate(TestScore testScore) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(testScore);
        session.close();
    }

    /**
     * update userTestHistory
     * @param testScore  UserTestHistory to be inserted or updated
     */
    public int insert(TestScore testScore) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(testScore);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a userTestHistory
     * @param testScore UserTestHistory to be deleted
     */
    public void delete(TestScore testScore) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(testScore);
        transaction.commit();
        session.close();
    }


    /** Return a list of all userTests
     *
     * @return All userTests
     */
    public List<TestScore> getAllTests() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestScore> query = builder.createQuery( TestScore.class );

        Root<TestScore> root = query.from( TestScore.class );
        List<TestScore> userTests = session.createQuery( query ).getResultList();

        logger.debug("The list of all test and questions detail " + userTests);
        session.close();

        return userTests;
    }

    /**
     * Get userTestHistory by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<TestScore> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for userTestHistory with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestScore> query = builder.createQuery( TestScore.class );
        Root<TestScore> root = query.from( TestScore.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<TestScore> userTests = session.createQuery( query ).getResultList();

        session.close();
        return userTests;
    }

    /**
     * Get userTestHistory by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<TestScore> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for userTestHistory with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TestScore> query = builder.createQuery( TestScore.class );
        Root<TestScore> root = query.from( TestScore.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<TestScore> userTests = session.createQuery( query ).getResultList();
        session.close();
        return userTests;
    }

}


package com.doorCreekCafe.persistence;

        import java.util.List;

        import javax.persistence.criteria.CriteriaBuilder;
        import javax.persistence.criteria.CriteriaQuery;
        import javax.persistence.criteria.Expression;
        import javax.persistence.criteria.Root;


        import com.doorCreekCafe.entity.MenuItem;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.hibernate.Session;
        import org.hibernate.Transaction;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type, for example, User.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities
     *
     * @return the all entities
     */
    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;

    }

    /**
     * Gets an entity by id
     * @param id entity id to search by
     * @return entity
     */
    public <T> T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Insert int.
     *
     * @param entity the entity
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }



    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }


    /**
     * Save or update.
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from( type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> list = session.createQuery( query ).getResultList();
        session.close();
        return list;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> list = session.createQuery( query ).getResultList();
        session.close();
        return list;
    }

}

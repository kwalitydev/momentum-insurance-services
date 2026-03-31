package dao;



import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class BeanFactory {
    @Produces
    @Dependent
    @PersistenceContext(unitName = "ins")
    private EntityManager entityManager;

    public <T> T merge(T entity){
        return entityManager.merge(entity);
    }

}

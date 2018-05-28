package hibernateDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.MatchDAO;
import entity.Matchh;

public class HMatchDAO implements MatchDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Matchh findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Matchh match = (Matchh) currentSession.get(Matchh.class, id);
        transaction.commit();
        return match;
	}

	@Override
	public void insert(Matchh objectToInsert) {
		 Session currentSession = sessionFactory.getCurrentSession();
	     Transaction transaction = currentSession.beginTransaction();
	     currentSession.persist(objectToInsert);
	     transaction.commit();
	}

	@Override
	public void update(Matchh objectToUpdate) {
		 Session currentSession = sessionFactory.getCurrentSession();
	     Transaction transaction = currentSession.beginTransaction();
	     currentSession.update(objectToUpdate);
	     transaction.commit();
		
	}

	@Override
	public void delete(Matchh objectToDelete) {
		Session currentSession = sessionFactory.getCurrentSession();
	     Transaction transaction = currentSession.beginTransaction();
	     currentSession.delete(objectToDelete);
	     transaction.commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matchh> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Query query = currentSession.createQuery("from Match");
        List<Matchh> matches = query.list();
        transaction.commit();
        return matches;
	}

	

}

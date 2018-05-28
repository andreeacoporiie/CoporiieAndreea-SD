package hibernateDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.TournamentDAO;
import entity.Tournament;

public class HTournamentDAO implements TournamentDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Tournament findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Tournament tournament = (Tournament) currentSession.get(Tournament.class, id);
        transaction.commit();
        return tournament;
	}

	@Override
	public void insert(Tournament objectToInsert) {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.persist(objectToInsert);
        transaction.commit();
	}

	@Override
	public void update(Tournament objectToUpdate) {
		 Session currentSession = sessionFactory.getCurrentSession();
	     Transaction transaction = currentSession.beginTransaction();
	     currentSession.update(objectToUpdate);
	     transaction.commit();
	}

	@Override
	public void delete(Tournament objectToDelete) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Transaction transaction = currentSession.beginTransaction();
	    currentSession.delete(objectToDelete);
	    transaction.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tournament> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Query query = currentSession.createQuery("from Tournament");
        List<Tournament> tournaments;
        try{
        	tournaments = query.list();
        } catch (Exception e) {
        	tournaments = null;
        }
        transaction.commit();
        return tournaments;
	}

	@Override
	public Tournament findByStatus(String status) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from Tournament where status=:status");
		query.setParameter("status", status);
		Tournament t = (Tournament) query.uniqueResult();
		
		transaction.commit();
		return t;
	}

	@Override
	public Tournament findByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		Query query= sessionFactory.getCurrentSession().
		        createQuery("from Tournament where name=:name");
		query.setParameter("name", name);
		Tournament t = (Tournament) query.uniqueResult();
		
		transaction.commit();
		return t;
	}

}

package hibernateDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.GameDAO;
import entity.Game;


public class HGameDAO implements GameDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Game findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Game game = (Game) currentSession.get(Game.class, id);
        transaction.commit();
        return game;
	}

	@Override
	public void insert(Game objectToInsert) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.persist(objectToInsert);
        transaction.commit();
	}

	@Override
	public void update(Game objectToUpdate) {
		 Session currentSession = sessionFactory.getCurrentSession();
	     Transaction transaction = currentSession.beginTransaction();
	     currentSession.update(objectToUpdate);
	     transaction.commit();
	}

	@Override
	public void delete(Game objectToDelete) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(objectToDelete);
        transaction.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> findAll() {
		  Session currentSession = sessionFactory.getCurrentSession();
	      Transaction transaction = currentSession.beginTransaction();
	      Query query = currentSession.createQuery("from Game");
	      List<Game> matchList = query.list();
	      transaction.commit();
	      return matchList;
	}

//	@Override
//	public Game findByIdMatch(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

package hibernateDAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.PlayerDAO;
import entity.Player;

public class HPlayerDAO implements PlayerDAO{

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Player findById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Player p = (Player) currentSession.get(Player.class, id);
        transaction.commit();
        return p;
	}

	@Override
	public void insert(Player objectToInsert) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.persist(objectToInsert);
        transaction.commit();
	}

	@Override
	public void update(Player objectToUpdate) {
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.update(objectToUpdate);
        transaction.commit();
	}

	@Override
	public void delete(Player objectToDelete) {
		  Session currentSession = sessionFactory.getCurrentSession();
	      Transaction transaction = currentSession.beginTransaction();
	      currentSession.delete(objectToDelete);
	      transaction.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Query query = currentSession.createQuery("from Player");
        List<Player> players = query.list();
        transaction.commit();
        return players;
	}

	@Override
	public Player findByMail(String mail) {
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction transaction = currentSession.beginTransaction();
		Query query= sessionFactory.getCurrentSession().createQuery("from Player where mail=:mail");
		query.setParameter("mail", mail);
		Player p = (Player) query.uniqueResult();
		
		transaction.commit();
		return p;
	}

}

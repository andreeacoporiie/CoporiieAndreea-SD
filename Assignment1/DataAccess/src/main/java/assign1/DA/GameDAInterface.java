package assign1.DA;

import java.util.List;

import entity.Game;

public interface GameDAInterface {
	public void insert(Game g) ;
	public List<Game> findAll();
	public Game findByIdGame(int id);
	public Game findByIdMatch(int id);
	public void removeByIdGame(int id);
	public void updateGame(Game g);
}
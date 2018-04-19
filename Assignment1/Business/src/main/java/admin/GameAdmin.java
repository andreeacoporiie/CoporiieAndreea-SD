package admin;

import java.util.List;

import assign1.DA.*;
import entity.Game;

public class GameAdmin extends GameDAO {
	private static GameAdmin GA = new GameAdmin();
	
	public static void addGame(Game g)
	{
		GA.insert(g);
	}
	
	public static Game getGame(int id)
	{
		return GA.findByIdMatch(id);
	}
	
	public static int updateScore(Game g, int player)
	{
		
		if (player == 1)
		{
			g.setScore1(g.getScore1() + 1);
			GA.updateGame(g);
			if (g.getScore1() > 10 && dif(g.getScore1(),g.getScore2()))
			{
				g.setWinner("Player1");
			}
			return g.getScore1();
		}
		
		if (player == 1)
		{
			g.setScore1(g.getScore2() + 1);
			GA.updateGame(g);
			if (g.getScore2() > 10 && dif(g.getScore1(),g.getScore2()))
			{
				g.setWinner("Player2");
			}
			return g.getScore1();
		}
		
		
		return 1;
	}
	
	public static boolean dif(int a, int b)
	{
		if (a-b > 1 || b-a > 1)
			return true;
		return false;
	}
	
	public static int getNextId()
	{
		List<Game> l =  GA.findAll();
		if (l == null) return 1;
		if (l.size() > 0){
			Game g = l.get(l.size()-1);
			return g.getIdGame() + 1;
		}
		return 1;
	}
}

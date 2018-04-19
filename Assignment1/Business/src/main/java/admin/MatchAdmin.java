package admin;

import java.util.ArrayList;
import java.util.List;

import assign1.DA.*;
import entity.Match;

public class MatchAdmin extends MatchDAO {
	private static MatchAdmin MA = new MatchAdmin();
	
	public static void addMatch(Match m)
	{
		MA.insert(m);
	}
	
	public static List<Match> setMatches(int id)
	{
		return MA.findByIdTournament(id);
	}
	
	
	public static int getNextId()
	{
		List<Match> l =  MA.findAll();
		if (l == null ) return 1;
		if (l.size() > 0){
			Match m = l.get(l.size()-1);
			return m.getIdMatch() + 1;
		}
		return 1;
	}

	public static ArrayList<Match> getMatches(int id) {
		List<Match> list = MA.findByIdTournament(id);
		return (ArrayList<Match>) list;
	}
}

package logic;

import daoFactory.DaoFactory;
import entity.Player;
//import daoFactory.DaoFactory.Type;
import entity.Tournament;

public class ModelLogic {

	private DaoFactory factory;
	private PlayerLogic pl;
	private GameLogic gl;
	private MatchLogic ml;
	private TournamentLogic tl;
	
	ModelLogic(){
		factory = DaoFactory.getInstance();
		pl = new PlayerLogic(factory.getPlayerDAO());
		gl = new GameLogic(factory.getGameDAO());
		ml = new MatchLogic(factory.getMatchDAO());
		tl = new TournamentLogic(factory.getTournamentDAO());	
	}

	private static ModelLogic singleton = null;

    public static ModelLogic getInstance()
    {
        if (singleton == null)
        {
            singleton = new ModelLogic();
        }
        return singleton;
    }
    
	public PlayerLogic getPl() {
		return pl;
	}

	public GameLogic getGl() {
		return gl;
	}

	public MatchLogic getMl() {
		return ml;
	}

	public TournamentLogic getTl() {
		return tl;
	}
	
	public boolean isPlayer(String mail)
	{
		if (getPl().findByMail(mail) == null) return false;
		return true;
	}
	
	public boolean isPlayer(int id)
	{
		if (getPl().findById(id) == null) return false;
		return true;
	}
	
	public boolean isTournament(int id)
	{
		if (getTl().findById(id) == null) return false;
		return true;
	}
	
	public boolean isTournament(String name)
	{
		if (getTl().findByName(name) == null) return false;
		return true;
	}
	
	public boolean isEnrolled(Player p, Tournament t)
	{
		if (t.getEnrolledPlayers() != null)
		for (Player player: t.getEnrolledPlayers())
		{
			if (p.getIdPlayer() == player.getIdPlayer())
				return true;
		}
		return false;
	}
	
}

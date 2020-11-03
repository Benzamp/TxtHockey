package TextHockey;

public class Team {

	private String teamName;
	private String city;
	private int wins;
	private int losses;
	private int points;
	private int gamesPlayed;
	private int gamesRemaining;
	
	private Player center;
	private Player wing;
	private Player defense;
	private Player goalie;
	
	public Team() {
		
	}
	
	public Team(String t, String ci, int w, int l, int p, int g, int ga, Player c, Player wi, Player def, Player go) {
		t = teamName;
		ci = city;
		w = wins;
		l = losses;
		p = points;
		g = gamesPlayed;
		ga = gamesRemaining;
		c = center;
		wi = wing;
		def = defense;
		go = goalie;
	}
	
	public String toString() {
		return "The " + city + " " + teamName;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getGamesRemaining() {
		return gamesRemaining;
	}

	public void setGamesRemaining(int gamesRemaining) {
		this.gamesRemaining = gamesRemaining;
	}

	public Player getCenter() {
		return center;
	}

	public void setCenter(Player center) {
		this.center = center;
	}

	public Player getWing() {
		return wing;
	}

	public void setWing(Player wing) {
		this.wing = wing;
	}

	public Player getDefense() {
		return defense;
	}

	public void setDefense(Player defense) {
		this.defense = defense;
	}

	public Player getGoalie() {
		return goalie;
	}

	public void setGoalie(Player goalie) {
		this.goalie = goalie;
	}
}

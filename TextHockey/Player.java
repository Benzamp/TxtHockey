package TextHockey;

public class Player implements Comparable<Player>{
	
	private int number;
	private String firstName;
	private String lastName;
	public String fullName;
	private String position;
	private Team team;
	
	protected int skating;
	protected int shooting;
	protected int passing;
	protected int discipline;
	protected int passBlocking;
	protected int faceoff;
	
	private int high;
	private int low;
	
	private int goals;
	private int assists;
	protected int points;
	private int pmins;
	
	public Player() {
		
	}
	
	public Player(int n, String f, String l, String p, Team t, int sk, int sh, int pa, int d, int pb, int fo, int g, int a, int pm) {
		n = number;
		f = firstName;
		l = lastName;
		fullName = fName(f,l);
		p = position;
		t = team;
		sk = skating;
		sh = shooting;
		pa = passing;
		d = discipline;
		pb = passBlocking;
		fo = faceoff;
		g = goals;
		a = assists;
		points = g + a;
		pm = pmins;
	}
	
	public Player(int n, String f, String l, String p, Team t, int h, int lo) {
		n = number;
		f = firstName;
		l = lastName;
		fullName = fName(f,l);
		p = position;
		t = team;
		h = high;
		lo = low;
	}
	
	public String toString() {
		if (position != "Goalie") 
			return  firstName + " " + lastName + "\n"
			+ "#" + number + "\n" 
			+ team + "\n"
			+ position + "\n"
			+ goals + "G" + "\n"
			+ assists + "A" + "\n"
			+ "--------------------------------\n";
		else
			return firstName + " " + lastName + "\n"
			+ "#" + number + "\n" 
			+ team + "\n"
			+ position + "\n";
	}
	
	public int getPassBlocking() {
		return passBlocking;
	}

	public void setPassBlocking(int passBlocking) {
		this.passBlocking = passBlocking;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String fName(String f, String l) {
		return f + " " + l;
	}
	
	public int getFaceoff() {
		return faceoff;
	}

	public void setFaceoff(int faceoff) {
		this.faceoff = faceoff;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSkating() {
		return skating;
	}

	public void setSkating(int skating) {
		this.skating = skating;
	}

	public int getShooting() {
		return shooting;
	}

	public void setShooting(int shooting) {
		this.shooting = shooting;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}

	public int getDiscipline() {
		return discipline;
	}

	public void setDiscipline(int discipline) {
		this.discipline = discipline;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getPmins() {
		return pmins;
	}

	public void setPmins(int pmins) {
		this.pmins = pmins;
	}

	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

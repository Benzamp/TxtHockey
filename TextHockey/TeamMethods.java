package TextHockey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TeamMethods {
	
	public static Team createdTeam() {
		Scanner scan = new Scanner(System.in);
		
		Player center = new Player();
		Player wing = new Player();
		Player def = new Player();
		Player goalie = new Player();
		
		Team createdTeam = new Team();
		
		System.out.println("Team City: ");
		String city = scan.nextLine();
		System.out.println("Team Name: ");
		String name = scan.nextLine();
		
		System.out.println("Center first name: ");
		String cFirst = scan.nextLine();
		System.out.println("Center last name: ");
		String cLast = scan.nextLine();
		System.out.println("Center number: ");
		int cNumber = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Center faceoff: (1/10)");
		int cFace = scan.nextInt();
		System.out.println("Center shooting (1/10): ");
		int cShoot = scan.nextInt();
		System.out.println("Center passing (1/10): ");
		int cPass = scan.nextInt();
		System.out.println("Center skating (1/10): ");
		int cSkate = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Wing first name: ");
		String wFirst = scan.nextLine();
		System.out.println("Wing last name: ");
		String wLast = scan.nextLine();
		System.out.println("Wing number: ");
		int wNumber = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Wing shooting (1/10): ");
		int wShoot = scan.nextInt();
		System.out.println("Wing passing (1/10): ");
		int wPass = scan.nextInt();
		System.out.println("Wing skating (1/10): ");
		int wSkate = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Defense first name: ");
		String dFirst = scan.nextLine();
		System.out.println("Defense last name: ");
		String dLast = scan.nextLine();
		System.out.println("Defense number: ");
		int dNumber = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Defense shooting (1/10): ");
		int dShoot = scan.nextInt();
		System.out.println("Defense passing (1/10): ");
		int dPass = scan.nextInt();
		System.out.println("Defense skating (1/10): ");
		int dSkate = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Goalie first name: ");
		String gFirst = scan.nextLine();
		System.out.println("Goalie last name: ");
		String gLast = scan.nextLine();
		System.out.println("Goalie number: ");
		int gNumber = scan.nextInt();
		scan.nextLine();
		
		center.setFirstName(cFirst);
		center.setLastName(cLast);
		center.setFaceoff(cFace);
		center.setPassing(cPass);
		center.setShooting(cShoot);
		center.setSkating(cSkate);
		
		wing.setFirstName(wFirst);
		wing.setLastName(wLast);
		wing.setPassing(wPass);
		wing.setShooting(wShoot);
		wing.setSkating(wSkate);
		
		def.setFirstName(dFirst);
		def.setLastName(dLast);
		def.setPassing(dPass);
		def.setShooting(dShoot);
		def.setSkating(dSkate);
		
		goalie.setFirstName(gFirst);
		goalie.setFirstName(gLast);
		
		createdTeam.setTeamName(name);
		createdTeam.setCity(city);
		
		createdTeam.setCenter(center);
		createdTeam.setWing(wing);
		createdTeam.setDefense(def);
		createdTeam.setGoalie(goalie);
		
		center.setTeam(createdTeam);
		wing.setTeam(createdTeam);
		def.setTeam(createdTeam);
		goalie.setTeam(createdTeam);
		
		return createdTeam;
	}
	
	public static ArrayList<Team> generateTeam(int numberOfTeams) throws FileNotFoundException {
		ArrayList<String> positions = new ArrayList<>();
		ArrayList<Team> teams = new ArrayList<>();
		
		positions.add("Center");
		positions.add("Wing");
		positions.add("Defense");
		positions.add("Goalie");
		
		/*
		for (int i = 0; i < 10; i++) {
			String city = randomCity();
			String mascot = randomMascot();
			
			System.out.println(city + " " + mascot);
		}
		*/
		while (numberOfTeams > 0) {
			
			
			positions.add("Center");
			positions.add("Wing");
			positions.add("Defense");
			positions.add("Goalie");
			
			Team newTeam = new Team();
			newTeam.setCity(randomCity());
			newTeam.setTeamName(randomMascot());
			newTeam.setWins(0);
			newTeam.setLosses(0);
			newTeam.setPoints(0);
			newTeam.setGamesPlayed(0);
			newTeam.setGamesRemaining(0);
			
			while (!positions.isEmpty()) {
				String firstName = randomFirstName();
				String lastName = randomLastName();
				String fullName = firstName + " " + lastName;
				
				int shooting = generateSkillNum();
				int passing = generateSkillNum();
				int skating = generateSkillNum();
				int faceoff = generateSkillNum();
				int passBlock = generateSkillNum();
				
				int number = 0;
				int[] usedNumbers = new int[10];
				
				for (int i = 0; i < 99; i++) {
					number = new java.util.Random().nextInt(99);
				}
				
				int pIndex = new java.util.Random().nextInt(positions.size());
				String randPos = positions.get(pIndex);
				positions.remove(pIndex);
				
				Player newPlayer = new Player();
				newPlayer.setFaceoff(faceoff);
				newPlayer.setPassing(passing);
				newPlayer.setShooting(shooting);
				newPlayer.setSkating(skating);
				newPlayer.setPassBlocking(passBlock);
				
				newPlayer.setAssists(0);
				newPlayer.setGoals(0);
				
				boolean used = true;
				while (used) {
					for (int i : usedNumbers) {
						if (i != number) {
							used = false;
							newPlayer.setNumber(number);
						}
						else {
							used = true;
							for (int j = 0; j < 99; j++) {
								number = new java.util.Random().nextInt(99);
							}
						}
					}
				}
				
				
				newPlayer.setFirstName(randomFirstName());
				newPlayer.setLastName(randomLastName());
				//newPlayer.setPosition(randPos);
				newPlayer.setTeam(newTeam);
				
				if (randPos.compareTo("Center") == 0) {
						newTeam.setCenter(newPlayer);
						newPlayer.setPosition(randPos);
						
				}
				else if (randPos.compareTo("Wing") == 0) {
					newTeam.setWing(newPlayer);
					newPlayer.setPosition(randPos);
				}
				else if (randPos.compareTo("Defense") == 0) {
					newTeam.setDefense(newPlayer);
					newPlayer.setPosition(randPos);
				}
				else {
					newTeam.setGoalie(newPlayer);
					newPlayer.setPosition(randPos);
				}
			}
			
			teams.add(newTeam);
			numberOfTeams--;
		}
		
		return(teams);
	}

	public static String randomFirstName() throws FileNotFoundException {
		TeamMethods methods = new TeamMethods();
		
		ArrayList<String> fnames = methods.loadData("first-names");
		
		int fIndex = new java.util.Random().nextInt(fnames.size());
		String firstname = fnames.get(fIndex);
		
		return methods.capitalizeFirstLetter(firstname);
	}
	
	public static String randomLastName() throws FileNotFoundException {
		TeamMethods methods = new TeamMethods();
		
		ArrayList<String> lnames = methods.loadData("last-names");
		
		int lIndex = new java.util.Random().nextInt(lnames.size());
		String lastname = lnames.get(lIndex);
		
		return methods.capitalizeFirstLetter(lastname);
	}
	
	public static String randomCity() throws FileNotFoundException {
		TeamMethods methods = new TeamMethods();
		
		ArrayList<String> cities = methods.loadData("cities");
		
		int cIndex = new java.util.Random().nextInt(cities.size());
		String city = cities.get(cIndex);
		
		return city;
	}
	
	public static String randomMascot() throws FileNotFoundException {
		TeamMethods methods = new TeamMethods();
		
		ArrayList<String> mascots = methods.loadData("mascots");
		
		int mIndex = new java.util.Random().nextInt(mascots.size());
		String mascot = mascots.get(mIndex);
		
		return mascot;
	}
	
	public ArrayList<String> loadData(String filename) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("C:/eclipseOxygen10/workspace/TextHockey/TextFiles/" + filename + ".txt"));
		ArrayList<String> list = new ArrayList<String>();
		
		while(inFile.hasNextLine()){
			list.add(inFile.nextLine());
		}
		
		inFile.close();
		return list;
	}
	
	public String capitalizeFirstLetter(String original) {
	    if (original == null || original.length() == 0) {
	        return original;
	    }
	    return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	
	public static int generateSkillNum() {
		int lowest = 1;
		int highest = 10;
		int randNum = lowest + (int)(Math.random() * ((highest - lowest) + 1));
		
		return randNum;
	}
	
	public void playerFullNames(Team playerTeam, Team comTeam) {
		String pCenterFirst = playerTeam.getCenter().getFirstName();
		String pCenterLast = playerTeam.getCenter().getLastName();
		String pCenterFull = pCenterFirst + " " + pCenterLast;
		
		String pWingFirst = playerTeam.getWing().getFirstName();
		String pWingLast = playerTeam.getWing().getLastName();
		String pWingFull = pWingFirst + " " + pWingLast;
		
		String pDefFirst = playerTeam.getDefense().getFirstName();
		String pDefLast = playerTeam.getDefense().getLastName();
		String pDefFull = pDefFirst + " " + pDefLast;
		
		String pGoalFirst = playerTeam.getGoalie().getFirstName();
		String pGoalLast = playerTeam.getGoalie().getLastName();
		String pGoalFull = pGoalFirst + " " + pGoalLast;
		
		String cCenterFirst = comTeam.getCenter().getFirstName();
		String cCenterLast = comTeam.getCenter().getLastName();
		String cCenterFull = cCenterFirst + " " + cCenterLast;
		
		String cWingFirst = comTeam.getWing().getFirstName();
		String cWingLast = comTeam.getWing().getLastName();
		String cWingFull = cWingFirst + " " + cWingLast;
		
		String cDefFirst = comTeam.getDefense().getFirstName();
		String cDefLast = comTeam.getDefense().getLastName();
		String cDefFull = cDefFirst + " " + cDefLast;
		
		String cGoalFirst = comTeam.getGoalie().getFirstName();
		String cGoalLast = comTeam.getGoalie().getLastName();
		String cGoalFull = cGoalFirst + " " + cGoalLast;
		
		playerTeam.getCenter().setFullName(pCenterFull);
		playerTeam.getWing().setFullName(pWingFull);
		playerTeam.getDefense().setFullName(pDefFull);
		playerTeam.getGoalie().setFullName(pGoalFull);
		
		comTeam.getCenter().setFullName(cCenterFull);
		comTeam.getWing().setFullName(cWingFull);
		comTeam.getDefense().setFullName(cDefFull);
		comTeam.getGoalie().setFullName(cGoalFull);
		
	}

}

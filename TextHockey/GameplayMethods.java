package TextHockey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GameplayMethods {
	
	public static void mainMenu() {
		System.out.println("---------TxtHOCKEY --------");
		System.out.println("1) CREATE A TEAM            |");
		System.out.println("2) RANDOMIZE TEAM           |");
		System.out.println("3) Quit                     |");
		System.out.println("----------------------------");
	}
	
	public void gameLoop (Team playerTeam, Team comTeam) {
		Scanner scan = new Scanner(System.in);
		
		int gameClock = 0;
		int period = 1;
		
		int playerScore = 0;
		int comScore = 0;
		
		int playerSaves = 0;
		int comSaves = 0;
		
		int playerShots = 0;
		int comShots = 0;
		
		boolean playing = true;
		TeamMethods teamMethods = new TeamMethods();
		
		System.out.println("\nTonight we have " + playerTeam + " facing off against " + comTeam + ".\n");
		
		while (period <= 3) {
			gameClock = 10;
			if (period == 1) {
				System.out.println("This marks the start of the game as the skaters take their positions in the center of the ice.\n");
			} else if (period == 2) {
				System.out.println("We are on our way to the start of the second period.\n");
			} else {
				System.out.println("The third period approaches us and its time to take the first draw of the period.\n");
			}
			period++;
			while (gameClock > 0) {
				int currentScore = playerScore;
				
				int playsMade = 1;
				Player puckPosessor = null;
				teamMethods.playerFullNames(playerTeam, comTeam);
				
				System.out.println(playerTeam.getCenter().getFullName() + " from The " + playerTeam.getTeamName()
				+ " prepares to take the faceoff against " + comTeam.getCenter().getFullName()
				+ " from The " + comTeam.getTeamName() + ".\n");
				System.out.println("_________");
				System.out.println("|FACEOFF|");
				String sel = scan.nextLine();
				clearScreen();
				
				boolean won = skillCheck(playerTeam.getCenter(), comTeam.getCenter(), "faceoff", playsMade);
				boolean frozen = false;
				TreeMap<Player, String> Tmap = new TreeMap<>();
				
				
				
				while(!frozen) {
					Tmap.clear();
					Tmap = randomDialog(playerTeam, comTeam, won, sel, playerScore, comScore);
					String text = Tmap.firstEntry().getValue();
					System.out.println(text);
					puckPosessor = Tmap.firstKey();
					gameClock--;
					boolean posession;
					if (puckPosessor.getTeam() == playerTeam)
						posession = true;
					else
						posession = false;
					
					while (posession) {
						won = skillCheck(playerTeam.getCenter(), comTeam.getCenter(), "faceoff", playsMade);
						if (puckPosessor.getTeam() == playerTeam) {
							sel = actionMenu(gameClock);
							
							if (sel.compareTo("pass") == 0) {
								if (won)
									playsMade++;
								else
									playsMade = 0;
								Tmap.clear();
								Tmap = randomDialog(playerTeam, comTeam, won, sel, playerScore, comScore);
								String passtext = Tmap.firstEntry().getValue();
								System.out.println(passtext);
								puckPosessor = Tmap.firstKey();
								gameClock--;
								
							} else if (sel.compareTo("shoot") == 0) {
								playerShots++;
								Tmap.clear();
								Tmap = randomDialog(playerTeam, comTeam, won, sel, playerScore, comScore);
								String shootText = Tmap.firstEntry().getValue();
								System.out.println(shootText);
								puckPosessor = Tmap.firstKey();
								
								System.out.println(won);
								if (won) {
									playerShots++;
									comSaves++;
									playsMade++;
									playerScore += 1;
									System.out.println(playerTeam + ": " + playerScore);
									System.out.println(comTeam + ": " + comScore + "\n");
									break;
									
								}
								
								gameClock--;
								
							} else if (sel.compareTo("skate") == 0) {
								if (won)
									playsMade++;
								else
									playsMade = 0;
								Tmap.clear();
								Tmap = randomDialog(playerTeam, comTeam, won, sel, playerScore, comScore);
								String skateText = Tmap.firstEntry().getValue();
								skateText.format(puckPosessor.getFullName());
								System.out.println(skateText);
								puckPosessor = Tmap.firstKey();
								gameClock--;
							}
							
							if (puckPosessor.getTeam() == playerTeam && currentScore == playerScore) {
								posession = true;
								currentScore++;
							}
							else
								posession = false;
							
						}
					}
					System.out.println(comTeam + " has possession of the puck. Defense will be simmed...\n");
					int[] dice = new int[7];
					int roll1 = new java.util.Random().nextInt(dice.length);
					int roll2 = new java.util.Random().nextInt(dice.length);
					
					if (roll1 == roll2) {
						int[] dice2 = new int[2];
						int roll3 = new java.util.Random().nextInt(dice2.length);
						
						if (roll3 == 0) {
							System.out.println(comTeam.getCenter().getFullName() + " scored on the last play. \nThe current score: ");
							comScore++;
							comTeam.getCenter().setGoals(comTeam.getCenter().getGoals()+ 1);
							System.out.println(playerTeam + ": " + playerScore);
							System.out.println(comTeam + ":" + comScore + "\n");
						} else if (roll3 == 1) {
							System.out.println(comTeam.getWing().getFullName() + " scored on the last play. \nThe current score: ");
							comScore++;
							comTeam.getWing().setGoals(comTeam.getWing().getGoals()+ 1);
							System.out.println(playerTeam + ": " + playerScore);
							System.out.println(comTeam + ":" + comScore + "\n");
						} else if (roll3 == 2) {
							System.out.println(comTeam.getDefense().getFullName() + " scored on the last play. \nThe current score: ");
							comScore++;
							comTeam.getDefense().setGoals(comTeam.getDefense().getGoals()+ 1);
							System.out.println(playerTeam + ": " + playerScore);
							System.out.println(comTeam + ":" + comScore + "\n");
						}
					} else {
						System.out.println(comTeam + " did not score on the play.\n");
					}
					break;
				}
			}
		}
		System.out.println("The final buzzer sounds and that marks the end of the game.");
		System.out.println(playerTeam + ": " + playerScore);
		System.out.println(comTeam + ": " + comScore);
		
		if (comScore > playerScore) {
			comTeam.setWins(comTeam.getWins() + 1);
			playerTeam.setLosses(playerTeam.getLosses() + 1);
			System.out.println(comTeam + " wins the game.\n");
		} else if (playerScore > comScore) {
			playerTeam.setWins(playerTeam.getWins() + 1);
			comTeam.setLosses(comTeam.getLosses() + 1);
			System.out.println(playerTeam + " wins the game.\n");
		} else {
			System.out.println("The game was tied.\n");
		}
	}
		
		
	
	
	public static boolean skillCheck(Player p, Player c, String skill, int playsMade) {
		boolean won = false;
		
		if (skill.toLowerCase().compareTo("shooting") == 0) {
			int playerNum = p.getShooting();
			int comNum = c.getShooting();
			
			int[] dice = new int [20];
			int roll = 0;
			
			for (int i = 0; i < playsMade; i++) {
				roll = new java.util.Random().nextInt(dice.length);
			}
			
			if (playerNum >= comNum) {
				if (roll == 1 || roll == 2) {
					won = true;
				} else
					won = false;
			} else if (playerNum <= comNum) {
				if (roll == 1 ) {
					won = true;
				}
				else
					won = false;
			}
			
		} else if (skill.toLowerCase().compareTo("skating") == 0) {
			int playerNum = p.getSkating();
			int comNum = c.getSkating();
			
			int[] dice = new int [2];
			int roll = new java.util.Random().nextInt(dice.length);
			
			if (playerNum >= comNum) {
				if (roll == 1 || roll == 2) {
					won = true;
				} else
					won = false;
			} else if (playerNum <= comNum) {
				if (roll == 1 ) {
					won = true;
				}
				else
					won = false;
			}
			
		} else if (skill.toLowerCase().compareTo("passing") == 0) {
			int playerNum = p.getPassing();
			int comNum = c.getPassing();
			
			int[] dice = new int [2];
			int roll = new java.util.Random().nextInt(dice.length);
			
			if (playerNum >= comNum) {
				if (roll == 1 || roll == 2) {
					won = true;
				} else
					won = false;
			} else if (playerNum <= comNum) {
				if (roll == 1 ) {
					won = true;
				}
				else
					won = false;
			}
			
		} else if (skill.toLowerCase().compareTo("faceoff") == 0) {
			int playerNum = p.getFaceoff();
			int comNum = c.getFaceoff();
			
			int[] dice = new int [2];
			int roll = new java.util.Random().nextInt(dice.length);
			
			if (playerNum >= comNum) {
				if (roll == 1 || roll == 2) {
					won = true;
				} else
					won = false;
			} else if (playerNum <= comNum) {
				if (roll == 1 ) {
					won = true;
				}
				else
					won = false;
			}
				
		} 
		
		return won;
	}
	
	public static TreeMap<Player, String> randomDialog(Team pTeam, Team cTeam, boolean won, String action, int playerScore, int comScore) {
		TreeMap<Player, String> dialog = new TreeMap<Player, String>();
		dialog.clear();
		Player hasPuck = null;
		String text = null;
		int[] dice = new int[7];
		int roll = new java.util.Random().nextInt(dice.length);
		
		
		ArrayList<String> faceoffWonToDef = new ArrayList<>();
		ArrayList<String> faceoffWonToWing = new ArrayList<>();
		ArrayList<String> faceoffLostToDef = new ArrayList<>();
		ArrayList<String> faceoffLostToWing = new ArrayList<>();
		
		ArrayList<String> shootWon = new ArrayList<>();
		ArrayList<String> shootLost = new ArrayList<>();
		
		
		
		ArrayList<String> passWon = new ArrayList<>();
		ArrayList<String> passLost = new ArrayList<>();
		
		ArrayList<String> skateWon = new ArrayList<>();
		ArrayList<String> skateLost = new ArrayList<>();
		
		//********************************************ADDING TEXT***********************************************************************
		//**********************************************FACEOFFS************************************************************************
		faceoffWonToDef.add(pTeam.getCenter().getLastName() + " won the faceoff back to his defenseman. " + pTeam + " takes control. \n" 
				+ pTeam.getDefense().getLastName() + " on defense takes it at the " + pTeam + " blue line.\n");
		faceoffLostToDef.add(cTeam.getCenter().getLastName() + " wins the faceoff and " + cTeam + " has possession.\n"
				+ "The defenseman " + cTeam.getCenter().getLastName() + " controls the puck.");
		
		faceoffWonToWing.add("The two centers fight for possession and the puck ends of on the stick of the " + pTeam 
				+ " winger " + pTeam.getWing().getLastName() + ".\n " + pTeam.getWing().getFullName() + " contemplates his next move.");
		faceoffLostToWing.add(cTeam.getCenter().getLastName() + " of the " + cTeam + " wins it cleanly to the wing. \n" 
				+ cTeam.getWing().getLastName() + " handles the puck near the boards.\n");
		//******************************************************************************************************************************
		//************************************************PASSING***********************************************************************
		passWon.add(pTeam.getDefense().getLastName() + " completed an outlet pass to the winger " + pTeam.getWing().getLastName() 
				+ ".\n " + pTeam.getWing().getLastName() + " takes the puck to open ice.\n");
		passWon.add(pTeam.getDefense().getLastName() + " sends the puck to his centerman " + pTeam.getCenter().getLastName() 
				+ ".\n " + pTeam.getCenter().getLastName() + " has some room to make a play.\n");
		passWon.add(pTeam.getWing().getLastName() + " passes to the center " + pTeam.getCenter().getLastName() 
				+ ".\n " + pTeam.getCenter().getLastName() + " dances with the puck as the play continues.\n");
		passWon.add(pTeam.getWing().getLastName() + " passes back to his defenseman " + pTeam.getDefense().getLastName() 
				+ ".\n " + pTeam.getDefense().getLastName() + " looks around for an opportunity.\n");
		passWon.add(pTeam.getCenter().getLastName()+ " guides the biscuit to the centerman " + pTeam.getCenter().getLastName() 
				+ ".\n " + pTeam.getCenter().getLastName() + " works the puck around open ice.\n");
		passWon.add(pTeam.getCenter().getLastName() + " nudges the puck back to his defenseman " + pTeam.getDefense().getLastName()
				+ ".\n Eager to get something going " + pTeam.getDefense().getLastName() + " moves along./n");
		
		passLost.add("The pass doesn't make it to the intended " + pTeam + " skater as its picked off by " + cTeam.getDefense().getLastName()
				+ " of the " + cTeam + ".\n " + cTeam.getDefense().getLastName() + " carries on.\n");
		passLost.add(cTeam.getWing().getLastName() + " cuts of the pass and takes the puck.\n");
		passLost.add(cTeam.getCenter().getLastName() + " of the " + cTeam + " steals the puck and wants to make a play.\n");
		//*******************************************************************************************************************************
		//****************************************************SHOOTING*******************************************************************
		shootWon.add(String.format("AND HE SCORES! He took on hell of shot %s gets his team a goal!\n", pTeam.getWing().getFullName()));
		shootLost.add(String.format("%s makes the save and the lamp doesn't light after that shot\n", cTeam.getGoalie().getLastName()));
		//*******************************************************************************************************************************
		//****************************************************SKATING********************************************************************	
		skateWon.add("He skates up the ice and dangles around the opposition for great ice position\n");
		skateLost.add("The defenders prevent him from gaining any ground as they reset");
		//*******************************************************************************************************************************
		//****************************************************COMPUTER*******************************************************************
		
		
		if (action.equals("faceoff") && won == true) {
			if (roll % 2 == 0) {
				int randIndex = new java.util.Random().nextInt(faceoffWonToDef.size());
				text = faceoffWonToDef.get(randIndex);
				hasPuck = pTeam.getDefense();
			} else {
				int randIndex = new java.util.Random().nextInt(faceoffWonToWing.size());
				text = faceoffWonToWing.get(randIndex);
				hasPuck = pTeam.getWing();
			}
		} else if (action.equals("faceoff") && won == false) {
			if (roll % 2 == 0) {
				int randIndex = new java.util.Random().nextInt(faceoffLostToDef.size());
				text = faceoffLostToDef.get(randIndex);
				hasPuck = cTeam.getDefense();
			} else {
				int randIndex = new java.util.Random().nextInt(faceoffLostToWing.size());
				text = faceoffLostToWing.get(randIndex);
				hasPuck = cTeam.getWing();
				}
		} else if (action.equals("pass") && won == true) {
			if (roll % 2 == 0) {
				int randIndex = new java.util.Random().nextInt(passWon.size());
				text = passWon.get(randIndex);
				hasPuck = pTeam.getWing();
			} else {
				int randIndex = new java.util.Random().nextInt(passLost.size());
				text = passLost.get(randIndex);
				hasPuck = cTeam.getWing();
			}
		} else if (action.toLowerCase().compareTo("pass") == 0 && won == false){
			int randIndex = new java.util.Random().nextInt(passLost.size());
			text = passLost.get(randIndex);
			hasPuck = cTeam.getWing();
		} else if (action.equals("shoot") && won == true) {
			if (roll % 2 == 0) {
				int randIndex = new java.util.Random().nextInt(shootWon.size());
				text = shootWon.get(randIndex);
				hasPuck = pTeam.getWing();
			} else {
				int randIndex = new java.util.Random().nextInt(shootLost.size());
				text = shootLost.get(randIndex);
				hasPuck = cTeam.getWing();
			}
		}else if (action.equals("shoot") && won == false) {
			int randIndex = new java.util.Random().nextInt(shootLost.size());
			text = shootLost.get(randIndex);
			hasPuck = cTeam.getWing();
		} else if (action.equals("skate") && won == true) {
			if (roll % 2 == 0) {
				int randIndex = new java.util.Random().nextInt(skateWon.size());
				text = skateWon.get(randIndex);
				hasPuck = pTeam.getWing();
			} else {
				int randIndex = new java.util.Random().nextInt(skateLost.size());
				text = skateLost.get(randIndex);
				hasPuck = cTeam.getWing();
				}
			} else if (action.equals("skate") && won == false){
				int randIndex = new java.util.Random().nextInt(skateLost.size());
				text = skateLost.get(randIndex);
				hasPuck = cTeam.getWing();
		}
		dialog.put(hasPuck, text);
		return dialog;
		}
	
	public static void clearScreen() {
		char c = '\n';
		int length = 60;
		char[] chars = new char[length];
		Arrays.fill(chars, c);
		System.out.print(String.valueOf(chars));
	}
	
	public static String actionMenu(int remTurns) {
		Scanner scan = new Scanner(System.in);
		String sel = null;
		
		System.out.println("Your team has possession.");
		System.out.println("_________________________");
		System.out.println("PASS | SHOOT | SKATE");
		System.out.println("_________________________");
		System.out.println("Turns: " + remTurns);
		
		sel = scan.nextLine().toLowerCase();
		clearScreen();
		
		return sel;
	}
}
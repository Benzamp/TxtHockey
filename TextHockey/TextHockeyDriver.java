package TextHockey;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TextHockeyDriver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		TeamMethods teamMethods = new TeamMethods();
		GameplayMethods gameMethods = new GameplayMethods();
		
		boolean more = true;
		while (more) {
			gameMethods.mainMenu();
				
			Team playerTeam = new Team();
			Team comTeam = new Team();
				
			System.out.println("Choice: ");
			int choice = scan.nextInt();
			scan.nextLine();
			System.out.println();
				
			if (choice == 1) {
				ArrayList<Team> teams = new ArrayList<>();
				playerTeam = teamMethods.createdTeam();
				teams = teamMethods.generateTeam(1);
				comTeam = teams.get(0);
				gameMethods.gameLoop(playerTeam, comTeam);
				
					
			} else if (choice == 2) {
				ArrayList<Team> teams = new ArrayList<>();
				teams = teamMethods.generateTeam(2);
					
				Team yourTeam = teams.get(0);
				comTeam = teams.get(1);
					
				System.out.println(yourTeam + "\n");
				System.out.println("--------------------------------\n");
				System.out.println(yourTeam.getCenter());
				System.out.println(yourTeam.getWing());
				System.out.println(yourTeam.getDefense());
				System.out.println(yourTeam.getGoalie());
					
				System.out.println("Continue with this team? (Y/N)");
				String sel = scan.nextLine().toUpperCase();
					
				if (sel.compareTo("Y") == 0) {
					playerTeam = yourTeam;
					System.out.println("You have selected to play as " + yourTeam + ".\n");
					gameMethods.clearScreen();
					gameMethods.gameLoop(playerTeam, comTeam);
					System.out.println("Would you like to play again? (Y/N)");
					String selection = scan.nextLine();
					if (selection.compareTo("Y") == 0)
						continue;
					else
						more = false;
				}
			} else {
				System.out.println("Goodbye!");
			}
		}
	}
}


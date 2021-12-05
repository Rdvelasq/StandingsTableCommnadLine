import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TeamRepo teamRepo = new TeamRepo();
		FieldPlayerRepo fpRepo = new FieldPlayerRepo();
		GameRepo gameRepo = new GameRepo();
		Boolean keepGoing = true;
		Scanner input = new Scanner(System.in);
		
		FieldPlayer fp = new FieldPlayer(1, "Robert", "Velasquez", 0, 0);
		fpRepo.AddFieldPlayer(fp);
		Team team1 = new Team(1, "Red", 2, 3, 2, 8);
		teamRepo.AddTeam(team1);
		Team team2 = new Team(2, "Blue", 3 ,4 ,5, 2);
		teamRepo.AddTeam(team2);
		Team team3 = new Team(3, "Green", 4, 5, 6, 5);
		teamRepo.AddTeam(team3);
		
		while(keepGoing) {
			System.out.println("Choose a Menu");
			System.out.println("1) Team Menu");
			System.out.println("2) Field Player Menu");
			System.out.println("3) Game Menuu");			
			System.out.println("4) Exit");
			
			int userInput = input.nextInt();
			switch(userInput) {
			case 1:
				TeamMenu(teamRepo);
				break;
			case 2:
				FieldPlayerMenu(fpRepo, teamRepo);
				break;
			case 3:
				GameMenu(gameRepo, teamRepo);
				break;
			case 4:
				keepGoing = false;
				break;
			}
		}
	}
	
	public static void GameMenu(GameRepo gameRepo, TeamRepo teamRepo) {
		Scanner input = new Scanner(System.in);
		int id = 1;
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.println("1) Create Game");
			System.out.println("2) View Games");
			System.out.println("3) Update Game Score");
			System.out.println("4) Delete Game");
			System.out.println("5) View Standings Table");
			System.out.println("6) Exit");
			
			int userInput = input.nextInt();
						
			switch(userInput) {
				case 1:
					CreateGame(id, gameRepo, teamRepo);
					id++;
					break;
				case 2:
					DisplayGames(gameRepo.GetGames());
					break;
				case 3:
					UpdateGameScore(gameRepo);
					break;
				case 4:
					DeleteGame(gameRepo);
					break;
				case 5:
					ViewStandingsTable(teamRepo);
				case 6:
					keepGoing = false;
					break;
			}
		}
	}

	private static void ViewStandingsTable(TeamRepo teamRepo) {
		List<Team> teams = teamRepo.GetTeams();
		Collections.sort(teams);
		System.out.println("Position	Team Name	Wins	Draws	Loss	Points");
		int position = 1;
		for(Team team : teams) {
			String teamOutput = position +"		" + team.GetName() + "		"+ team.GetWins() + "	" + team.GetDraws() + "	" +team.GetLoss() + "	" +team.GetPoints();
			System.out.println(teamOutput);
			position++;
		}
		
	}

	public static void DeleteGame(GameRepo gameRepo) {
		DisplayGames(gameRepo.GetGames());
		Scanner input = new Scanner(System.in);
		System.out.println("Select the id of the game you want to delete");
		int id = input.nextInt();
		
		if(gameRepo.DeleteGame(id)) {
			System.out.println("Game has been deleted");
		}
		else {
			System.out.println("Unable to delete Game");
		}
		
	}

	public static void UpdateGameScore(GameRepo gameRepo) {
		Scanner input = new Scanner(System.in);
		DisplayGames(gameRepo.GetGames());
		
		System.out.println("Select the id of the Game Score you want to Change");
		int id = input.nextInt();
		
		Game oldGame = gameRepo.GetGameById(id);
		
		String homeScore = "Home Team Score? (" + oldGame.GetHomeTeam().GetName() + " " + oldGame.GetHomeTeamScore() + ")";
		System.out.println(homeScore);
		int newHomeScore = input.nextInt();
		
		String awayScore = "Away Team Score? (" + oldGame.GetAwayTeam().GetName() + " " + oldGame.GetAwayTeamScore() + ")";
		System.out.println(awayScore);
		int newAwayScore = input.nextInt();
		
		Game updatedGame = new Game(oldGame.GetId(), oldGame.GetHomeTeam(), newHomeScore, oldGame.GetAwayTeam(), newAwayScore);
		gameRepo.UpdateScore(oldGame, updatedGame);
	}

	public static void CreateGame(int id, GameRepo gameRepo, TeamRepo teamRepo) {
		id++;
		Scanner input = new Scanner(System.in);
		ViewTeams(teamRepo.GetTeams());
		
		System.out.println("Select the Id of the Home Team");
		int homeTeamId = input.nextInt();
		Team homeTeam = teamRepo.GetTeamById(homeTeamId);
		System.out.println("What was the score for the Home Team");
		int homeTeamScore = input.nextInt();
		
		System.out.println("Select the Id of the Away Team");
		int awayTeamId = input.nextInt();
		Team awayTeam = teamRepo.GetTeamById(awayTeamId);
		System.out.println("What was the score for the Away Team");
		int awayTeamScore = input.nextInt();
				
		Game game = new Game(id, homeTeam, homeTeamScore, awayTeam, awayTeamScore);
		gameRepo.AddGame(game);
		System.out.println("Game has been adedd");		
	}

	private static void FieldPlayerMenu(FieldPlayerRepo fpRepo, TeamRepo teamRepo) {
		Scanner input = new Scanner(System.in);
		int id = 1;
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.println("1) Create Player");
			System.out.println("2) View Players");
			System.out.println("3) Update Player Name");
			System.out.println("4) Delete Player");
			System.out.println("5) Assign Player to Team");
			System.out.println("6) Exit");
						
			int userInput = input.nextInt();
						
			switch(userInput) {
				case 1:
					CreateFieldPlayer(id, fpRepo);
					id++;
					break;
				case 2:
					DisplayFieldPlayers(fpRepo.GetFieldPlayers());
					break;
				case 3:
					UpdateFieldPlayerName(fpRepo);
					break;
				case 4:
					DeleteFieldPlayer(fpRepo);
					break;
				case 5:
					AssignPlayerToTeam(fpRepo, teamRepo);
					break;
				case 6:
					keepGoing = false;
					break;
					
			}
		}
		
	}

	public static void AssignPlayerToTeam(FieldPlayerRepo fpRepo, TeamRepo teamRepo) {
		Scanner input = new Scanner(System.in);
		
		DisplayFieldPlayers(fpRepo.GetFieldPlayers());
		System.out.println("Select the Id of the player you want to assign to a team");
		int fpId = input.nextInt();
		FieldPlayer fp = fpRepo.GetFieldPlayerById(fpId);
		
		ViewTeams(teamRepo.GetTeams());
		String outPut = "Select the Team Id you want to assign" + fp.GetFullName() + " to";
		System.out.println(outPut);
		int teamId = input.nextInt();
		teamRepo.AddPlayerToTeam(fp, teamId);
		
	}

	private static void DeleteFieldPlayer(FieldPlayerRepo fpRepo) {
		Scanner input = new Scanner(System.in);
		DisplayFieldPlayers(fpRepo.GetFieldPlayers());
		
		System.out.println("Select the Id of the Field Player you want to remove");
		int id = input.nextInt();
		FieldPlayer fp = fpRepo.GetFieldPlayerById(id);
		
		if(fpRepo.DeleteFieldPlayer(id)) {
			String output = fp.GetFullName() + " has been deleted";
			System.out.println(output);
		}
		else {
			System.out.println("Unable to delete field player");
		}
	}

	private static void UpdateFieldPlayerName(FieldPlayerRepo fpRepo) {
		Scanner input = new Scanner(System.in);
		DisplayFieldPlayers(fpRepo.GetFieldPlayers());
		
		System.out.println("Select the Id of the Player you want to edit");
		int id = input.nextInt();
		
		FieldPlayer oldFp =  fpRepo.GetFieldPlayerById(id);
		
		String firstNameOutput = "First Name? (" + oldFp.GetFirstName() + ")";
		System.out.println(firstNameOutput);
		String newFirstName = input.next();
		
		String lastNameOutput = "Last Name? (" + oldFp.GetLastName() + ")";
		System.out.println(lastNameOutput);
		String newLastName = input.next();
	
		
		FieldPlayer newFieldPlayer = new FieldPlayer();
		newFieldPlayer.SetFirstName(newFirstName);
		newFieldPlayer.SetLastName(newLastName);
		fpRepo.UpdateFieldPlayer(newFieldPlayer, oldFp);
		
	}		

	public static void CreateFieldPlayer(int id, FieldPlayerRepo fpRepo) {
		Scanner input = new Scanner(System.in);
		System.out.println("First Name?");
		String firstName = input.next();
		
		System.out.println("Last Name");
		String lastName = input.next();
		
		System.out.println("Are you a GK? y|n");
		String isGK = input.next();
		String sIsGK = new String(isGK);
		
		
		if(sIsGK.equals("y")) {
			GoalKeeper newGk = new GoalKeeper(id, firstName, lastName, 0, 0, 0);
			fpRepo.AddFieldPlayer(newGk);
		}
		else if(sIsGK.equals("n")) {
			FieldPlayer fp = new FieldPlayer(id, firstName, lastName, 0, 0);
			fpRepo.AddFieldPlayer(fp);
		}
	}

	public static void TeamMenu(TeamRepo teamRepo) {
		Scanner input = new Scanner(System.in);
		int id = 1;
		boolean keepGoing = true;
		while(keepGoing) {
			System.out.println("1) Create Team");
			System.out.println("2) View Teams");
			System.out.println("3) Update Team Name");
			System.out.println("4) Delete Team");
			System.out.println("5) Exit");
			
			int userInput = input.nextInt();
			
			
			switch(userInput) {
				case 1:
					CreateTeam(id, teamRepo);
					id++;
					break;
				case 2:
					ViewTeams(teamRepo.GetTeams());
					break;
				case 3:
					UpdateTeam(teamRepo);
					break;
				case 4:
					DeleteTeam(teamRepo);
					break;
				case 5:
					keepGoing = false;
					break;
			}
		}
		
	}
	public static void DeleteTeam(TeamRepo teamRepo) {
		Scanner input = new Scanner(System.in);		
		ViewTeams(teamRepo.GetTeams());
		System.out.println("Select the Id of the team you want to delete");
		int id = input.nextInt();
		if(teamRepo.DeleteTeam(id)) {
			System.out.println("Team has been deleted");
		}
		else {
			System.out.println("Unable to delete Team");
		}
	}

	public static void UpdateTeam(TeamRepo teamRepo) {
		Scanner input = new Scanner(System.in);
		List<Team> teams = teamRepo.GetTeams();
		ViewTeams(teams);
		System.out.println("Select the Id of the Team you want to edit");
		int id = input.nextInt();
		Team team = teamRepo.GetTeamById(id);
		String outPut = "Current team name (" + team.GetName() + ")";
		System.out.println(outPut);
		String newName = input.next();
		if(teamRepo.UpdateTeam(newName, id)) {
			System.out.println("Team Updated");
		}
		else {
			System.out.println("Unable to update Team");
		}
		
	}

	public static void CreateTeam(int id, TeamRepo teamRepo) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Team Name?");
		String teamName = input.next();
		Team team = new Team(id, teamName, 0, 0, 0, 0);
		if(teamRepo.AddTeam(team)) {
			String isCreated = team.GetName() + " team has been added";
			System.out.println(isCreated);
		}
		else {
			System.out.println("Unable to add team"); 
		}
	}
	public static void ViewTeams(List<Team> teams) {
		System.out.println("ID	Team Name	Wins	Draws	Loss	Points");
		for(Team team : teams) {
			String id = Integer.toString(team.GetId());
			String wins = Integer.toString(team.GetWins());
			String draws = Integer.toString(team.GetDraws());
			String loss = Integer.toString(team.GetLoss());
			String points = Integer.toString(team.GetPoints());
			
			String outPut = id + "	" + team.GetName() + "		" + wins + "	" + draws + "	" + loss + "	" + points;			
			System.out.println(outPut);
		}
	}
	public static void DisplayFieldPlayers(List<FieldPlayer> fps) {
		System.out.println("ID	First Name	Last Name  Team Name");
		for(FieldPlayer fp : fps) {	
			String id = Integer.toString(fp.GetId());
			
			if(fp.GetTeam() != null) {
				String outPut = id + "	" + fp.GetFirstName() + "		" + fp.GetLastName() + "		" + fp.GetTeam().GetName();
				System.out.println(outPut);
			}
			else {
				String outPut = id + "	" + fp.GetFirstName() + "		" + fp.GetLastName() + "		" + "No Team";
				System.out.println(outPut);
			}
		}
	}
	public static void DisplayGames(List<Game> games) {
		System.out.println("ID	Home Team	Home Team Score		Away Team	Away Team Score");
		for(Game game : games) {
			String id = Integer.toString(game.GetId());
			String homeTeamScore = Integer.toString(game.GetHomeTeamScore());
			String awayTeamScore = Integer.toString(game.GetAwayTeamScore());
			
			String outPut = id + "	" + game.GetHomeTeam().GetName() + "		" + homeTeamScore + "			" + game.GetAwayTeam().GetName() + "		" + awayTeamScore;	
			System.out.println(outPut);
		}
	}
}

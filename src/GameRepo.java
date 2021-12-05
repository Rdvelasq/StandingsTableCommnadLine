import java.util.ArrayList;
import java.util.List;

public class GameRepo {

	private List<Game> _games = new ArrayList<Game>();
	public GameRepo() {
		
	}

	public Boolean AddGame(Game game) {
		AddPointsToTeam(game);
		return _games.add(game);
	} //end AddGame
	
	public List<Game> GetGames(){
		return _games;	
	} //end GetGames
	
	public void UpdateScore(Game oldGame, Game newGame) {
		oldGame.SetAwayTeamScore(newGame.GetHomeTeamScore());
		oldGame.SetAwayTeamScore(newGame.GetAwayTeamScore());
	} //end Update Score
	
	public Boolean DeleteGame(int id) {
		Game game = GetGameById(id);
		if(game != null){
			_games.remove(game);
			return true;
		}
		return false;
	} //end Delete Game
	
	public Game GetGameById(int id) {
		for(Game game : _games) {
			if(game.GetId() == id) {
				return game;
			}
		}
		return null;
	} //end GetGameById
	
	private void AddPointsToTeam(Game game) {
		if(game.GetHomeTeamScore() > game.GetAwayTeamScore()) {
			int wins = game.GetHomeTeam().GetWins();
			int points = game.GetHomeTeam().GetPoints();
			points+=3;
			wins++;
			game.GetHomeTeam().SetWins(wins);
			game.GetHomeTeam().SetPoints(points);
			
			int loss = game.GetAwayTeam().GetLoss();
			loss++;
			game.GetAwayTeam().SetLoss(loss);
		}
		
		else if(game.GetHomeTeamScore() < game.GetAwayTeamScore()){
			int loss = game.GetHomeTeam().GetLoss();
			loss++;
			game.GetHomeTeam().SetLoss(loss);	
			
			int wins = game.GetAwayTeam().GetWins();
			int points = game.GetAwayTeam().GetPoints();
			points+=3;
			wins++;
			game.GetAwayTeam().SetPoints(points);;
			game.GetAwayTeam().SetWins(wins);	
		}
		
		else if(game.GetHomeTeamScore() == game.GetAwayTeamScore()) {
			int homeTeamDraws = game.GetHomeTeam().GetDraws();
			homeTeamDraws++;
			game.GetHomeTeam().SetDraws(homeTeamDraws);	
			
			int awayTeamDraws = game.GetAwayTeam().GetDraws();
			awayTeamDraws++;
			game.GetAwayTeam().SetDraws(awayTeamDraws);
		}
	} //end AddPointsToTeam	
}

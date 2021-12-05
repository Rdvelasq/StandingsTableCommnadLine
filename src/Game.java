public class Game {

	private int Id;
	private Team HomeTeam;
	private int HomeTeamScore;
	private Team AwayTeam;
	private int AwayTeamScore;
	
	public Game() {
		this.Id = 0;
		this.HomeTeam = null;
		this.HomeTeamScore = 1;
		this.AwayTeam = null;
		this.AwayTeamScore = 2;
	} //end Null Game
	
	public Game(int id, Team homeTeam, int homeTeamScore, Team awayTeam, int awayTeamScore) {
		this.Id = id;
		this.HomeTeam = homeTeam;
		this.HomeTeamScore = homeTeamScore;
		this.AwayTeam = awayTeam;
		this.AwayTeamScore = awayTeamScore;
	} //end OverLoaded Game
	
	public void SetId(int id) {
		this.Id = id;
	} //end SetId
	public int GetId() {
		return Id;
	} //end GetId
	
	public void SetHomeTeam(Team homeTeam) {
		this.HomeTeam = homeTeam;
	} //end SetHomeTeam
	public Team GetHomeTeam() {
		return HomeTeam;
	} //end GetHomeTeam
	
	public void SetHomeTeamScore(int homeTeamScore) {
		this.HomeTeamScore = homeTeamScore;
	} //end SetHomeTeamScore
	public int GetHomeTeamScore() {
		return HomeTeamScore;
	} //end GetHomeTeamScore
	
	public void SetAwayTeam(Team awayTeam) {
		this.AwayTeam = awayTeam;
	} //end SetAwayTeam
	public Team GetAwayTeam() {
		return AwayTeam;
	} //end GetAwayTeam
	
	public void SetAwayTeamScore(int awayTeamScore) {
		this.AwayTeamScore = awayTeamScore;
	} //end SetAwayTeamScore
	public int GetAwayTeamScore() {
		return AwayTeamScore;
	} //end GetAwayTeamScore
}

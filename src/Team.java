import java.util.ArrayList;
import java.util.List;

public class Team implements Comparable<Team> {

	private int Id;
	private String Name;
	private int Wins;
	private int Draws;
	private int Loss;
	private int Points;
	private List<FieldPlayer> FieldPlayers = new ArrayList<FieldPlayer>();
	
	public Team() {
		this.Id = 0;
		this.Name = "Unknown Team Name";
		this.Wins = 0;
		this.Draws = 0;
		this.Loss = 0;
		this.Points = 0;
		this.FieldPlayers = new ArrayList<FieldPlayer>();
	} //end null Team 
	
	public Team(int id, String name, int wins, int draws, int loss, int points) {
		this.Id = id;
		this.Name = name;
		this.Wins = wins;
		this.Draws = draws;
		this.Loss = loss;
		this.Points = points;
	}//end Team
	
	public void SetId(int id) {
		this.Id = id;
	} //end SetId
	public int GetId() {
		return Id;
	}//end GetId
	
	public void SetName(String name) {
		this.Name = name;
	} //end SetTeam
	public String GetName() {
		return Name;
	} // end GetName
	
	public void SetWins(int wins) {
		this.Wins = wins;
	} //end SetWins
	public int GetWins() {
		return Wins;
	} //end GetWins
	
	public void SetDraws(int draws) {
		this.Draws = draws;
	} //end SetDraws
	public int GetDraws() {
		return Draws;
	} //end GetDraws
	
	public void SetLoss(int loss) {
		this.Loss = loss;
	} //end SetLoss
	public int GetLoss() {
		return Loss;
	} //end GetLoss
	
	public void SetPoints(int points) {
		this.Points = points;
	} //end SetPoints
	public int GetPoints() {
		return Points;
	} //end GetPoints

	public void SetPlayer(FieldPlayer fieldPlayer) {
		FieldPlayers.add(fieldPlayer);
	} //end SetPlayer
	public List<FieldPlayer> GetPlayers(){
		return FieldPlayers;
	} //end GetPlayers
	
	//Override compareTo from Comparable interface 
	public int compareTo(Team compareTeam) { //Takes in a team to compare to 
		int comparePoints = ((Team)compareTeam).GetPoints(); //Compares the team based on their points 
		return comparePoints-this.Points; //returns the team with the highest points to the lowest
		//Implement the compareTo method as it came from the Comparable 
	} //end compareTo	
} //end Team 
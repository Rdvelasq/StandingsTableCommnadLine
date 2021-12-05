public class FieldPlayer {

	protected int Id;
	protected String FirstName;
	protected String LastName;
	protected int Goals;
	protected int Assist;
	protected Team Team;

	public FieldPlayer() {
		this.Id = 0;
		this.FirstName = "Null First Name";
		this.LastName = "Null Last Name";
		this.Goals = 0;
		this.Assist = 00;
	} //end FieldPlayer
	public FieldPlayer(int id, String firstName, String lastName, int goals, int assist) {
		this.Id = id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Goals = goals;
		this.Assist = assist; 		
	} //end Overloaded Constructor 
	
	public void SetId(int id) {
		this.Id = id;
	} //end SetId
	public int GetId() {
		return Id;
	}//end GetId
	
	public void SetFirstName(String firstName) {
		this.FirstName = firstName;
	} //end SetFirstName
	public String GetFirstName() {
		return FirstName;
	} // end GetFirstName
	
	public void SetLastName(String lastName) {
		this.LastName = lastName;
	} //end SetLastName
	public String GetLastName() {
		return LastName;
	} //end GetLastName
	
	public void SetGoals(int goals) {
		this.Goals = goals;
	} //end SetGoals
	public int GetGoals() {
		return Goals;
	} //end GetGoals
	
	public void SetAssist(int assist) {
		this.Assist = assist;
	} //end SetAssist	
	public int GetAssist(){
		return Assist;
	} //end GetAssist

	public void SetTeam(Team team) {
		this.Team = team;
	} //end SetTeam
	public Team GetTeam() {
		return Team;
	}//end GetTeam
	
	public String GetFullName() {
		String FullName = FirstName + " " + LastName;
		return FullName;
	} //end GetFullName
}

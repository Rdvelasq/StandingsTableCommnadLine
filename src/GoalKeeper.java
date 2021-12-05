public class GoalKeeper extends FieldPlayer {
	private int Saves;
	
	public GoalKeeper() {
		this.FirstName = "Null First Name";
		this.LastName = "Null Last Name";
		this.Goals = 0;
		this.Assist = 00;
		this.Saves = 000;
	} //end GoalKeper
	
	public GoalKeeper(int id, String firstName, String lastName, int goals, int assists, int saves) {
		this.Id = id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Goals = goals;
		this.Assist = assists;
		this.Saves = saves;
	} //end Overloaded Constructor GoalKeeper
	
	public void SetSaves(int saves) {
		this.Saves = saves;
	} //end SetSaves

	public int GetSaves() {
		return Saves;
	} //end GetSaves
}

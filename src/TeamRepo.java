import java.util.ArrayList;
import java.util.List;

public class TeamRepo {

	private List<Team> _teams = new ArrayList<Team>();
	public TeamRepo() {
	}
	
	public Boolean AddTeam(Team team) {
		return _teams.add(team);
	} //end AddTeam
	
	public Boolean DeleteTeam(int id) {
		Team team = GetTeamById(id);
		if(team != null) {
			return _teams.remove(team);
		}
		return false;
	} //end DeleteTeam
	
	public List<Team> GetTeams(){
		return _teams;
	} //end GetTeams
	
	public Boolean UpdateTeam(String newName, int TeamId) {
		Team team = GetTeamById(TeamId);
		if(team != null) {
			team.SetName(newName);;
			return true;
		}
		return false;
	} //end UpdateTeam
	
	public void AddPlayerToTeam(FieldPlayer fieldPlayer, int id) {
		Team team = GetTeamById(id);
		team.SetPlayer(fieldPlayer);
		fieldPlayer.SetTeam(team);
	} //end AddPlayerToTeam
	
	public Team GetTeamById(int id) {
		for(Team team : _teams) {
			if(id == team.GetId()) {
				return team;
			}			
		}
		return null;
	} //end GetTeamById
}

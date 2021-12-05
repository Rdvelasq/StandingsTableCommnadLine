import java.util.ArrayList;
import java.util.List;

public class FieldPlayerRepo {

	
	private List<FieldPlayer> _fieldPlayers= new ArrayList<FieldPlayer>(); //Store array of Field Players
	public FieldPlayerRepo() {
		
	}
	
	public Boolean AddFieldPlayer(FieldPlayer fieldPlayer) {
		return _fieldPlayers.add(fieldPlayer);
	} //end AddFieldPlayer
	
	public Boolean DeleteFieldPlayer(int id) {
		FieldPlayer fp = GetFieldPlayerById(id);
		return _fieldPlayers.remove(fp);
	} //end DeleteFieldPlayer
	
	public List<FieldPlayer> GetFieldPlayers(){
		return _fieldPlayers;
	} //end GetFieldPlayers
	
	public void UpdateFieldPlayer(FieldPlayer updatedFp, FieldPlayer oldFp) {
		oldFp.SetFirstName(updatedFp.GetFirstName());
		oldFp.SetLastName(updatedFp.GetLastName());
		//oldFp.FirstName = updatedFp.FirstName;
		//oldFp.LastName = updatedFp.LastName;
		
	} //end UpdateFieldPlayer
	
	public FieldPlayer GetFieldPlayerById(int id) {
		for(FieldPlayer fp : _fieldPlayers) {
			if(fp.Id == id) {
				return fp;
			}
		}
		return null;
	} //end GetFieldPlayerById;	
}


public class GramCalculations {

	private int desiredProtein;
	private int desiredFat;
	private int desiredCarbs;
	
	public int getDesiredProtein() {
		return desiredProtein;
	}
	
	public void setDesiredProtein(int protein, int desired_weight) {
		this.desiredProtein = protein;
	}
	
	public int getDesiredFat() {
		return desiredFat;
	}
	
	public void setDesiredFat(int fat, int desired_weight) {
		this.desiredFat = fat/2;
	}
	
	public int getDesiredCarbs() {
		return desiredCarbs;
	}
	
	public void setDesiredCarbs(int carbs, int desired_weight, String choice) {
		if (choice.equals("lose")) {
			this.desiredCarbs = desired_weight;
		} else if (choice.equals("maintain")) {
			this.desiredCarbs = desired_weight*2;
		} else if (choice.equals("gain")) {
			this.desiredCarbs = desired_weight*3;
		}
	}
}
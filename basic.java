import java.util.Scanner;

public class basic
{
	public static void main(String[] args)
	{
		int weight,
			desired_weight,
			protein, //1g per lb in protein 
			fat, //.5g per lb of desired body weight. Ex. weight 200, want to be 160, then 80g of fat
			carbs; /**For fat loss: 1 gram of carbohydrate per pound of desired bodyweight.
		   			  For maintenance: 2 grams of carbohydrate per pound of desired bodyweight.
		   			  For muscle gain: 3 grams of carbohydrate per pound of desired bodyweight.**/
		String choice = "";
		
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter weight: ");
		weight = s.nextInt();
		System.out.println("Please enter desired weight: ");
		desired_weight = s.nextInt();
		
		if (desired_weight < weight) {
			choice = "lose";
		} else if (desired_weight == weight) {
			choice = "maintain";
		} else if (desired_weight > weight) {
			choice = "gain";
		}

		GramCalculations gramCalculations = new GramCalculations();
		
		gramCalculations.setDesiredProtein(weight, desired_weight);
		gramCalculations.setDesiredFat(weight, desired_weight);
		gramCalculations.setDesiredCarbs(weight, desired_weight, choice);
		
		System.out.println("To "+choice+ " you need: \n" 
				+gramCalculations.getDesiredProtein()+"g of protein \n" 
				+gramCalculations.getDesiredFat()+"g of fat \n"
				+gramCalculations.getDesiredCarbs()+"g of carbs");
		
		desired_weight = s.nextInt();
	}
}

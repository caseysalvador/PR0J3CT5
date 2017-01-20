package quadraticEquation;
import java.util.Scanner;

public class quadraticMain 
{
	public static void main(String[] args)
	{
		System.out.println("Quadratic Formula");
		int a, b, c;
		double root1, root2, discriminant;
		Scanner s = new Scanner(System.in);
		System.out.println("Given the equation: ax^2 + bx + c");
		System.out.print("Enter a: ");
		a = s.nextInt();
		System.out.print("Enter b: ");
		b = s.nextInt();
		System.out.print("Enter c: ");
		c = s.nextInt();
		System.out.println("Given quadratic equation:"+a+"x^2 + "+b+"x + "+c);
		discriminant = b * b - 4 * a * c;
		if (discriminant > 0)
		{
			System.out.println("Roots are real and unequal");
            root1 = ( -b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant) ) / (2 * a);
            System.out.println("First root:"+root1);
            System.out.println("Second root:"+root2);
		}
		else if (discriminant == 0)
		{
			System.out.println("Roots are real and equal");
            root1 = (-b + Math.sqrt(discriminant))/(2*a);
            System.out.println("Root:"+root1);
		}
		else
		{
			System.out.println("Roots are imaginary");
		}
	}

}

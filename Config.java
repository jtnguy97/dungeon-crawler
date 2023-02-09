import java.util.Scanner;

public class Config{
	
	public static Scanner input = new Scanner(System.in);
	public static Integer nextInt(){
		Integer k = null;
		do{
			String value = input.next();
			try{
			k= Integer.parseInt(value);

			}catch(Exception e){
			System.out.println("You must enter a number.");
			}

		}while(k==null);
		return k;
	}

	public static Integer nextInt(int min, int max){
		Integer k = null;
		do{
			String value = input.next();
			try{
				k= Integer.parseInt(value);
			}catch(Exception e){
				System.out.printf("You must enter a number between %d and %d inclusive.\n", min, max);
			}
		}while(k==null&& k<min && k>max);
		return k;
	}

	public static int rand(int max){
		return (int)(Math.random()*max)+1;
	}

	public static void waitNext(){
		System.out.println("Press enter to continue.");
		input.nextLine();
	}
}
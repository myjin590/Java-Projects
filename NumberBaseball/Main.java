import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String args[]){

		ArrayList<Player> players = new ArrayList<Player>();
		boolean isGood = false;
		
		
		printLine();
		System.out.println("	  Number Baseball Game      ");
		printLine();
		
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 2; i++) {
			Player p = new Player();
			System.out.println("Please enter player " + (i+1) + "'s name: ");
			do {
				try {
					p.setName(input.next());
					isGood = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while(!isGood);
			printLine();
	
			
			isGood = false;
			do{
				printEnterNumber();
				printLine();
				
				System.out.println("[X][][] ");
				try {
					p.setNumber(input.nextInt(), 0);
					isGood = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while(!isGood);
			isGood = false;
			
			do {
				System.out.println("[O][X][] ");
				try {
					p.setNumber(input.nextInt(), 1);
					isGood = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}while (!isGood);
			
			isGood = false;
			
			do {
				System.out.println("[O][O][X] ");
				try {
					p.setNumber(input.nextInt(), 2);
					players.add(p);
					isGood = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while(!isGood);
			System.out.println("[O][O][O] Success!");
			printLine();
		}
		
		System.out.println("		Game Start!		");
	
		boolean exit = false;
		int p1 = 0;
		int p2 = 1;

		while(!exit){
			System.out.println("Player " + (p1+1) + ". it's your turn. Guess player" + (p2+1) + "'s numbers");
			System.out.println("\n");
			
			ArrayList<int[]> histories = new ArrayList<int[]>();
			ArrayList<int[]> bsk = new ArrayList<int[]>();
			
			
			int historyIndex = 0;
			System.out.println("Your History\n");
			if(p1 == 0) {
				histories = players.get(0).getHistory(); 
				bsk = players.get(0).getBSK();
			}
			else {
				histories = players.get(1).getHistory();
				bsk = players.get(1).getBSK();
			}
			for (int i = 0; i<histories.size(); i++) {
			
				int [] h_number = histories.get(i);
				System.out.println(Arrays.toString(h_number));

				int [] h_bsk = bsk.get(i);
	
				System.out.println(h_bsk[0] + "B " +h_bsk[1] + "S " + h_bsk[2]+ "O");
				
			}
			//if(histories != null) {
			
			//}
			System.out.println("*************************");
			exit = guessNumber(players, p2);
			int temp = p1; // 0
			p1 = p2; // 1
		    p2 = temp; // 0
		}
		
	}
	

	public static boolean guessNumber(ArrayList<Player> players, int index) {
		Scanner input = new Scanner(System.in);
		int[] guess = new int[3];
		for(int i=0; i<3; i++) {
			System.out.println("Enter " + (i+1) + " number: ");
			guess[i] = input.nextInt();
		}
		if(players.get(index).isCorrect(guess)) {
			
			System.out.println("		   You win!          ");
			System.out.println("---------------------------------------------------------");
			System.out.println("		   Game Over		 ");
			System.out.println("---------------------------------------------------------");
			return true;
		}
		else {
			System.out.println("*************************");
			System.out.println("*	Ball   ---> " + players.get(index).ball+ "	*");
			System.out.println("*	Strike ---> " + players.get(index).strike+ "	*");	
			if (players.get(index).out) {
				System.out.println("*	Out   ---> 1   *");
			}
			else {
				System.out.println("*	Out    ---> 0   *");
			}
			System.out.println("*************************");
			//save history
			if(index == 0) {
				players.get(1).setHistory(guess, players.get(0).getNumber());
			}
			else {
				players.get(0).setHistory(guess, players.get(1).getNumber());
			}
			//players.get(index).setHistory(guess);

		}
		return false;
	}
	
	public static void printLine() {
		System.out.println("---------------------------------------------------");
		System.out.println("---------------------------------------------------");
	}
	
	public static void printEnterNumber() {
		System.out.println("Please enter the number for X position");
	}
}

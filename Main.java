import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String args[]){
		ArrayList<Player> players = new ArrayList<Player>();
		boolean isGood = false;
		
		
		System.out.println("-----------------------------------------");
		System.out.println("	  Number Baseball Game      ");
		System.out.println("-----------------------------------------");
		
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
			System.out.println("Please enter number, it should be 3 digits");
			
			isGood = false;
			do{
				System.out.println("Enter First digit : ");
				try {
					p.setNumber(input.nextInt(), 0);
					isGood = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while(!isGood);
			isGood = false;
			
			do {
				System.out.println("Enter Second digit : ");
				try {
					p.setNumber(input.nextInt(), 1);
					isGood = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}while (!isGood);
			
			isGood = false;
			
			do {
				System.out.println("Enter Third digit : ");
				try {
					p.setNumber(input.nextInt(), 2);
					players.add(p);
					isGood = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while(!isGood);
		}
		
		
	    System.out.println("Success!");
		System.out.println("Game Start!");
		
		boolean exit = false;
		int p1 = 0;
		int p2 = 1;
		//loop while someone correct the numbers!
		while(!exit){
			System.out.println("Player " + (p1+1) + ". it's your turn. Guess player" + (p2+1) + "'s numbers");
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
			System.out.println("Enter" + (i+1) + " number: ");
			guess[i] = input.nextInt();
		}
		if(players.get(index).isCorrect(guess)) {
			
			System.out.println("		   You win!          ");
			System.out.println("-----------------------------------------------");
			System.out.println("		   Game Over		 ");
			System.out.println("-----------------------------------------------");
			return true;
		}
		else {
			System.out.println("Ball - " + players.get(index).ball);
			System.out.println("Strike - " + players.get(index).strike);
			System.out.println("Out - ");
			if (players.get(index).out) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
		return false;
	}
	
}

import java.util.ArrayList;

public class History{
	ArrayList<int[]> history = new ArrayList<int[]>();
	ArrayList<int[]> bsk = new ArrayList<int[]>(); //bsk
	//int[] triedNumber;
	//ball, strike, out
	
	History(){};
	
	public void addHistory(int[] num, int[] bsk) {
		this.history.add(num);
		this.bsk.add(bsk);
	}
	
	public ArrayList<int[]> getHistory() {
		return history;
	}
	
	public ArrayList<int[]> getBSK(){
		return bsk;
	}
}

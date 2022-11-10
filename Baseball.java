
public class Baseball{


	
	
	protected int ball;
	protected int strike;
	protected boolean out;
	
	public void setBall(int ball) {
		this.ball = ball;
	}

	public void setStrike(int strike) {
		this.strike = strike;
	}

	public void setOut(boolean out) {
		this.out = out;
	}
	public int getBall(){
		return ball;
	}
	public int getStrike() {
		return strike;
	}
	public boolean getOut() {
		return out;
	}
	
	//num o, place x-> ball
	public int calculateBall (int[] original, int[] number) {
		int b = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				
				if((original[i] == number[j]) && i!=j) {
					b++;
				}
			}
		}
		return b;
	}
	
	//num o, place o -> str
	public int calculateStrike(int[] original, int[] number) {
		int s = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if((original[i] == number[j]) && i==j) {
					s++;
				}
			}
		}
		return s;
	}	
	
	//num x, place x ->out
	public boolean calculateOut(int[] original, int[] number) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(original[i] == number[j]) {
					return false;
				}
			}
		}
		return true;
	}	
		
}

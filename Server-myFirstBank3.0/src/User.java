

public class User {

	int cardNum ;
	String password ;
	float  money ;
	
	
	public User(int cardNum, String password, float money) {
	
		this.cardNum = cardNum;
		this.password = password;
		this.money = money;
	}


	public int getcardNum() {
		return cardNum;
	}


	public void setcardNum(int cardNum) {
		this.cardNum = cardNum;
	}


	public String getpassword() {
		return password;
	}


	public void setpassword(String password) {
		this.password = password;
	}


	public float getMoney() {
		return money;
	}


	public void setMoney(float money) {
		this.money = money;
	}
	

	
	
	
}





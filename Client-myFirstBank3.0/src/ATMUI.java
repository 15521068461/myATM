

import java.util.Scanner;



public class ATMUI {
	public static void main(String[] args) throws Exception  {
		denglu();	
	}
	
/***********************************************************************************************************/	
	 // 业务对象
	static ATMBO bo = new ATMBO();

	public static void denglu() throws Exception {
		// 用户登录                                              
		System.out.print("请输入卡号：");
		int cardNum = getInt();		        
		System.out.print("请输入密码：");
	    String password = getString();
		int index = 0 ;
			if (bo.sign(cardNum, password)!=0) {
				index = bo.sign(cardNum, password); //类似Cookie机制
				while (true) {
					showOptions();
				
				// 选择需要的业务
				int choic = getInt();
			
				switch (choic) {
				case 1:// 查询余额
					chaxun(index);
					break;
				case 2: // 取款
					qukuang(index);
					break;
				case 3: // 存款
					cunkuang(index);
					break;
				case 4: // 转账
					zhuanzhang(index);
					break;
				case 5:		
					System.out.println("账号已退出！");
					denglu();
					break;
				default:
					System.out.println("请输入有效数字");
				}
			 }
		}
			else {
				System.out.println("登录失败,请重新登录！");
				denglu();
				return;
			}
			
		}
	// 查询余额
	public static void chaxun(int index) throws Exception {
		System.out.println("您的余额为：" + bo.checkMoney(index) + "元");  
		}   
	// 取款
	public static void qukuang(int index) throws Exception {
		System.out.print("请输入您想要取出的金额：");
		
		float getmoney = getFloat();
		if (bo.getMoney(getmoney,index)) {
			System.out.println("取出金额成功，当前余额为：" + bo.checkMoney(index) + "元");
		}else {
			  System.out.println("余额不足！！");
		 }
		}
	// 存款
	public static void cunkuang(int index) throws Exception {
		System.out.println("请输入您想要存入的金额:");					
		float putmoney = getFloat();
		if (bo.putMoney(putmoney,index)) {
			System.out.println("取出金额成功，当前余额为：" + bo.checkMoney(index) + "元");
		}else {
			System.out.println("存钱不能为负值");
		}
		}
	// 转账
	public static void zhuanzhang(int index) throws Exception {
		System.out.print("请输入对方账号：");
		int othercardNum = getInt();
		System.out.println("请输入转账金额：");
		float money = getFloat();	
	int temp = bo.transfer(othercardNum, money,index);
		if (temp==1) {
			System.out.println("转账成功，当前余额为：" + bo.checkMoney(index) + "元");
		} else if(temp==-2){
			System.out.println("余额不足");	
		} else if(temp==-1){
			System.out.println("该账号不存在");
		}
	}
	
	
	
	//显示操作选项
	public static void showOptions() {
		System.out.println("首页，请选择业务！");
		System.out.println("1.查询");
		System.out.println("2.取钱");
		System.out.println("3.存钱");
		System.out.println("4.转账");
		System.out.println("5.退出");
	}
	//键盘输入Int变量
	public static int getInt() {
		Scanner scanner = new Scanner(System.in);
		int result = scanner.nextInt();
		return result;
	}
	//键盘输入float变量
	public static float getFloat() {
		Scanner scanner = new Scanner(System.in);
		float result = scanner.nextFloat();
		return result;
	}
	//键盘输入String变量
	public static String getString() {
	Scanner scanner = new Scanner(System.in);
	String result = scanner.nextLine();
	return result;
	}
	
	
}

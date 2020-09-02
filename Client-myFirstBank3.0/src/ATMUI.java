

import java.util.Scanner;



public class ATMUI {
	public static void main(String[] args) throws Exception  {
		denglu();	
	}
	
/***********************************************************************************************************/	
	 // ҵ�����
	static ATMBO bo = new ATMBO();

	public static void denglu() throws Exception {
		// �û���¼                                              
		System.out.print("�����뿨�ţ�");
		int cardNum = getInt();		        
		System.out.print("���������룺");
	    String password = getString();
		int index = 0 ;
			if (bo.sign(cardNum, password)!=0) {
				index = bo.sign(cardNum, password); //����Cookie����
				while (true) {
					showOptions();
				
				// ѡ����Ҫ��ҵ��
				int choic = getInt();
			
				switch (choic) {
				case 1:// ��ѯ���
					chaxun(index);
					break;
				case 2: // ȡ��
					qukuang(index);
					break;
				case 3: // ���
					cunkuang(index);
					break;
				case 4: // ת��
					zhuanzhang(index);
					break;
				case 5:		
					System.out.println("�˺����˳���");
					denglu();
					break;
				default:
					System.out.println("��������Ч����");
				}
			 }
		}
			else {
				System.out.println("��¼ʧ��,�����µ�¼��");
				denglu();
				return;
			}
			
		}
	// ��ѯ���
	public static void chaxun(int index) throws Exception {
		System.out.println("�������Ϊ��" + bo.checkMoney(index) + "Ԫ");  
		}   
	// ȡ��
	public static void qukuang(int index) throws Exception {
		System.out.print("����������Ҫȡ���Ľ�");
		
		float getmoney = getFloat();
		if (bo.getMoney(getmoney,index)) {
			System.out.println("ȡ�����ɹ�����ǰ���Ϊ��" + bo.checkMoney(index) + "Ԫ");
		}else {
			  System.out.println("���㣡��");
		 }
		}
	// ���
	public static void cunkuang(int index) throws Exception {
		System.out.println("����������Ҫ����Ľ��:");					
		float putmoney = getFloat();
		if (bo.putMoney(putmoney,index)) {
			System.out.println("ȡ�����ɹ�����ǰ���Ϊ��" + bo.checkMoney(index) + "Ԫ");
		}else {
			System.out.println("��Ǯ����Ϊ��ֵ");
		}
		}
	// ת��
	public static void zhuanzhang(int index) throws Exception {
		System.out.print("������Է��˺ţ�");
		int othercardNum = getInt();
		System.out.println("������ת�˽�");
		float money = getFloat();	
	int temp = bo.transfer(othercardNum, money,index);
		if (temp==1) {
			System.out.println("ת�˳ɹ�����ǰ���Ϊ��" + bo.checkMoney(index) + "Ԫ");
		} else if(temp==-2){
			System.out.println("����");	
		} else if(temp==-1){
			System.out.println("���˺Ų�����");
		}
	}
	
	
	
	//��ʾ����ѡ��
	public static void showOptions() {
		System.out.println("��ҳ����ѡ��ҵ��");
		System.out.println("1.��ѯ");
		System.out.println("2.ȡǮ");
		System.out.println("3.��Ǯ");
		System.out.println("4.ת��");
		System.out.println("5.�˳�");
	}
	//��������Int����
	public static int getInt() {
		Scanner scanner = new Scanner(System.in);
		int result = scanner.nextInt();
		return result;
	}
	//��������float����
	public static float getFloat() {
		Scanner scanner = new Scanner(System.in);
		float result = scanner.nextFloat();
		return result;
	}
	//��������String����
	public static String getString() {
	Scanner scanner = new Scanner(System.in);
	String result = scanner.nextLine();
	return result;
	}
	
	
}

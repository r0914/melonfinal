package bank;
import java.util.Scanner;

public class Main {

	public static void main (String [] args)
	{

		//***********************************
		// 課題 [1]
		//***********************************

		//MyAccount インスタンス化
		MyAccount myAcc = new MyAccount();

		Scanner in = new Scanner(System.in);
		Scanner ne = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		//以下、学籍番号G20194の例：
		//ランダムなアカウント作成

		String user_name=null;
	    int balance=0;
	    int withdraw=0;
	    int despot=0;
		int account=0;
		int password=0;
		
		//口座番号の設定
		System.out.println("口座番号を入力してください");
		account=in.nextInt();
		myAcc.setAccNum(account);

		//暗証番号の設定
		System.out.println("暗証番号を入力してください");
		password=ne.nextInt();
		myAcc.setPass(password);

		//残高の設定
		myAcc.setBalance(300000);

		//TestATMインスタンス化
		TestATM atm = new TestATM(myAcc);
		
		int number=0;
		
		for(;;) {
		System.out.println("1. 入金");
		System.out.println("2. 出金");
		System.out.println("3. 残高照会");
		System.out.println("4. 終了");
		System.out.println("1〜4の数字を選択してください");
		number=sc.nextInt();
		
		if(number==1) {
	       System.out.print("入金額を入力してください: ");
	       despot=in.nextInt();
	       System.out.println("入金額: "+ despot + " 円");
	       atm.deposit(despot); //入金処理
	       atm.showCurrentBalance(); //表示
		}
		if(number==2) {
			if(myAcc.m_balance==0)
	        System.out.print("残高がありません");
			else{
				System.out.print("引き出し額を入力してください: ");
		        withdraw=in.nextInt();  //出金希望額
		        atm.withdraw(withdraw); //出金処理
		        atm.showCurrentBalance(); //表示
	        }
		}
		if(number==3) atm.showCurrentBalance();
		if(number==4) break;
		}

	}
}
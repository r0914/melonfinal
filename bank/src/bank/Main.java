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
		//以下、学籍番号G20194の例：
		//ランダムなアカウント作成

		String user_name=null;
	    int balance=0;
	    int withdraw=0;
	    int despot=0;
		int account=0;
		account=in.nextInt();
		//口座番号の設定
		myAcc.setAccNum(account);

		//暗証番号の設定
		myAcc.setPass(20194);

		//残高の設定
		myAcc.setBalance(291940);

		//getterを用いた表示
		System.out.println("口座番号: "+ myAcc.getAccNum()); //口座番号
		System.out.println("パスワード: "+ myAcc.getPass()); //暗証番号
		System.out.println("残高: "+ myAcc.getBalance() + "円"); //残高

		//***********************************
		// 課題 [2]
		//***********************************

		//TestATMインスタンス化
		TestATM atm = new TestATM(myAcc);

		//[2]-1
		System.out.print("口座番号を入力してください: ");
        account=in.nextInt();
        if(account==myAcc.m_accNum){
        	System.out.print("入金額を入力してください: ");
        	despot=in.nextInt();
        	System.out.println("入金額: "+ despot + " 円");
        	atm.deposit(despot); //入金処理
        	atm.showCurrentBalance(); //表示
        }  else {
        	System.out.println("アカウントが正しくありません");
        }

		//[2]-2

		System.out.print("口座番号を入力してください: ");
        account=in.nextInt();

            if(account==myAcc.m_accNum){
               if(myAcc.m_balance==0)
               System.out.print("残高がありません");

               else{
	               System.out.print("引き出し額を入力してください: ");
	               withdraw=in.nextInt();  //出金希望額
	               atm.withdraw(withdraw); //出金処理
	               atm.showCurrentBalance(); //表示
               }
            }
            else
            	System.out.println("アカウントが正しくありません");

	}
}
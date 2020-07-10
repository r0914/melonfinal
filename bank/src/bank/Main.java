package bank;
import java.util.*;

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
		int Number = 0; 
		Number =(int)((Math.random()* 9000)+1000); 
		account=in.nextInt();
		//口座番号の設定
		myAcc.setAccNum(account);
		
		//暗証番号の設定
		myAcc.setPass(20194);
		
		//残高の設定
		myAcc.setBalance(291940);
		
		//getterを用いた表示
		System.out.println("Account Number: "+ myAcc.getAccNum()); //口座番号
		System.out.println("Password: "+ myAcc.getPass()); //暗証番号
		System.out.println("Balance: "+ myAcc.getBalance() + "JPY"); //残高
		
		//***********************************
		// 課題 [2] 
		//***********************************
		
		//TestATMインスタンス化
		TestATM atm = new TestATM(myAcc);
		
		//[2]-1	
		System.out.print("口座番号を入力してください: ");
        account=in.nextInt();//入金額
     if(account==myAcc.m_accNum){
     System.out.print("入金額を入力してください: ");
     despot=in.nextInt();
     myAcc.Acc_Balance=despot;
     System.out.println("Start deposit: "+ account + " JPY");
     atm.deposit(account); //入金処理
		atm.showCurrentBalance(); //表示
  }  else {
        System.out.println("アカウントが正しくありません");          
       break;
       }
     
		//[2]-2
		
		System.out.print("口座番号を入力してください: ");
        account=in.nextInt();
        
            if(account==myAcc.Acc_num){                         
               if(myAcc.Acc_Balance==0)
               System.out.print("アカウントが正しくありません");
               
               else{
               System.out.print("引き出し額を入力してください: ");   
               withdraw=in.nextInt();  //出金希望額
               
               if(withdraw>myAcc.Acc_Balance){
               System.out.print("残高を超えています: ");
               withdraw=in.nextInt();
               }
               else
               balance= myAcc.withdraw(withdraw);
               
               System.out.println("Start withdraw: "+ withdraw + " JPY");
       		atm.withdraw(withdraw); //出金処理
       		atm.showCurrentBalance(); //表示
       		
               System.out.println("現在の残高"+balance);   
               }
            }
               else
               System.out.println("アカウントが正しくありません");  
          break;
		
		
		//[2]-3
		withdraw = 1120000; //出金希望額
		System.out.println("Start withdraw: "+ withdraw + " JPY");
		atm.withdraw(withdraw); //出金処理
		atm.showCurrentBalance(); //表示		
	}
}
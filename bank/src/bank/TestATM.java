

package bank;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestATM {

	//メンバ変数
	private MyAccount m_myAcc;

	//Constructor
	public TestATM(MyAccount acc)
	{
		m_myAcc = acc;
	}

	//入金処理
	public void deposit (int cash_deposit)
	{
		//現在の残高取得
		int current = m_myAcc.getBalance();

		//残高更新（現在の残高+入金額）
		m_myAcc.setBalance(current + cash_deposit);
	}

	//出金処理、時間帯によって手数料がかかる
	public void withdraw(int cash_want)
	{
		//現在の残高取得
		int current = m_myAcc.getBalance();

		//出金希望額の方が多い場合
		if (current < cash_want)
		{
			System.out.println("引き出し額: " + cash_want + " 円");
			System.out.println("残高: "+ current + " 円");
		}

		//出金できる場合、残高を更新（現在の残高-出金額）
		else
		{
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		    SimpleDateFormat sdf = new SimpleDateFormat("kmm");
		    String str = sdf.format(timestamp);
		    int time = Integer.parseInt(str);
		    
		    SimpleDateFormat sdf1 = new SimpleDateFormat("u");
		    String str1 = sdf1.format(timestamp);
		    int day = Integer.parseInt(str1);
		    
			if((800<time&&time<1800)&&(day!=6)&&(day!=7)) {
				System.out.println("この時間は手数料がかかりません");
				m_myAcc.setBalance(current - cash_want);
			}
			else {
				System.out.println("この時間は手数料が500円かかります");
			m_myAcc.setBalance(current - (cash_want+500));
			}
		}
	}

	//残高表示処理
	public void showCurrentBalance()
	{
		int current = m_myAcc.getBalance();

		System.out.println("残高: "+ current + "　円");
	}
	
}


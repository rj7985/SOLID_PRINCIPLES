package com.Solid.LSP;

import java.util.ArrayList;
import java.util.List;

abstract class dipositeOnly
{
	abstract void diposite(double amount);
	
}

abstract class WithdrawAndDepositeAccount extends dipositeOnly
{
	
	abstract void withdraw(double amount);
}


class currentAccount extends WithdrawAndDepositeAccount
{

	private double balance;

    public currentAccount() {
        balance = 0;
    }
	@Override
	void withdraw(double amount) {
		if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
		
	}

	@Override
	void diposite(double amount) {
		 balance += amount;
	        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
	}
	
}

class savingAccount extends WithdrawAndDepositeAccount
{

	private double balance;

    public savingAccount() {
        balance = 0;
    }
	@Override
	void withdraw(double amount) {
		if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
		
	}

	@Override
	void diposite(double amount) {
		 balance += amount;
	        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
	}
	
	
}

class fixedAccount extends  dipositeOnly
{
	
	
    private double balance;
    
    public fixedAccount ()
    {
    	this.balance=0.0;
    }
     
     
    
	@Override
	void diposite(double amount) {
		 balance+=amount;
		 
		 System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
		
	}
	
}


 class Client
 {
	
	 List<dipositeOnly>d;
	 
	 List<WithdrawAndDepositeAccount>wd;
	 
	 
	 public Client( List<dipositeOnly>d, List<WithdrawAndDepositeAccount>wd)
	 {
		 this.d=d;
		 this.wd=wd;
	 }
	 
	 public void transactionProcess()
	 {
		 for(WithdrawAndDepositeAccount acc:wd)
		 {

			  acc.diposite(100.0);
			  acc.withdraw(50.0);
		 }
		 
		 for(dipositeOnly acc:d)
		 {
			 acc.diposite(100.0);
		 }
	 }
	 
	  
	 
	 
       }


public class LSP {
	
	public static void main(String args[])
	{
		
		List<WithdrawAndDepositeAccount>lw=new ArrayList<>();
		List<dipositeOnly>d=new ArrayList<>();
		
		d.add(new fixedAccount());
		
		
		
       lw.add(new savingAccount());
		
		lw.add(new currentAccount());
		
		
		Client c=new Client(d,lw);
		
		c.transactionProcess();
		
	}
	
	

}

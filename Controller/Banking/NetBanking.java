package Controller.Banking;
import Controller.GeneratingNumbers;
import Model.Accounts;

import Model.CreditCard;
import Model.Customer;
import Model.Server;
import View.Display.*;
import View.Generation.AccountGeneration;
import View.Generation.BankAccountGeneration;
import View.Menu.BankDisplayMenu;
import View.Menu.DisplayMenu;
import View.MenuInputProcess.BankInputProcess;
import View.MenuInputProcess.Process;
import Controller.Verification.AccountFinding;

import java.time.LocalDate;


public class NetBanking {
   public enum BankAction
    {
        ACCOUNTGENERATION,
        CREDITCARDGENERATION,
        CREDITCARDPAYMENT,
        GETCUSTOMERDETAILS,


    }
BankAccountGeneration accountGeneration=new AccountGeneration();
    private NetBanking(){}
    private static NetBanking bank=new NetBanking();
    public void bankWorking()
    {
      BankAction bankAction;
       Process process=new BankInputProcess();
        DisplayMenu displayMenu=new BankDisplayMenu();
        displayMenu.displayMenu();
        Server server= Server.getServer();
        bankAction= (BankAction) process.getProcess();
        GeneratingNumbers generatingNumbers=GeneratingNumbers.getGenerateNumbers();
        switch (bankAction) {
            case ACCOUNTGENERATION:
                Object[] detailsList=accountGeneration.accountGeneration();
                AccountDetails accountDetails=new AccountDetails();
                Customer customer=new Customer((String) detailsList[0],(long)detailsList[1],(LocalDate) detailsList[2],(long)detailsList[3],(String)detailsList[4]);
                Accounts accounts=new Accounts((long) detailsList[5],generatingNumbers.getGeneratingAccountNumber(),customer);
                accountDetails.printDetails(accounts);
                server.setAccountList(accounts);
                break;
            case CREDITCARDGENERATION:
                AccountFinding finding = new AccountFinding();
                Accounts account = finding.findingAccount();
                if(account!=null) {
                    CreditCard creditCard = account.setCreditCard(account);
                    CreditCardDetails creditCardDetailsDisplay = new CreditCardDetailsDisplay();
                    creditCardDetailsDisplay.displayDetails(creditCard);
                }
                break;
            case CREDITCARDPAYMENT:
                CreditCardBill bill = new CreditCardBill();
                Accounts accounts1=bill.billPayment();
                BalanceDisplay displayBalance=new DisplayBalance();
                displayBalance.balanceDisplay(accounts1);
                break;
            case GETCUSTOMERDETAILS:
                CustomerDetailsDisplay customerDetails=new CustomerDetailsDisplay();
               customerDetails.getDetails();
        }
    }
    public static NetBanking getBank()
    {
        return bank;
    }

}

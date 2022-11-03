package Controller.ATM;


import Model.Accounts;
import Model.Card;
import Model.Server;
import View.Verification.DataValidation;
import Controller.Verification.DataVerification;
import View.Verification.Validation;
import Controller.Verification.Verification;

public class Deposit implements AmountDeposit {

    DataVerification verify=new Verification();
    DataValidation validating=new Validation();
Accounts account;
Server server=Server.getServer();
    public Accounts deposit()
    {long accountNumber=  verify.verification(Card.CardType.DEBITCARD);
        if(accountNumber!=0)
        {
            for(Accounts list:server.getAccountList()) {
            if (list.getAccountNumber() == accountNumber) {
                account = list;
            }
          }
            long amount=validating.validation("Amount");
          account.setBalance(account.getBalance()+amount);
            System.out.println("Amount is deposited successfully");
            return account;
        }
       return null;
    }

}

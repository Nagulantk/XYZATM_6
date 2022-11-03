package Controller.ATM;

import Model.Accounts;
import Model.Card;
import Model.CreditCard;
import Model.Server;
import View.Verification.DataValidation;
import Controller.Verification.DataVerification;
import View.Verification.Validation;
import Controller.Verification.Verification;

public class Withdraw implements AmountWithdraw {

    DataVerification verify=new Verification();
    DataValidation validating =new Validation();
    Accounts account;
    Server server=Server.getServer();
    public Accounts debitCardWithdraw()
    {
        float tax;
        long accountNumber= verify.verification(Card.CardType.DEBITCARD );
        if(accountNumber!=0)
        {

            long amount=validating.validation("Amount");
            for(Accounts list:server.getAccountList()) {
                if (list.getAccountNumber() == accountNumber) {
                    account = list;
                }
            }
            if(amount%5==0&&amount<= account.getBalance())
            {
                if(amount<=100)
                {
                    tax=0.02f;
                }
                else {
                    tax=0.04f;
                }
               account.setBalance(account.getBalance()-amount-(long)(amount*tax));
                System.out.println("Amount is withdrawn successfully");
                return account;
            }
            else
            {
                System.out.println("Insufficient balance or Enter amount divisible by 5");
                return account;
            }
        }

        return null;
    }
    public CreditCard creditCardWithdraw()
    {
        long cardNumber= verify.verification(Card.CardType.CREDITCARD);
        if(cardNumber!=0) {

            long amount=validating.validation("Withdrwa Amount(Limit-100000)");
            if(amount<=100000) {
                for (Accounts list: server.getAccountList()) {
                    if (list.getCreditCard().getCardNumber() == cardNumber) {
                        if(amount<=100) {
                            list.getCreditCard().setCreditCardDue(list.getCreditCard().getCreditCardDue() +amount + (int) (amount * 0.02));
                            System.out.println("Amount is withdrawn");
                            System.out.println("Tax:" + amount * 0.02);
                        }
                        else {
                            list.getCreditCard().setCreditCardDue(list.getCreditCard().getCreditCardDue() +amount + (int) (amount * 0.04));
                            System.out.println("Amount is withdrawn");
                            System.out.println("Tax:" + amount * 0.04);
                        }
                        return  list.getCreditCard();

                    }
                }
            }

        }
        return null;
    }

}

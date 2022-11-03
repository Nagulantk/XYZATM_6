package Controller.Swiping;


import Model.Accounts;
import Model.Card;
import Model.CreditCard;
import Model.Server;
import View.Verification.DataValidation;
import Controller.Verification.DataVerification;
import View.Verification.Validation;
import Controller.Verification.Verification;

public class Swipe {
    DataVerification verify = new Verification();
   DataValidation validating = new Validation();

    Accounts account;
    Server server=Server.getServer();

    public Accounts debitCardSwipe() {
        long accountNumber = verify.verification(Card.CardType.DEBITCARD);
        if (accountNumber != 0) {

            long amount = validating.validation("Purchase Amount");
            for(Accounts list:server.getAccountList()) {
                if (list.getAccountNumber() == accountNumber) {
                    account = list;
                }
            }
            if (amount <= account.getBalance()) {
                account.setBalance(account.getBalance()-amount+(long)(amount*0.01));
                System.out.println("purchase is successfully");
                System.out.println("Cashback:" + amount * 0.01);
               return  account;
            } else {
                System.out.println("Insufficient balance");
            }
        }
        return null;
    }
    public CreditCard creditCardSwiping()
    {
        long cardNumber= verify.verification(Card.CardType.CREDITCARD);
        if(cardNumber!=0) {
            System.out.println("Enter the purchase amount(limit -100000):");
            long amount = validating.validation("Amount");

            for(Accounts list:server.getAccountList())
            {
                if(list.getCreditCard().getCardNumber()==cardNumber)
                {
                    list.getCreditCard().setCreditCardDue(list.getCreditCard().getCreditCardDue()+amount-(int)(amount*0.01));
                    System.out.println("purchase is successfully");
                    System.out.println("Cashback:"+amount*0.01);
                    return list.getCreditCard();
                }
            }

        }
        return null;

    }
}

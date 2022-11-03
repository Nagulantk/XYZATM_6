package Controller.ATM;
import Model.Accounts;
import Model.Card;
import Model.CreditCard;
import View.Display.BalanceDisplay;
import View.Display.CreditCardDueDisplay;
import View.Display.DisplayBalance;
import View.Menu.ATMDisplayMenu;
import View.Menu.DisplayMenu;
import View.MenuInputProcess.ATMInputProcess;
import View.MenuInputProcess.CardInputProcess;
import View.MenuInputProcess.Process;
public class XyzAtm {
    public enum AtmActions
    {
        DEPOSIT,
        WITHDRAW,
        GETBALANCE,
        CREDITCARDDUE
    }

   AmountWithdraw withdraw=new Withdraw();
   AmountDeposit deposit=new Deposit();
    CreditCardDueBalance due=new CreditCardDue();
   Balance balance=new AccountBalance();
   Process cardInputProcess=new CardInputProcess();
    Process atmInputProcess=new ATMInputProcess();
   public void AtmWorking()
   {

       AtmActions action;
       DisplayMenu displayMenu=new ATMDisplayMenu();
       displayMenu.displayMenu();
       action= (AtmActions) atmInputProcess.getProcess();
       Accounts account;
       BalanceDisplay displayBalance=new DisplayBalance();
       switch(action)
       {
           case DEPOSIT:
               account=deposit.deposit();
               displayBalance.balanceDisplay(account);
               break;
           case WITHDRAW:
               System.out.println("Withdraw using Debit card or Credit card:");
              Card.CardType cardType;
               cardType= (Card.CardType) cardInputProcess.getProcess();
               switch (cardType) {
                   case DEBITCARD:
                      account=withdraw.debitCardWithdraw();
                      displayBalance.balanceDisplay(account);
                       break;
                   case CREDITCARD:
                     CreditCard creditCard=withdraw.creditCardWithdraw();
                       if(creditCard!=null)
                       {
                           CreditCardDueDisplay creditCardDueDisplay=new CreditCardDueDisplay();
                           creditCardDueDisplay.displayCreditCardDue(creditCard);
                       }
                       break;
               }
               break;
           case GETBALANCE:
              account= balance.getBalance();
               displayBalance.balanceDisplay(account);

               break;
           case CREDITCARDDUE:
             CreditCard creditCard=due.creditCardDueBalance();
             CreditCardDueDisplay creditCardDueDisplay=new CreditCardDueDisplay();
                 creditCardDueDisplay.displayCreditCardDue(creditCard);

               break;
       }

   }


}

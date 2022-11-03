package Controller.Swiping;
import Model.Accounts;
import Model.Card;
import Model.CreditCard;
import View.Display.BalanceDisplay;
import View.Display.CreditCardDueDisplay;
import View.Display.DisplayBalance;
import View.MenuInputProcess.CardInputProcess;
import View.MenuInputProcess.Process;

public class SwipeMachine {
   Swipe swipe=new Swipe();
   Process process=new CardInputProcess();
   public void swipeMachineWork()
   {
       Card.CardType cardType;
       System.out.println("Swipe using Debit card or Credit card:");
       cardType= (Card.CardType) process.getProcess();
       switch (cardType) {
           case DEBITCARD:
              Accounts accounts=swipe.debitCardSwipe();
               BalanceDisplay displayBalance=new DisplayBalance();
               displayBalance.balanceDisplay(accounts);
               break;
           case CREDITCARD:
              CreditCard creditCard=swipe.creditCardSwiping();
               CreditCardDueDisplay creditCardDueDisplay=new CreditCardDueDisplay();
               creditCardDueDisplay.displayCreditCardDue(creditCard);
               break;
       }
   }
}

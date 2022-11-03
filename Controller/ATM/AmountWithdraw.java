package Controller.ATM;

import Model.Accounts;
import Model.CreditCard;

public interface AmountWithdraw {
    Accounts debitCardWithdraw();
     CreditCard creditCardWithdraw();
}

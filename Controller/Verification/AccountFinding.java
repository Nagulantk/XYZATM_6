package Controller.Verification;

import Model.Customer;
import Model.Accounts;
import Model.Server;
import View.Verification.DataValidation;
import View.Verification.Validation;

public class AccountFinding {

    DataValidation validating=new Validation();
    Server server=Server.getServer();
    public Accounts findingAccount() {

        long accountNumber = validating.validation("Account number");
        if (accountNumber != 0) {
            for (Accounts list : server.getAccountList()) {
                if (list.getAccountNumber() == accountNumber) {
                    return list;
                }
            }
        }
        System.out.println("No account found");

        return null;
    }
    public Customer customerFinding(String name,long phoneNumber,String password)
    {
        for(Accounts account:server.getAccountList())
        {
            if(account.getCustomer().getName().equals(name)&&account.getCustomer().getPhoneNumber()==phoneNumber&&account.getCustomer().getPassword().equals(password))
            {
                return account.getCustomer();
            }
        }
        return null;
    }
}

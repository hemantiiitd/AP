package ExceptionHandling.Bank;

class HandleErrors extends Exception{
    HandleErrors(String mssg){
        super(mssg);
    }
}

public class HandleBankAccountErrors{
    private static float amountDetecuded;

    static void isValidAmount(float amount) throws HandleErrors{
        if(amount == 0) throw new HandleErrors("Can't add 0 to your account");
        else if(amount < 0) throw new HandleErrors("Can't be Negative");
    }
    static void haveSufficientAmount(float totalMoney,float amountDetecuded) throws HandleErrors{
        if(totalMoney - amountDetecuded < 0 )throw new HandleErrors("Insufficient Balance");
    }
    static void isUserExist(BankAccount bankAccount) throws HandleErrors{
        if(bankAccount == null)throw new HandleErrors("No User exist");
    }
    static void isAdmin(BankAccount bankAccount)throws HandleErrors{
        if(!bankAccount.isAdmin())throw new HandleErrors("No admin access!");
    }
}

package ExceptionHandling.Bank;

import java.util.HashMap;

public class User{
    static int ID = 0;

    public HashMap<Integer, BankAccount> getUserData(int ID) {
        try {
            BankAccount temp = userData.get(ID);
            HandleBankAccountErrors.isUserExist(temp);
            HandleBankAccountErrors.isAdmin(temp);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return userData;
    }

    public void setUserData(HashMap<Integer, BankAccount> userData,int ID) throws Exception{
        try {
            BankAccount temp = userData.get(ID);
            HandleBankAccountErrors.isUserExist(temp);
            HandleBankAccountErrors.isAdmin(temp);
            this.userData = userData;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private HashMap<Integer,BankAccount> userData;

    private HashMap<Integer,BankAccount> currentlyLoggedInUser;
    private HashMap<Integer,BankAccount> currentlyAdminLoggedIn;

    public User(){
        userData = new HashMap<>();
        currentlyLoggedInUser = new HashMap<>();
        currentlyAdminLoggedIn = new HashMap<>();
    }

    public void signup(String AccountHolderName,float balance,boolean isAdmin){
        BankAccount newUser = new BankAccount(ID,AccountHolderName,balance,isAdmin);
        ID++;
        userData.put(ID,newUser);
        System.out.println("Admin Created Successfully");
        System.out.println("Your Id is :"+ID);
    }
    // Help login admin.
    public void login(int Id,boolean isAdmin){

        try{
            BankAccount temp = userData.get(ID);
            HandleBankAccountErrors.isUserExist(temp);
            HandleBankAccountErrors.isAdmin(temp);
            System.out.println("logged in Successfully");
            currentlyAdminLoggedIn.put(ID,temp);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // This will help in login Normal Person
    public void login(int Id){

        try{
            BankAccount temp = userData.get(ID);
            HandleBankAccountErrors.isUserExist(temp);
            System.out.println("logged in Successfully");
            currentlyLoggedInUser.put(ID,temp);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
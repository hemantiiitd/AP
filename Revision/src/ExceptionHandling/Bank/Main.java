package ExceptionHandling.Bank;

public class Main{
    public static void main(String[] args){
        User users = new User();

        users.login(0);
        users.signup("Hemant",0,true);
        users.login(0);
        users.getUserData(1);
    }
}
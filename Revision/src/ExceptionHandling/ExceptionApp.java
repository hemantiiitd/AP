package ExceptionHandling;

class MyException extends Exception{
    MyException(String mssg){
        super(mssg);
    }
}


class PassOrFail{
    static void pass(int marks) throws Exception{
        if(marks<30) throw new MyException("Papu Fail Hogya!!!");
    }
}
public class ExceptionApp{
    public static void main(String[] args){


        try{
           PassOrFail.pass(29);
        }catch(Exception e){
            System.out.println("Error:"+ e.getMessage());
        }finally {
            System.out.println("COde is executed Finally!");
        }

    }
}

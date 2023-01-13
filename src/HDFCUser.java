import java.util.Objects;
import java.util.UUID;

public class HDFCUser implements BankInterface{


    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public HDFCUser(String name, String password) {
        this.name = name;
        this.password = password;
        this.balance=0;
        this.rateOfInterest=7.5;
        this.accountNo= String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        HDFCUser.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance=balance+amount;
        return balance+" is your updated balance";
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword, password)){
            if(amount>balance){
                return "insufficient balance";
            }
            else {
                balance=balance-amount;
                return balance+" is your updated balance";
            }
        }
        else {
            return "wrong password entered!!";
        }
    }

    @Override
    public double calculateInterest(int years) {
        return balance+((balance*rateOfInterest*years));
    }
}

package Assignment6;

public class User {

    private String name;
    private int age;
    private String address;
    private long phoneNumber;
    private int bankAccountNumber;
    private int availableBalance;
    private String[] recentTransactions;

    public User(){
        recentTransactions = new String[10];
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public int getBankAccountNumber() {
        return bankAccountNumber;
    }
    public int getAvailableBalance() {
        return availableBalance;
    }
    public String getRecentTransactions(){
        int i = 0;
        StringBuilder s = new StringBuilder();
        while(!recentTransactions[i].equals(null)){
            s.append(recentTransactions[i]);
            i++;
        }
        return s.toString();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }
    public void addRecentTransactions(String transaction) {
        if(recentTransactions.length < 10){
            int i = 0;
            while(!recentTransactions[i].equals(null)){
                i++;
            }
            recentTransactions[i] = transaction;
        } else {
            for(int i = 0; i < 9; i++){
                recentTransactions[i] = recentTransactions[i + 1];
            }
            recentTransactions[9] = transaction;
        }
    }

}

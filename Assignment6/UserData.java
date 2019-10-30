package Assignment6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserData {

    private List currentUser;
    public Map loginData;
    public Map accountToUser;

    public UserData(){
        currentUser = new ArrayList();
        loginData = new HashMap<Integer, Integer>();
        accountToUser = new HashMap<Integer, User>();
    }

    public void addUser(User user, int password){
        currentUser.add(user);
        loginData.put(user.getBankAccountNumber(), password);
        accountToUser.put(user.getBankAccountNumber(), user);
    }

    public int getUserSize(){
        return currentUser.size();
    }

}

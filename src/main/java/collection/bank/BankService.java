package collection.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
      if( !users.containsKey(user))
        users.put(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account  account) {
        User user = findByPassport(passport);
        if(user != null){

          List<Account> list =  users.get(user);
            for (Account account1 : list) {
                if(!account1.equals(account))
                    list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : this.users.keySet()) {
            if(user.getPassport().equals(passport));
            return user;
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {

        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }

    public static void main(String[] args) {
       /* List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());*/




    }


}
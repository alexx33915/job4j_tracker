package collection.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> list;
        Optional<User> optionalUser = findByPassport(passport);
        if (optionalUser.isPresent()) {
            list = users.get(optionalUser.get());
            if (!list.contains(account))
                list.add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(
                        x -> x.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> userOptional = findByPassport(passport);
        List<Account> list;

        Optional<Account> optionalAccount = Optional.empty();

        if (userOptional.isPresent()) {

            list = users.get(userOptional.get());
            for (Account account : list) {
                if (account.getRequisite().equals(requisite)) {
                    optionalAccount = Optional.of(account);
                }


            }
        }

        return optionalAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrc = findByRequisite(srcPassport, srcRequisite);

        if (!accountSrc.isPresent()) {
            return false;
        }
        Optional<Account> accountDest = findByRequisite(destPassport, dеstRequisite);

        if (!accountDest.isPresent() && accountSrc.get().getBalance() < amount) {
            return false;
        }

        accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
        accountDest.get().setBalance(accountDest.get().getBalance() + amount);
        rsl = true;

        return rsl;
    }
}

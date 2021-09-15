package module.account;

public class AccountService {

    private static AccountService accountService = new AccountService();

    static private UserDAO userDAO = UserDAO.getInstance();

    // 싱글톤
    public static AccountService getInstance() {
        return accountService;
    }

    public UserVO findById(String id) {
        return userDAO.findById(id);
    }

    public UserVO save(UserVO user) {
        return userDAO.save(user);
    }
}

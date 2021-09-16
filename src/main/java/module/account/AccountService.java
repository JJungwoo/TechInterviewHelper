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

    public boolean deleteByUserid(String userid) {
        UserVO user = findById(userid);
        if (user == null) {
            System.out.println("등록되어 있지 않은 유저입니다.");
            return true;
        }
        return userDAO.deleteByUserid(userid);
    }

    public boolean updatePasswordByUserid(String userid, String password) {
        UserVO user = findById(userid);
        if (user == null) {
            System.out.println("등록되어 있지 않은 유저입니다.");
            return false;
        }
        return userDAO.updatePasswordByUserid(userid, password);
    }
}

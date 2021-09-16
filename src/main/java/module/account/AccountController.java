package module.account;

public class AccountController {

    private static AccountController accountController = new AccountController();

    private static AccountService accountService = AccountService.getInstance();

    // 싱글톤
    public static AccountController getInstance() {
        return accountController;
    }

    public String userCreate(UserVO user) {
        return accountService.save(user).getUserid();
    }

    public UserVO findByUserid(String userid) {
        return accountService.findById(userid);
    }
}

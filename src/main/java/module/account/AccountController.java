package module.account;

import core.Controller;
import core.UserInputParser;

public class AccountController implements Controller {

    private static AccountService accountService = AccountService.getInstance();

    public String userCreate(UserVO user) {
        return accountService.save(user).getUserid();
    }

    public UserVO findByUserid(String userid) {
        return accountService.findById(userid);
    }

    private AccountViewer accountViewer = AccountViewer.getInstance();

    @Override
    public void start() {
        dispatchCommand(accountViewer.inputInt());
    }

    @Override
    public boolean dispatchCommand(int command) {
        switch (command) {
            case 1:
                accountViewer.createUserPrint();
                UserVO user = UserInputParser.parsingStrToUserVO(accountViewer.inputStr());
                userCreate(user);
                break;
            case 0:
                return false;
            default:
                break;
        }
        return true;
    }

}

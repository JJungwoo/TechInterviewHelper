package module.account;

import core.Controller;
import core.UserInputParser;
import exception.UserNotFoundException;

public class AccountController implements Controller {

    private static AccountService accountService = AccountService.getInstance();

    public String userCreate(UserVO user) {
        return accountService.save(user).getUserid();
    }

    public boolean findByUserid(String[] userInput) {
        UserVO user = null;

        try {
            user = accountService.findById(userInput[0]);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        return user.getPassword().equals(userInput[1]);
    }

    private AccountViewer accountViewer = AccountViewer.getInstance();

    @Override
    public void start() {
        try {
            dispatchCommand(accountViewer.inputInt());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchCommand(int command) throws Exception {
        boolean status = true;
        switch (command) {
            case 1:
                accountViewer.loginPrint();
                if (!(status = findByUserid(UserInputParser.commandParsing(accountViewer.inputStr())))) {
                    accountViewer.loginFail();
                }
                break;
            case 2:
                accountViewer.createUserPrint();
                UserVO user = UserInputParser.parsingStrToUserVO(accountViewer.inputStr());
                userCreate(user);
                break;
            case 0:
                status = false;
            default:
                break;
        }
        return status;
    }

}

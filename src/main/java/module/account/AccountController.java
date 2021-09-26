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
        dispatchCommand(accountViewer.inputInt());
    }

    @Override
    public boolean dispatchCommand(int command) {
        switch (command) {
            case 1:
                accountViewer.loginPrint();
                if (findByUserid(UserInputParser.commandParsing(accountViewer.inputStr()))) {
                    System.out.println("로그인 성공");
                }
                break;
            case 2:
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

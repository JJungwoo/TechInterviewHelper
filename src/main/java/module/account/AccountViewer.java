package module.account;

import core.Viewer;

public class AccountViewer extends Viewer {

    private static AccountViewer accountViewer = new AccountViewer();

    public static AccountViewer getInstance() {
        return accountViewer;
    }

    public void createUserPrint() {
        System.out.println("추가할 계정 정보를 입력해주세요\n(띄어쓰기 기준으로 userid, password, nickname, email, role)");
    }

    public void loginPrint() {
        System.out.println("로그인 정보를 입력해주세요\n(띄어쓰기 기준으로 userid, password)");
    }
}

package core;

import module.account.AccountController;
import module.account.UserVO;

import java.util.Arrays;

// 시스템 대부분의 분기처리 담당
// DispatchController는 명령어에 따라 분기가 변경되기 때문에 싱글톤으로 객체 할당 x
public class DispatchController {

    private TechInterviewHelperViewer techInterviewHelperViewer;

    private AccountController accountController = AccountController.getInstance();

    public DispatchController() {
        techInterviewHelperViewer = new TechInterviewHelperViewer();
    }


    public void start() {
        techInterviewHelperViewer.welcomeMessage();

        while (dispatchCommand(UserInputParser.commandParsing(techInterviewHelperViewer.input(0))))

        techInterviewHelperViewer.goodbyeMessage();
        techInterviewHelperViewer.closeTechInterviewHelperViewer();
    }

    // command ex) 1
    public boolean dispatchCommand(String[] command) {
        if (command == null) {
            return false;
        }

        System.out.println("dispatchCommand 입력 값들 출력");
        Arrays.stream(command).forEach(System.out::println);

        if (command[0].equals("1")) {
            // command ex) 1
            int commandInt = Integer.parseInt(UserInputParser.commandParsing(techInterviewHelperViewer.input(1))[0]);
            switch (commandInt) {
                case 1:
                    System.out.println("추가할 계정 정보를 입력해주세요\n(띄어쓰기 기준으로 userid, password, nickname, email, role)");
                    UserVO user = UserInputParser.parsingStrToUserVO(techInterviewHelperViewer.input(2));
                    System.out.println(accountController.userCreate(user) + "가 추가되었습니다.");
                    break;
                case 2:
                    System.out.println("기능 사용 불가");
                    break;
                case 3:
                    System.out.println("기능 사용 불가");
                    break;
                case 4:
                    System.out.println("기능 사용 불가");
                    break;
                default:
                    break;
            }
        } else if(command[0].equals("0")) {
            System.out.println("종료");
            return false;
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        return true;
    }

}
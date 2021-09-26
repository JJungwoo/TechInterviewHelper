package core;

import module.account.AccountController;
import module.problem.ProblemController;

// 시스템 대부분의 분기처리 담당
// DispatchController는 명령어에 따라 분기가 변경되기 때문에 싱글톤으로 객체 할당 x
public class DispatchController implements Controller {

    private TechInterviewHelperViewer techInterviewHelperViewer;

    private AccountController accountController;
    private ProblemController problemController;

    public DispatchController() {
        techInterviewHelperViewer = new TechInterviewHelperViewer();
    }

    @Override
    public void start() {
        techInterviewHelperViewer.welcomeMessage();

        while (dispatchCommand(techInterviewHelperViewer.setModeInput()))

        techInterviewHelperViewer.goodbyeMessage();
        techInterviewHelperViewer.closeTechInterviewHelperViewer();
    }

    @Override
    public boolean dispatchCommand(int command) {
        switch (command) {
            case 1:
                accountController = new AccountController();
                accountController.dispatchCommand(1);
                break;
            case 2:
                problemController = new ProblemController();
                return problemController.dispatchCommand(3);
            case 3:
                accountController = new AccountController();
                return accountController.dispatchCommand(2);
            case 0:
                techInterviewHelperViewer.systemExit();
                return false;
            default:
                techInterviewHelperViewer.wrongInputMessage();
                break;
        }

        return true;
    }

}
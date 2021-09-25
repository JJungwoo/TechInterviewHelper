package core;

import module.account.AccountController;
import module.problem.ProblemController;

// 시스템 대부분의 분기처리 담당
// DispatchController는 명령어에 따라 분기가 변경되기 때문에 싱글톤으로 객체 할당 x
public class DispatchController implements Controller {

    private TechInterviewHelperViewer techInterviewHelperViewer;

    private ProblemController problemController = ProblemController.getInstance();

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
                AccountController accountController = new AccountController();
                accountController.start();
                break;
            case 2:
                ProblemController problemController = new ProblemController();
                problemController.start();
                break;
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
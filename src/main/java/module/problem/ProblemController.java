package module.problem;

import core.Controller;
import core.UserInputParser;

public class ProblemController implements Controller {

    private static ProblemViewer problemViewer = ProblemViewer.getInstance();

    private static ProblemController problemController = new ProblemController();

    private static ProblemService problemService = ProblemService.getInstance();

    public static ProblemController getInstance() {
        return problemController;
    }

    public void createProblem(ProblemVO problem) {
        problemService.save(problem);
    }

    public ProblemVO findById(Long id) {
        return problemService.findById(id);
    }

    @Override
    public void start() {
        dispatchCommand(problemViewer.inputInt());
    }

    @Override
    public boolean dispatchCommand(int command) {
        switch (command) {
            case 1:
                problemViewer.createProblemPrint();
                ProblemVO problem = UserInputParser.parsingStrToProblemVO(problemViewer.inputStr());
                createProblem(problem);
                break;
            case 0:
                return false;
            default:
                break;
        }
        return true;
    }
}

package module.problem;

import core.Controller;
import core.UserInputParser;

import java.util.List;
import java.util.Random;

public class ProblemController implements Controller {

    private static ProblemViewer problemViewer = ProblemViewer.getInstance();

    private static ProblemService problemService = ProblemService.getInstance();

    public void createProblem(ProblemVO problem) {
        problemService.save(problem);
    }

    public ProblemVO findById(String id) {
        return problemService.findById(id);
    }

    public List<ProblemVO> selectProblemAll() {
        return problemService.selectProblemAll();
    }

    public ProblemVO randomSelectProblem() {
        List<ProblemVO> list = problemService.selectProblemAll();
        return list.get(new Random().nextInt(list.size()));
    }



    @Override
    public void start() {
        problemViewer.problemMenuPrint();
        try {
            while (dispatchCommand(problemViewer.inputInt()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchCommand(int command) throws Exception {
        switch (command) {
            case 1:
                problemViewer.createProblemPrint();
                ProblemVO problem = UserInputParser.parsingStrToProblemVO(problemViewer.inputStrList());
                createProblem(problem);
                break;
            case 2:
                problemViewer.ListAllPrint(selectProblemAll());
                break;
            case 3:
                problemViewer.problemPrint(randomSelectProblem());
                break;
            case 4:
                problemViewer.elementPrint(randomSelectProblem());
                break;
            case 0:
                return false;
            default:
                break;
        }
        return true;
    }
}

package module.problem;

import core.Controller;
import core.UserInputParser;
import module.account.AccountService;
import util.db.DBConn;

import java.util.List;
import java.util.Random;

public class ProblemController implements Controller {

    private static ProblemViewer problemViewer = ProblemViewer.getInstance();

    private static ProblemService problemService = ProblemService.getInstance();
    private static AccountService accountService = AccountService.getInstance();

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

    public Long saveLikeProblem(Long userId, Long problemId) {
        return problemService.saveLikeProblem(userId, problemId);
    }

    public List<ProblemVO> selectUserLikeProblemAll(String userId) {
        return problemService.selectUserLikeProblemAll(userId);
    }

    @Override
    public void start() {
        try {
            do {
                problemViewer.problemMenuPrint();
            } while (dispatchCommand(problemViewer.inputInt()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchCommand(int command) throws Exception {
        DBConn dbConn = DBConn.getInstance();
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
                Long problemId = problemViewer.youLikeProblemPrint();
                saveLikeProblem(accountService.findById(dbConn.getUserid()).getId(), problemId);
                break;
            case 5:
                problemViewer.ListAllPrint(selectUserLikeProblemAll(dbConn.getUserid()));
                break;
            case 6:
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

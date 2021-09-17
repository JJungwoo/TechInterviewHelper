package module.problem;

public class ProblemController {

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
}

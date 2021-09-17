package module.problem;

public class ProblemService {

    private static ProblemService problemService = new ProblemService();

    static private ProblemDAO problemDAO = ProblemDAO.getInstance();

    public static ProblemService getInstance() {
        return problemService;
    }

    public ProblemVO save(ProblemVO problem) {
        return problemDAO.save(problem);
    }

    public ProblemVO findById(Long id) {
        return problemDAO.findById(id);
    }

    public void delete() {

    }

    public void update() {

    }
}

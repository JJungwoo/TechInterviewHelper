package module.problem;

import java.util.List;

public class ProblemService {

    private static ProblemService problemService = new ProblemService();

    static private ProblemDAO problemDAO = ProblemDAO.getInstance();

    public static ProblemService getInstance() {
        return problemService;
    }

    public ProblemVO save(ProblemVO problem) {
        return problemDAO.save(problem);
    }

    public ProblemVO findById(String id) {
        return problemDAO.findById(id);
    }

    public List<ProblemVO> selectProblemAll() {
        return problemDAO.problemSelectAll();
    }

    public Long saveLikeProblem(Long userId, Long problemId) {
        return problemDAO.saveLikeProblem(userId, problemId);
    }

    public void delete() {

    }

    public void update() {

    }
}

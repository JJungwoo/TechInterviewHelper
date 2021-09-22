package module.problem;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ProblemServiceTest {

    private static ProblemService problemService = ProblemService.getInstance();

    @Test
    public void saveTest() {
    }

    @Test
    public void findByIdTest() {
    }

    @Test
    public void selectProblemAll() {
        List<ProblemVO> list = problemService.selectProblemAll();
        for (ProblemVO problem : list) {
            assertNotNull(problem);
            System.out.println(problem.getTitle());
        }
    }

    @Test
    public void deleteTest() {
    }

    @Test
    public void updateTest() {
    }
}
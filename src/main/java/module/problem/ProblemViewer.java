package module.problem;

import core.Viewer;

public class ProblemViewer extends Viewer {

    private static ProblemViewer problemViewer = new ProblemViewer();

    public static ProblemViewer getInstance() {
        return problemViewer;
    }

    public void createProblemPrint() {
        System.out.println("추가할 문제 정보를 입력해주세요\n(띄어쓰기 기준으로 title, answer)");
    }
}

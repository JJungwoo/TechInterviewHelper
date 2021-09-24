package module.problem;

import core.Viewer;

public class ProblemViewer extends Viewer {

    private static ProblemViewer problemViewer = new ProblemViewer();

    public static ProblemViewer getInstance() {
        return problemViewer;
    }

    public void createProblemPrint() {
        System.out.println("추가할 문제 정보를 입력해주세요\n(줄바꿈 기준으로 title, answer)");
    }

    public void problemMenuPrint() {
        System.out.println("1) 문제 추가\n2) 모든 문제 출력\n3) 문제 랜덤 출력");
    }

}

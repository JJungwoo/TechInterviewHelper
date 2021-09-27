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
        System.out.println("1) 문제 추가\n2) 모든 문제 출력\n3) 문제 랜덤 출력\n4) 문제 관심에 목록 추가\n5) 관심 목록 모든 문제 출력\n0) 문제 서비스 종료");
    }

    public void problemPrint(ProblemVO problem) {
        System.out.println("문제 출력 : \n" + problem.getTitle());
        problemAnswerPrint(problem.getAnswer());
    }

    public void problemAnswerPrint(String answer) {
        System.out.println("답을 출력하려면 enter를 입력해주세요.");
        inputStr();
        System.out.println("문제 답 : \n" + answer);
    }

    public long youLikeProblemPrint() {
        System.out.println("관심 목록에 추가하고 싶은 문제 ID를 입력해주세요.");
        return inputLong();
    }

}

package core;

import java.io.IOException;

// 사용자에게 출력하거나 입력하는 기능을 담당
public class TechInterviewHelperViewer extends Viewer{

    public TechInterviewHelperViewer() {
        super();
    }

    public void closeTechInterviewHelperViewer() {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void welcomeMessage() {
        System.out.println("=============================");
        System.out.println("= Start TechInterviewHelper =");
        System.out.println("=============================");
    }

    public void goodbyeMessage() {
        System.out.println("===========================");
        System.out.println("= End TechInterviewHelper =");
        System.out.println("===========================");
    }

    public int input(int status) {
        String userInput = null;
        try {
            switch (status) {
                case 0: {
                    mainMenuPrint();
                    userInput = bufferedReader.readLine();
                } break;
                case 1: {
                    userMenuPrint();
                    userInput = bufferedReader.readLine();
                } break;
                case 2: {
                    problemMenuPrint();
                    userInput = bufferedReader.readLine();
                } break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(userInput);
    }

    private void problemMenuPrint() {
        System.out.println("1) 문제 추가\n2) 문제 찾기");
    }

    private void mainMenuPrint() {
        System.out.println("1) 유저 메뉴\n2) 문제 메뉴\n0) 종료\n명령어를 입력해주세요.");
    }

    private void userMenuPrint() {
        System.out.println("1) 유저 추가\n2) 유저 찾기\n3) 유저 패스워드 변경\n4) 유저 삭제");
    }

}

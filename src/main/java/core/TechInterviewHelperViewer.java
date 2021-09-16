package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 사용자에게 출력하거나 입력하는 기능을 모두 담당
public class TechInterviewHelperViewer {

    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    public TechInterviewHelperViewer() {
        inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);
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

    public String input(int status) {
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
                default:
                    userInput = bufferedReader.readLine();
                    break;
            }
            System.out.println("입력된 메시지 : " + userInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    private void mainMenuPrint() {
        System.out.println("1) 유저 메뉴\n 0) 종료\n명령어를 입력해주세요.");
    }

    private void userMenuPrint() {
        System.out.println("1) 유저 추가\n 2) 유저 찾기\n 3) 유저 패스워드 변경\n 4) 유저 삭제");
    }
}

package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Viewer {
    protected InputStreamReader inputStreamReader;
    protected BufferedReader bufferedReader;

    public Viewer() {
        inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);
    }

    public String inputStr() {
        String userInput = null;
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    public int inputInt() {
        int userInput = -1;
        try {
            userInput = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    public void wrongInputMessage() {
        System.out.println("잘못된 입력입니다.");
    }

    public void systemExit() {
        System.out.println("시스템 종료");
    }

}

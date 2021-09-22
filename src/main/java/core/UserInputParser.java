package core;

import module.account.UserVO;
import module.problem.ProblemVO;

// 사용자 메시지를 형태에 따라 맞게 파싱하여 객체 반환
public class UserInputParser {

    public static UserVO parsingStrToUserVO(String userInput) {
        String[] tokens = userInput.split(" ");
        if (tokens.length != 5) {
            return null;
        }
        return new UserVO.Builder()
                        .userid(tokens[0])
                        .password(tokens[1])
                        .nickname(tokens[2])
                        .email(tokens[3])
                        .role(Byte.parseByte(tokens[4]))
                        .build();
    }

    public static ProblemVO parsingStrToProblemVO(String userInput) {
        String[] tokens = userInput.split(" ");
        if (tokens.length != 2) {
            return null;
        }
        return new ProblemVO.Builder()
                            .title(tokens[0])
                            .answer(tokens[1])
                            .build();
    }

    public static String[] commandParsing(String userInput) {
        if (userInput == null) {
            return null;
        }
        return userInput.split(" ");
    }

    public static int commandParsingToInt(String userInput) {
        return Integer.parseInt(userInput);
    }
}

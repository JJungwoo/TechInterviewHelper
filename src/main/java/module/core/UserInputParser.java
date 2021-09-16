package module.core;

import module.account.UserVO;

// 사용자 메시지를 형태에 따라 맞게 파싱하여 객체 반환
public class UserInputParser {

    public static UserVO parsingStrToUserVO(String userInput) {
        String[] tokens = userInput.split(" ");
        return new UserVO.Builder()
                        .userid(tokens[0])
                        .password(tokens[1])
                        .nickname(tokens[2])
                        .email(tokens[3])
                        .role(Byte.parseByte(tokens[4]))
                        .build();
    }

    public static String[] commandParsing(String userInput) {
        if (userInput == null) {
            return null;
        }
        return userInput.split(" ");
    }
}

package module.account;

import exception.UserNotFoundException;

public class AccountService {

    private static AccountService accountService = new AccountService();

    static private UserDAO userDAO = UserDAO.getInstance();

    // 싱글톤
    public static AccountService getInstance() {
        return accountService;
    }

    public UserVO findById(String id) throws UserNotFoundException {
        UserVO user = userDAO.findById(id);
        if (user == null) {
            throw new UserNotFoundException(id + "는 등록되어 있지 않은 유저입니다.");
        }
        return user;
    }

    public UserVO save(UserVO user) {
        return userDAO.save(user);
    }

    public boolean deleteByUserid(String userid) throws UserNotFoundException {
        UserVO user = findById(userid);
        if (user == null) {
            throw new UserNotFoundException(userid + "는 등록되어 있지 않은 유저입니다.");
        }
        return userDAO.deleteByUserid(userid);
    }

    public boolean updatePasswordByUserid(String userid, String password) throws UserNotFoundException {
        UserVO user = findById(userid);
        if (user == null) {
            throw new UserNotFoundException(userid + "는 등록되어 있지 않은 유저입니다.");
        }
        return userDAO.updatePasswordByUserid(userid, password);
    }
}

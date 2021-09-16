package module.account;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountServiceTest {

    private static AccountService service = AccountService.getInstance();

    @Test
    public void findByIdTest() {
        assertEquals("testuser@gmail.com", service.findById("testuser").getEmail());
    }

    @Test
    public void saveTest() {
        UserVO user = new UserVO.Builder()
                    .userid("testuser")
                    .password("1234")
                    .nickname("tester")
                    .email("testuser@gmail.com")
                    .role((byte) 2).build();

        assertEquals("testuser",service.save(user).getUserid());
    }

    @Test
    public void deleteTest() {
        try {
            assertTrue(service.deleteByUserid("testuser"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePasswordByUseridTest() {
        try {
            assertTrue(service.updatePasswordByUserid("testuser", "1111"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

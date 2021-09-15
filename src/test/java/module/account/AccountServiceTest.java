package module.account;

import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {

    private static AccountService service = AccountService.getInstance();

    @Test
    public void findByIdTest() {
        assertEquals("testuser@gmail.com", service.findById("testuser").getEmail());
    }

    @Test
    public void save() {
        UserVO user = new UserVO.Builder()
                    .userid("testuser")
                    .password("1234")
                    .nickname("tester")
                    .email("testuser@gmail.com")
                    .role((byte) 1).build();

        assertEquals("testuser",service.save(user).getUserid());
    }
}

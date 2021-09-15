package module.account;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {

    private static AccountService service = AccountService.getInstance();

    @Test
    public void findByIdTest() {
        assertEquals("testuser@gmail.com", service.findById("testuser").getEmail());
    }
}

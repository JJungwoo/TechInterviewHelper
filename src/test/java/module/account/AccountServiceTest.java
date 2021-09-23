package module.account;

import core.DispatchController;
import org.junit.Before;
import org.junit.Test;
import util.db.DBConn;

import java.sql.Connection;

import static org.junit.Assert.*;

public class AccountServiceTest {

    private static AccountService service = AccountService.getInstance();

    private static DBConn dbConn = null;


    @Before
    public void init() {
        dbConn = DBConn.getInstance();
        dbConn.initDB("h2", "src/main/resources/h2DBinfo.propertise");
    }

    @Test
    public void findByIdTest() {
        assertEquals("testuser@gmail.com", service.findById("testuser").getEmail());
    }

    @Test
    public void saveTest() {
        Connection connection = dbConn.getConnection();
        if (connection == null) {
            System.out.println("connection null");
        }
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

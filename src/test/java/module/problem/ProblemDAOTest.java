package module.problem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.db.DBConn;
import util.db.OracleDBImpl;
import util.db.problem.ProblemOracleDBImpl;
import util.io.FileIOUtil;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ProblemDAOTest {

    private ProblemDAO problemDAO = ProblemDAO.getInstance();

    private DBConn conn = DBConn.getInstance();
    private OracleDBImpl oracleDB = null;

    @Before
    public void initDB() {
        Properties properties = FileIOUtil.jdbcGetPropertise("src/main/resources/oracleDBinfo.propertise");

        try {
            conn.setConnection(conn.getInitConnection(
                    properties.getProperty("driver-class-name"),
                    properties.getProperty("url"),
                    properties.getProperty("userid"), properties.getProperty("password")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeDB() {
        conn.closeConnection(conn.getConnection());
    }

    @Test
    public void saveTest() {
        ProblemVO problem = new ProblemVO.Builder()
                                .title("title")
                                .answer("answer")
                                .likeCount(1L)
                                .unlikeCount(0L)
                                .tid(1L)
                                .build();
        assertEquals("title", problemDAO.save(problem).getTitle());
    }

    @Test
    public void findByIdTest() {
        assertEquals("title", problemDAO.findById("1").getTitle());
    }
}
package util.io;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class FileIOTest {

    @Test
    public void getPropertiesTest() {
        Properties properties = FileIOUtil.jdbcGetPropertise("src/main/resources/oracleDBinfo.propertise");
        assertEquals(properties.getProperty("url"), "jdbc:oracle:thin:@localhost:1521:xe");
        assertEquals(properties.getProperty("userid"), "hr");
        assertEquals(properties.getProperty("password"), "hr");
    }
}

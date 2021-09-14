package util.io;

import java.io.FileReader;
import java.util.Properties;

public class FileIOUtil {
    public static Properties jdbcGetPropertise() {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileReader("src/main/resources/oracleDBinfo.propertise"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}

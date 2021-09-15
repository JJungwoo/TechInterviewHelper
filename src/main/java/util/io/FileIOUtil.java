package util.io;

import java.io.FileReader;
import java.util.Properties;

public class FileIOUtil {

    public static Properties jdbcGetPropertise(String filePathDBPropertise) {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileReader(filePathDBPropertise));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }


}

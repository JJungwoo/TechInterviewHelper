package util.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public static String getFileToStr(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        StringBuffer sb = new StringBuffer();

        String str;
        while ((str = reader.readLine()) != null) {
            sb.append(str);
        }
        reader.close();

        return sb.toString();
    }

}

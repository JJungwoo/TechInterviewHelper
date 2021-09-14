package util.db;

public class H2DBImpl extends DBUtil {

    @Override
    public void loadDriver() throws Exception {
        try {
            Class.forName(H2_DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            throw new Exception("Unable to register driver class", e);
        }
    }

}

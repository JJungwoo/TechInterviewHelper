package util.db;

public class H2DBImpl extends DBUtil {

    @Override
    public void loadDriver() {
        try {
            Class.forName(H2_DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

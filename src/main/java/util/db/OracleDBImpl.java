package util.db;

public class OracleDBImpl extends DBUtil {

    @Override
    public void loadDriver() {
        try {
            Class.forName(ORACLE_DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

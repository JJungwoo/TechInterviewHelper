package util.db;

public class OracleDBImpl extends DBUtil {

    @Override
    public void loadDriver() throws Exception {
        try {
            Class.forName(ORACLE_DRIVER_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            throw new Exception("Unable to register driver class", e);
        }
    }

}

package util.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class H2DBImpl extends DBUtil {

    public abstract <T> PreparedStatement insert(T t) throws SQLException;

    public abstract PreparedStatement findById(String id) throws SQLException;

    public abstract PreparedStatement selectAll() throws SQLException;
}

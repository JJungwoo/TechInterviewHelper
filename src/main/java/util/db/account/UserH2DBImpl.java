package util.db.account;

import util.db.H2DBImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserH2DBImpl extends H2DBImpl {

    @Override
    public <T> PreparedStatement insert(T t) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement findById(String id) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement selectAll() throws SQLException {
        return null;
    }
}

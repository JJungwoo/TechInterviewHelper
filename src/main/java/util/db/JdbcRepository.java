package util.db;

public class JdbcRepository<C, T> {
    C Entity;
    T entitiyPrimaryKey;

    public JdbcRepository(C entity, T entitiyPrimaryKey) {
        this.Entity = entity;
        this.entitiyPrimaryKey = entitiyPrimaryKey;
    }
}

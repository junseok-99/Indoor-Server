package Server.indoor.repository;

import Server.indoor.dto.ARObjectInfo;
import Server.indoor.dto.SpaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Repository
public class IndoorRepository implements MyRepository{

    private final DataSource dataSource;

    public IndoorRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        DataSourceUtils.releaseConnection(con, dataSource);
    }
}

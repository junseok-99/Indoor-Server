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

    @Override
    public List<SpaceInfo> findSpace(String spaceName) {
        String sql = "select * from SPACE where space_name = ?";

        List<SpaceInfo> list = new LinkedList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, spaceName);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new SpaceInfo(rs.getString("pos_name"),rs.getFloat("x1"),
                        rs.getFloat("x2"), rs.getFloat("z1"), rs.getFloat("z2")));
            }
            if (list.isEmpty()) {
                log.info("Space not found!!");
            } else {
                return list;
            }
        } catch (SQLException e) {
            log.info("Space Not Found!!");
        } finally {
            close(con, pstmt, rs);
        }
        return null;
    }

    public void close(Connection con, Statement stmt, ResultSet rs) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        DataSourceUtils.releaseConnection(con, dataSource);
    }
}

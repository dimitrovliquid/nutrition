package dao;

import vo.BaseVO;
import vo.ValueObject;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dimitrov on 08.06.16.
 */
public class DAO
{
    private final DBConnection conn;

    private DAO(DBConnection conn)
    {
        this.conn = conn;
    }

    public static DAO create(DBConnection conn)
    {
        return new DAO(conn);
    }

    public BaseVO getVO(BaseVO vo)
    {
        return conn.executeQuery("SELECT * FROM base WHERE base.base='" + ((BaseVO) vo).getBase() + "';");
    }



}

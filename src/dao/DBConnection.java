package dao;

import vo.BaseVO;

import java.sql.*;
/**
 * Created by dimitrov on 08.06.16.
 */
public class DBConnection
{
    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    public DBConnection(String url, String user, String pass)
    {
        this.url = url;
        this.user = user;
        this.password = pass;
    }

    public BaseVO executeQuery(String query)
    {
        try(Connection connection = DriverManager.getConnection(url,user,password))
        {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            //ps.close();
            rs.first();

            BaseVO vo = new BaseVO();
            vo.setBase(rs.getString("base"));
            vo.setDescription(rs.getString("description"));

            return vo;
        }
        catch(SQLException e)
        {
            System.out.println("Unable to connect to database: " + e.getMessage());
        }

        return null;
    }

    public static DBConnection initDefault()
    {
        return new DBConnection("jdbc:mysql://localhost:3306/nutrition","root","radiofm");
    }
}

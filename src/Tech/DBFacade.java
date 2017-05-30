package Tech;

import java.sql.*;

public class DBFacade {
    private String userName, password, port, databaseName;
    private Connection connection;
    private PreparedStatement ps;
    private CallableStatement cl;

    public DBFacade() {
        userName = "sa";
        password = "";
        port = "1433";
        databaseName = "DB_FlytteBoxen";

        openConnection();
    }

    /**
     * Open the connection for the database
     */
    private void openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:"+port+";databaseName="+databaseName,userName,password);
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Makes a prepared Statement
     * @param sql the sql code
     * @return the prepared statement
     * @throws SQLException
     */
    public PreparedStatement preparedStatement(String sql) throws SQLException {
        ps = connection.prepareStatement(sql);

        return ps;
    }

    /**
     * Makes a callable statement
     * @param sql the sql code
     * @return the callable statement
     * @throws SQLException
     */
    public CallableStatement callableStatement(String sql) throws SQLException {
        cl = connection.prepareCall(sql);

        return cl;
    }

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/skillbox?serverTimezone=Europe/Moscow";
    private static final String USER = "root";
    private static final String PASS = "148022";
    private Statement statement;
    private Connection connection;


    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASS);
        statement = connection.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
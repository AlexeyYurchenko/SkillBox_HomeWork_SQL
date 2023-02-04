import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        averageSalesValue();
    }

    private static void averageSalesValue() {
        SQLConnect connect = new SQLConnect();
        try {
            connect.connect();
            ResultSet resultSet = connect.getStatement().executeQuery(
                    "SELECT p.course_name," +
                            "COUNT(course_name)/(MAX(MONTH(subscription_date))-MIN(MONTH(subscription_date))+1) AS average_sales_value " +
                            "FROM PurchaseList p " +
                            "WHERE subscription_date BETWEEN '2018-01-01 00:00:00' AND '2018-12-31 23:59:59' " +
                            "GROUP BY p.course_name");
            while (resultSet.next()) {
                System.out.printf(
                        "%-40s%.2f%n",
                        resultSet.getString("course_name"),
                        resultSet.getDouble("average_sales_value")
                );
            }
            connect.getConnection().close();
            connect.getStatement().close();
            resultSet.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
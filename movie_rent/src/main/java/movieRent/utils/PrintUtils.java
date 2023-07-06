package movieRent.utils;

import java.sql.*;

import javax.sql.DataSource;

public class PrintUtils {
    private DataSource dataSource;

    public PrintUtils(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public void PrintResult(ResultSet resultSet) {
        try{
            // Menampilkan header
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-15s", metaData.getColumnName(i));
            }
            System.out.println();

            // Menampilkan pemisah kolom
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("-".repeat(15));
            }
            System.out.println();

            // Menampilkan isi tabel
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }

            // statement.close();
            // connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
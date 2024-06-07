package service;

import factory.ConnectionFactory;

import java.sql.*;

public class DataBaseService {
    private final StringBuilder dataSchemas;

    public DataBaseService() {
        this.dataSchemas = new StringBuilder();
    }

    public void dataSchema(ConnectionFactory connectionFactory) {
        ClearSchemas();
        try (Connection conn = DriverManager.getConnection(connectionFactory.getURL(), connectionFactory.getUSER(), connectionFactory.getPASSWORD())) {
            String query = "SELECT * FROM information_schema.tables WHERE table_schema = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, "cinema");
                ResultSet tables = preparedStatement.executeQuery();

                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    dataSchemas.append("CREATE TABLE ").append(tableName).append(" (\n");

                    ResultSet columns = conn.getMetaData().getColumns(null, "cinema", tableName, null);
                    while (columns.next()) {
                        String columnName = columns.getString("COLUMN_NAME");
                        String dataType = columns.getString("TYPE_NAME");
                        dataSchemas.append("    ").append(columnName).append(" ").append(dataType).append(",\n");
                    }
                    columns.close();
                    dataSchemas.append(");\n\n");
                }
                tables.close();
            }
        } catch (SQLException e) {
            System.out.println("Error generating DDL: " + e.getMessage());
        }
    }

    public void ClearSchemas() {
        this.dataSchemas.delete(0, this.dataSchemas.length());
    }

    public StringBuilder getDataSchemas() {
        return this.dataSchemas;
    }
}

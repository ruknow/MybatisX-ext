package com.baomidou.plugin.idea.mybatisx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcTypeTest {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/da_teach?useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true";
        try (Connection connection = DriverManager.getConnection(url, "da", "da@123");
            ResultSet columnsRs = connection.getMetaData().getColumns("da_teach", "", "da", "%")) {
            while (columnsRs.next()) {
                String columnName = columnsRs.getString("COLUMN_NAME");
                int dataType = columnsRs.getInt("DATA_TYPE");
                String typeName = columnsRs.getString("TYPE_NAME");
                int columnSize = columnsRs.getInt("COLUMN_SIZE");
                int decimalDigits = columnsRs.getInt("DECIMAL_DIGITS");
                String isNullable = columnsRs.getString("IS_NULLABLE"); // 可能是"YES"或"NO"
                String REMARKS = columnsRs.getString("REMARKS");

                System.out.println("Column Name: " + columnName);
                System.out.println("Data Type: " + dataType);
                System.out.println("Type Name: " + typeName);
                System.out.println("Column Size: " + columnSize);
                System.out.println("Decimal Digits: " + decimalDigits);
                System.out.println("Is Nullable: " + isNullable);
                System.out.println("REMARKS: " + REMARKS);
                System.out.println("===================");
            }
        }
    }

}

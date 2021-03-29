package gbjc3.les02;

import java.sql.*;

public class ExpSQLMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = DriverManager.getConnection("jdbc:sqlite:firstDB.db");
        /*
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:firstDB.db")) {
            connection.close();
        }
        */
/*
        Statement statement = connection.createStatement();
        long startTime = System.currentTimeMillis();
        String queryIns = "INSERT INTO student (name, score) VALUES (\"%s\", %d)";
        for (int i = 0; i < 10000; i++) {
            String format = String.format(queryIns, "Oleg" + i, i*2);
            statement.executeUpdate(format);
        }
        System.out.println(System.currentTimeMillis() - startTime);
*/

        String queryIns = "INSERT INTO student (name, score) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(queryIns);

        long startTime = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            Savepoint sp1 = null;
            if (i % 2 ==0) {  // будем делать точки сохранения, чтобы не потерять данные
                 sp1 = connection.setSavepoint();
            }

            preparedStatement.setString(1, "Egor_" + i);
            preparedStatement.setInt(2, i*2);

            if (i==10) {
                connection.rollback(sp1);
                throw new RuntimeException();
            }

//            preparedStatement.executeUpdate();    // данные передаются 1000 раз маленькими пакетиками
            preparedStatement.addBatch();  // передаем целым пакетом
        }
        preparedStatement.executeBatch();
        connection.commit();    // для загрузки одним пакетом
        System.out.println(System.currentTimeMillis() - startTime);

        /*
        String querySelect = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(querySelect);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int score = resultSet.getInt("score");

            System.out.println("Name: " + name + "; score: " + score);
        }
         */
//        statement.executeQuery();
//        statement.execute();
    }
}

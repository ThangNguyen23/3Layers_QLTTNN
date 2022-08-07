package DAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Connect {
    String url = "";
    String userName = "root";
    String passWord = "";
    String nameOfDB = "qlttnn";

    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;

    public Connect() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                url = "jdbc:mysql://localhost:3306/" + nameOfDB + "?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
                connection = DriverManager.getConnection(url, userName, passWord);
            }
            catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public ArrayList loadData(String table) {
        ArrayList arrayList = new ArrayList();
        try {
            String query = "select * from `" + table + "`";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int column = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                ArrayList object = new ArrayList();
                for(int i = 0; i < column; i++) {
                    object.add(resultSet.getString(i + 1));
                }
                arrayList.add(object);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return arrayList;
    }

    public boolean insert(String table, String value) {
        try {
            String query = "INSERT INTO `" + table + "` Values (" + value + ");";
            System.out.println("Insert : " + query);
            statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return true;
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(String table, String condition) {
        String query = "DELETE FROM `" + table + "` where " + condition + ";";
        try {
            statement = connection.createStatement();
            int result = statement.executeUpdate(query);
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public int countWithCondition(String table, String condition) {
        int temp = 0;
        try {
            String query = "Select * from `" + table + "` where " + condition;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.last();
            temp = resultSet.getRow();

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return temp;
    }

    public ArrayList selectStatement(String query) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            ArrayList<String> result = new ArrayList<String>();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int column = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for(int i = 0; i < column; i++) {
                    result.add(resultSet.getString(i + 1));
                }
            }
            resultSet.close();
            statement.close();
            connection.close();

            return result;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}

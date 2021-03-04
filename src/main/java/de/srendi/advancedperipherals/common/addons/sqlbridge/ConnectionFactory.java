package de.srendi.advancedperipherals.common.addons.sqlbridge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private  String username;
    private  String password;
    private  String database_url;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase_url() {
        return database_url;
    }

    public void setDatabase_url(String database_url) {
        this.database_url = database_url;
    }

public Connection createConnectionToMySql() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

Connection connection = DriverManager.getConnection(this.database_url,this.username,this.password);
return connection;
}


}



/*
 * Copyright (C) 2020 Jared
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.jmb19905.bibel.bot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Jared
 */
public class SQLiteManager {
    
    public static Connection connect(String fileName) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:"+fileName);
            try(Statement stmt = conn.createStatement()){
                System.out.println("Opened database successfully");
                String sql =  "CREATE TABLE IF NOT EXISTS guild_settings("
                            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                            + "guild_id VARCHAR(20) NOT NULL, "
                            + "prefix VARCHAR(255) NOT NULL DEFAULT '!', "
                            + "losungen_channel_name VARCHAR(255) NOT NULL DEFAULT 'losungenz', "
                            + "showLosung INTEGER(1) DEFAULT 1,"
                            + "time VARCHAR(8) DEFAULT '08:00:00'"
                            + ");";
                stmt.executeUpdate(sql);
                return conn;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQLiteManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
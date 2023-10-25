package db;

import javax.imageio.IIOException;
import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn= null;
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.proprietes")) {
            Properties props= new Properties();
            props.load(fs);// ler e guarda dentro do objeto
            return  props;
        }
        catch (IOException ex){
            throw new DbException(ex.getMessage());
        }
    }

    public static Connection getConn() {
        if(conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn= DriverManager.getConnection(url,props);//conectar um banco é instancia um objeto do tipo conection
            }
            catch (SQLException sql){
                throw  new DbException(sql.getMessage());
            }

        }
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }
            catch (SQLException sql){
                throw new DbException(sql.getMessage());
            }
        }
    }

    public static void closeStament(Statement st){
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {//ta pegando a exeção do tipo SqlException
                throw new DbException(e.getMessage());// to pegando a exeção sql execption e enviando uma nov exeção do tipo db porque ela é do tipo runtime e não é obrigada a ser tratada
            }
        }
    }
}

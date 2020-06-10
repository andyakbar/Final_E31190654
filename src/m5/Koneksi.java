package m5;

/**
 *
 * @author Andy
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class Koneksi {
    private static Connection con;
    
    public static Connection getkoneksi(){
        if (con==null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection("jdbc:mysql://localhost/barbershop", "root", "");
                System.out.println("Berhasil");
            } catch (Exception e){
                e.getStackTrace();
            }
        }
        return con;
    }

    public static class con {

        public con() {
        }
    }
}

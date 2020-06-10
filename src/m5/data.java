package m5;
/**
 *
 * @author Andy
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class data {
Connection con = null;
ResultSet rs = null;
PreparedStatement pst = null;

private String sql ;

public String Id;
public String Barber;
public String Nama;
public String Paket;
public String Harga;

public void simpan ()throws SQLException{
    con = Koneksi.getkoneksi();
    String sql = "INSERT INTO `data`(`Id`, `Barber`, `Nama`, `Paket`, `Harga`) VALUES";
    pst = con.prepareCall(sql);
    pst.setString(1, Id);
    pst.setString(2, Barber);
    pst.setString(3, Nama);
    pst.setString(4, Paket);
    pst.setString(5, Harga);
    pst.execute();
    pst.close();
}
public ResultSet UpdateJTable ()throws SQLException{
    con = Koneksi.getkoneksi();
    sql ="SELECT * FROM data";
    pst = con.prepareStatement(sql);
    rs = pst.executeQuery();
    return rs;
    
}

public void Hapus ()throws SQLException{
    con = Koneksi.getkoneksi();
    String sql ="DELETE FROM `data` WHERE 0";
    try{
        pst = con.prepareStatement(sql);
        pst.setString(1, Barber);
        pst.execute();
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
}

public void Edit ()throws SQLException{
    con = Koneksi.getkoneksi();
    String sql ="UPDATE `data` SET `Id`=[value-1],`Barber`=[value-2],`Nama`=[value-3],`Paket`=[value-4],`Harga`=[value-5] WHERE 1";
    pst = con.prepareStatement(sql);
    pst.setString(1, Id);
    pst.setString(1, Barber);
    pst.setString(2, Nama);
    pst.setString(3, Paket);
    pst.setString(4, Harga);
    pst.executeUpdate();
    pst.close();
            

}
}
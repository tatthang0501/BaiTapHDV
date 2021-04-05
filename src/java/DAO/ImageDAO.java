/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Image;
/**
 *
 * @author Thang
 */
public class ImageDAO extends DAO{

    public ImageDAO() {
        super();
    }
    
    public ArrayList<Image> getAll(){
        ArrayList<Image> listFound = new ArrayList<Image>();
        String sql = "SELECT * FROM image";
        try{
            st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                byte[] imageData = rs.getBytes("imagedata");
                String imageFileName = rs.getString("imagefilename");
                Image img = new Image(id, name, imageData, imageFileName);
                listFound.add(img);
            }
        }
        catch(SQLException e){
            System.out.println("Error when getting image data");
        }
        return listFound;
    }
}

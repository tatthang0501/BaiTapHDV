/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ImageDAO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Image;

/**
 *
 * @author Thang
 */
@WebService(serviceName = "imageView")
public class imageView {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllImage")
    public ArrayList getAllImage() {
        ImageDAO iDAO = new ImageDAO();
        ArrayList<Image> listFound = iDAO.getAll();
            return listFound;
    }

}

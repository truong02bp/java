
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.KhachHang;
import model.MatHang;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huy Trường
 */
public class Controller {
    public <T> void writeToFile(List<T> list , String path){
        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public <T> List<T> readFromFile(String path){
        List<T> result = new ArrayList<>();
        File file = new File(path);
        if (file.length() > 0){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                result = (List<T>) ois.readObject();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return result;
    }
    public MatHang getMh(List<MatHang> list , int ma){
        for (MatHang matHang : list)
            if (matHang.getMa() == ma)
                return matHang;
        return null;
    }
    public KhachHang getKh(List<KhachHang> list , int ma){
        for (KhachHang matHang : list)
            if (matHang.getMa() == ma)
                return matHang;
        return null;
    }
    public int getIndex(List<HoaDon> list, int maKh , int maMh){
        int index = -1;
        int counter=0;
        for (int i=0;i<list.size();i++)
        {
            HoaDon item = list.get(i);
            if (item.getKhachHang().getMa() == maKh)
                counter++;
            if (item.getKhachHang().getMa() == maKh && item.getMatHang().getMa() == maMh)
                index = i;
        }
        return index;
    }
}

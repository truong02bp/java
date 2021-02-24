
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public <T> void  writeToFile(List<T> list , String path){
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
    public KhachHang getKh(List<KhachHang> list , int ma){
        for (KhachHang item : list)
            if (item.getMa() == ma)
                return item;
        return null;
    }
    public DichVu getDv(List<DichVu> list , int ma){
        for (DichVu item : list)
            if (item.getMa() == ma)
                return item;
        return null;
    }
    
    public int getIndex(List<HoaDon> list , int maKh , int maDv){
        int counter=0;
        for (int i=0;i<list.size();i++)
        {
            HoaDon item = list.get(i);
            if (item.getKhachHang().getMa() == maKh)
                counter++;
            if (counter >= 5)
                return -2;
            if (item.getKhachHang().getMa() == maKh && item.getDichVu().getMa() == maDv)
                return i;
        }
        return -1;
    }
    
}

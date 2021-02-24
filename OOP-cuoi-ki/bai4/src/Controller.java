
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Bang;
import model.CongNhan;
import model.SanPham;

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
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public <T> List<T> readFromFile(String path) {
        List<T> result = new ArrayList<>();
        File file = new File(path);
        if (file.length()>0){
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (List<T>) ois.readObject();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
           
        } catch (ClassNotFoundException ex) {
            
        }
        }
        return result;
    }
    public CongNhan getCn(List<CongNhan> list , int ma){
        for (CongNhan item : list ){
            if (item.getMa()  == ma)
                return item;
        }
        return null;
    }
     public int getBang(List<Bang> list , int maCn , int maSp){
        int index = -2;
        int counter=0;
        for (int i=0;i<list.size();i++){
            Bang item = list.get(i);
            if (item.getCongNhan().getMa()  == maCn)
                counter++;
            if (item.getCongNhan().getMa() == maCn && item.getSanPham().getMa() == maSp)
                index = i;
        }
        if (counter > 5)
            return -1;
        return index;
    }
    public SanPham getSp(List<SanPham> list , int ma){
        for (SanPham item : list ){
            if (item.getMa()  == ma)
                return item;
        }
        return null;
    }
}

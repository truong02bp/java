
import java.io.*;
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
        for (MatHang item : list){
            if (ma == item.getMa())
                return item;
        }
        return null;
    }
    public NhanVienBanHang getNv(List<NhanVienBanHang> list , int ma){
        for (NhanVienBanHang item : list){
            if (ma == item.getMa())
                return item;
        }
        return null;
    }
    public int getIndex(List<DanhSach> list , int maMh , int maNv){
        for (int i=0;i<list.size();i++)
            if (list.get(i).getMatHang().getMa() == maMh && list.get(i).getNhanVienBanHang().getMa() == maNv)
                return i;
        return -1;
    }
}

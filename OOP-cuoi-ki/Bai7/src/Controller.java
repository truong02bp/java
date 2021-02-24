
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BangDiem;
import model.MonHoc;
import model.SinhVien;

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
        File file = new File(path);
        List<T> result = new ArrayList<>();
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
    public SinhVien getSv(List<SinhVien> list , int ma){
        for (SinhVien item : list)
            if (item.getMa() == ma)
                return item;
        return null;
    }
    public MonHoc getMh(List<MonHoc> list , int ma){
        for (MonHoc item : list)
            if (item.getMa() == ma)
                return item;
        return null;
    }
    public int getIndex(List<BangDiem> list , int maSv , int maMh){
        for (int i=0;i<list.size();i++)
            if (list.get(i).getSinhVien().getMa() == maSv && list.get(i).getMonHoc().getMa() == maMh)
                return i;
        return -1;
    }
}

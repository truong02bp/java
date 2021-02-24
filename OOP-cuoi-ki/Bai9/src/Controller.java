
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
    public <T> void writeToFile(List<T> list, String path){
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
                result = (List<T> )ois.readObject();
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
    public CongNhan getCn(List<CongNhan> list , int ma){
        for (CongNhan item : list)
            if (item.getMa() == ma)
                return item;
        return null;
    }
    public Xuong getXuong(List<Xuong> list , int ma){
        for (Xuong item : list)
            if (item.getMa() == ma)
                return item;
        return null;
    }
    public int getIndex(List<DanhSach> list, int maCn , int maXuong , int soNgay){
        int counter=0;
        int index = -1;
        for (int i=0;i<list.size();i++)
        {
            DanhSach item = list.get(i);
            if (item.getCongNhan().getMa() == maCn)
                counter+=item.getSoNgay();
            if (counter + soNgay > 30)
                return -2;
            if (item.getCongNhan().getMa() == maCn && item.getXuong().getMa() == maXuong)
                index = i;
        }
        return index;
    }
}

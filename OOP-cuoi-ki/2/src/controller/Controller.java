/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Detail;
import model.NhanVien;
import model.PhongBan;

/**
 *
 * @author Huy Trường
 */
public class Controller {
    public <T> List<T> getFromFile(String path){
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
    public <T> void writeToFile(List<T> list, String path){
        File file = new File(path);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos  = new ObjectOutputStream(fos);
                oos.writeObject(list);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public NhanVien getNv(List<NhanVien> list , int ma){
        for (int i=0;i<list.size();i++)
            if (list.get(i).getMa() == ma)
                return list.get(i);
        return null;
    }
    public PhongBan getPb(List<PhongBan> list , int ma){
        for (int i=0;i<list.size();i++)
            if (list.get(i).getMa() == ma)
                return list.get(i);
        return null;
    }
    public int getIndex(List<Detail> list, int codeNv , int codePb){
        for (int i=0;i<list.size();i++)
        {
            Detail detail = list.get(i);
            if (detail.getNhanVien().getMa() == codeNv && detail.getPhongBan().getMa() == codePb)
                return -2;
            if (detail.getNhanVien().getMa() == codeNv)
                return i;
        }
        return -1;
    }
}

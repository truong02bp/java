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
import model.DuAn;
import model.NhanVien;
import model.PhanCong;

/**
 *
 * @author Huy Trường
 */
public class Controller {
    public <T> List<T> readFromFile(String path){
        List<T> result = new ArrayList<>();
        File file = new File(path);
        if (file.length()>0){
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
    public <T> void writeToFile(List<T> list , String path) throws IOException{
        File file = new File(path);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public NhanVien getNv(List<NhanVien> list , int code){
        for (NhanVien item : list)
            if (item.getMa() == code)
                return item;
        return null;
    }
    public DuAn getDa(List<DuAn> list , int code){
        for (DuAn item : list)
            if (item.getMa() == code)
                return item;
        return null;
    }
    public boolean check(List<PhanCong> list , int codeDa , int codeNv , String viTri){
        for (PhanCong item : list)
            if (item.getNhanVien().getMa() == codeNv && item.getDuAn().getMa() == codeDa && item.getViTri().equals(viTri) )
                return true;
        return false;
    }
}

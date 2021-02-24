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
import model.DonHang;
import model.KhachHang;
import model.MatHang;

/**
 *
 * @author Huy Trường
 */
public class Controller {
    public <T> List<T> readFormFile(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        List<T> result = new ArrayList<>();
        File file = new File(path);
        if (file.length() > 0){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (List<T>) ois.readObject();
            ois.close();
            fis.close();
        }
        return result;
    }
    public <T> void writeToFile(List<T> list , String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
    }
    public MatHang getMatHangFromList(List<MatHang> list , int code){
        for (MatHang matHang : list){
            if (matHang.getMaMh() == code)
                return matHang;
        }
        return null;
    }
    public KhachHang getKhachHangFromList(List<KhachHang> list , int code){
        for (KhachHang khachHang : list){
            if (khachHang.getMaKh() == code)
                return khachHang;
        }
        return null;
    }
    public int getIndexOfDonHang(List<DonHang> list , DonHang donHang){
        int counter=0;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getKhachHang().getMaKh() == donHang.getKhachHang().getMaKh())
                counter++;
            if (counter == 10)
                return -1;
            if (list.get(i).getKhachHang().getMaKh() == donHang.getKhachHang().getMaKh() && list.get(i).getMatHang().getMaMh()== donHang.getMatHang().getMaMh())
                return i;
        }
        return -1;
    }
}

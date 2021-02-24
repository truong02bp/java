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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import model.DanhSach;
import model.Detail;
import model.KhachHang;
import model.MatHang;

/**
 *
 * @author Huy Trường
 */
public class ControllerImpl implements Controller, Serializable {

    @Override
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
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return result;
    }

    @Override
    public <T> void writeToFile(List<T> list, String path) {
        File file = new File(path);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public MatHang getMHByCode(List<MatHang> list , int code){
        for (MatHang m : list){
            if (m.getCode() == code)
                return m;
        }
        return null;
    }
    @Override
    public KhachHang getKHByCode(List<KhachHang> list , int code){
        for (KhachHang m : list){
            if (m.getCode() == code)
                return m;
        }
        return null;
    }

    @Override
    public int getIndexOfKh(List<DanhSach> list, KhachHang khachHang) {
        for (int i=0;i<list.size();i++)
            if (list.get(i).getKh().getCode() == khachHang.getCode())
                return i;
        return -1;
    }

    @Override
    public List<Detail> insert(List<Detail> list, Detail detail) {
        List<Detail> result = new ArrayList<>();
        result.addAll(list);
        boolean check = false;
        for (Detail d : result){
            if (d.getMatHang().getCode() == detail.getMatHang().getCode())
            {
                 d.setSl(d.getSl() + detail.getSl());
                 check = true;
            }
        }
        if (!check)
            result.add(detail);
        System.out.println(result.size());
        return result;
    }

    @Override
    public DanhSach getDanhSachByCode(List<DanhSach> list, int code) {
        for (int i=0;i<list.size();i++)
            if (list.get(i).getKh().getCode() == code)
                return list.get(i);
        return null;
    }

    

    
}

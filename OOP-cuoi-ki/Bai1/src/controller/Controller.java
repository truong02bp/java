/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javafx.util.Pair;
import model.DanhSach;
import model.Detail;
import model.KhachHang;
import model.MatHang;

/**
 *
 * @author Huy Trường
 */
public interface Controller extends Serializable {
    <T> List<T> readFromFile(String path);
    <T> void writeToFile(List<T> list , String path);
    MatHang getMHByCode(List<MatHang> list , int code);
    KhachHang getKHByCode(List<KhachHang> list , int code);
    int getIndexOfKh(List<DanhSach> list , KhachHang khachHang);
    List<Detail> insert(List<Detail> list , Detail detail);
    DanhSach getDanhSachByCode(List<DanhSach> list , int code);
}

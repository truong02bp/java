package bai16;

import java.util.Arrays;
import java.util.List;

public class MHUtils {
    public static boolean checkMa(int ma){
        return ma >=1000 && ma <10000;
    }

    public static boolean checkTen(String ten){
        return !ten.isEmpty();
    }

    public static boolean checkNhom(String nhom){
        List<String> template = Arrays.asList("hàng tiêu dùng","hàng thời trang","điện tử - điện lạnh");
        return template.contains(nhom);
    }

    public static boolean checkGia(double gia){
        return gia>0;
    }
}

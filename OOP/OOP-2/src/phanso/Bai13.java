package phanso;

public class Bai13 {
    public static void main(String[] args) {
        System.out.println("Nhập phân số a:");
        PhanSo a = new PhanSo();
        a.nhap();
        System.out.println("Nhập phân số b:");
        PhanSo b = new PhanSo();
        b.nhap();
        System.out.println("Tổng :");
        a.cong(b).hien();
        System.out.println("Hiệu :");
        a.tru(b).hien();
        System.out.println("Tích :");
        a.nhan(b).hien();
        System.out.println("Thương :");
        a.chia(b).hien();
        System.out.println("a tối giản :");
        a.toiGian().hien();
        System.out.println("b tối giản :");
        b.toiGian().hien();
        if (a.bangNhau(b))
            System.out.println("2 phân số bằng nhau");
        else
            if (a.lonHon(b))
                System.out.println("a lớn hơn b");
            else
                System.out.println("a nhỏ hơn b");
    }
}

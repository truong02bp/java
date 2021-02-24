package sophuc;

public class Bai14 {
    public static void main(String[] args) {
        System.out.println("Nhập số phức a :");
        SoPhuc a = new SoPhuc();
        a.nhap();
        System.out.println("Nhập số phức b :");
        SoPhuc b = new SoPhuc();
        b.nhap();
        System.out.println("Tổng :");
        a.cong(b).hien();
        System.out.println("Hiệu :");
        a.tru(b).hien();
        System.out.println("Tích :");
        a.nhan(b).hien();
        System.out.println("Thương :");
        a.chia(b).hien();
        if (a.bangNhau(b))
            System.out.println("2 số phức bằng nhau");
        else if (a.lonHon(b))
            System.out.println("a lớn hơn b");
        else
            System.out.println("a nhỏ hơn b");
    }
}

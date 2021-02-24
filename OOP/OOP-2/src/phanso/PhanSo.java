package phanso;

import java.util.Scanner;

public class PhanSo {
    private int ts;
    private int ms;

    public PhanSo() {
        this.ts = 0;
        this.ms = 1;
    }

    public PhanSo(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }

    public PhanSo cong(PhanSo ps2){
        PhanSo sum = new PhanSo();
        sum.ts = this.ts*ps2.ms +  ps2.ts*this.ms;
        sum.ms = this.ms* ps2.ms;
        return sum.toiGian();
    }

    public PhanSo tru(PhanSo ps2){
        PhanSo difference = new PhanSo();
        difference.ts = this.ts*ps2.ms -  ps2.ts*this.ms;
        difference.ms = this.ms* ps2.ms;
        return difference.toiGian();
    }

    public PhanSo nhan(PhanSo ps2){
        PhanSo mul = new PhanSo();
        mul.ts = this.ts*ps2.ts;
        mul.ms = this.ms*ps2.ms;
        return mul.toiGian();
    }

    public PhanSo chia(PhanSo ps2){
        PhanSo div = new PhanSo();
        div.ts = this.ts*ps2.ms;
        div.ms = this.ms*ps2.ts;
        return div.toiGian();
    }

    public PhanSo toiGian(){
        int gcd = Utils.GCD(this.ts,this.ms);
        if (gcd < 0)
            gcd = -gcd;
        this.ts/=gcd;
        this.ms/=gcd;
        return this;
    }

    public PhanSo nghichDao(){
        int temp = this.ts;
        this.ts = this.ms;
        this.ms = temp;
        return this;
    }

    public PhanSo doiDau(){
        this.ts = - this.ts;
        return this;
    }

    public boolean bangNhau(PhanSo ps2) {
        if (this.tru(ps2).ts == 0)
            return true;
        return false;
    }

    public boolean nhoHon(PhanSo ps2) {
        if (this.tru(ps2).ts < 0)
            return true;
        return false;
    }

    public boolean lonHon(PhanSo ps2) {
        if (this.tru(ps2).ts > 0)
            return true;
        return false;
    }

    public void hien(){
        System.out.println(this.ts+"/"+this.ms);
    }

    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] list = str.split("/");
        this.ts = Integer.parseInt(list[0]);
        this.ms = Integer.parseInt(list[1]);
    }
}

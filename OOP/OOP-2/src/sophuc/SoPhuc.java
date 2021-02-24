package sophuc;

import java.util.Scanner;

public class SoPhuc {
    private float a;
    private float b;

    public SoPhuc() {
        this.a = 0;
        this.b = 0;
    }

    public SoPhuc(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public SoPhuc cong(SoPhuc sp2){
        SoPhuc sum = new SoPhuc();
        sum.a = this.a + sp2.a;
        sum.b = this.b + sp2.b;
        return sum;
    }

    public SoPhuc tru(SoPhuc sp2){
        SoPhuc difference = new SoPhuc();
        difference.a = this.a - sp2.a;
        difference.b = this.b - sp2.b;
        return difference;
    }

    public SoPhuc nhan(SoPhuc sp2){
        SoPhuc mul = new SoPhuc();
        mul.a = this.a*sp2.a - this.b*sp2.b;
        mul.b = this.a*sp2.b + this.b*sp2.a;
        return mul;
    }

    public SoPhuc chia(SoPhuc sp2){
        SoPhuc div = new SoPhuc();
        float temp = sp2.a*sp2.a + sp2.b*sp2.b;
        div.a = (this.a*sp2.a + this.b*sp2.b)/temp;
        div.b = (sp2.a*this.b-this.a*sp2.b)/temp;
        return div;
    }

    public SoPhuc nghichDao(){
        float temp = this.a*this.a + this.b*this.b;
        this.a = this.a/temp;
        this.b = - this.b/temp;
        return this;
    }

    public boolean bangNhau(SoPhuc sp2){
        float modul1 = (float) Math.sqrt(this.a*this.a + this.b*this.b);
        float modul2 = (float) Math.sqrt(sp2.a*sp2.a + sp2.b*sp2.b);
        if (modul1 == modul2)
            return true;
        return  false;
    }

    public boolean nhoHon(SoPhuc sp2){
        float modul1 = (float) Math.sqrt(this.a*this.a + this.b*this.b);
        float modul2 = (float) Math.sqrt(sp2.a*sp2.a + sp2.b*sp2.b);
        if (modul1 < modul2)
            return true;
        return  false;
    }

    public boolean lonHon(SoPhuc sp2){
        float modul1 = (float) Math.sqrt(this.a*this.a + this.b*this.b);
        float modul2 = (float) Math.sqrt(sp2.a*sp2.a + sp2.b*sp2.b);
        if (modul1 > modul2)
            return true;
        return  false;
    }

    public void hien(){
        System.out.println(this.a +"+ j"+this.b);
    }

    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] list = str.split(" ");
        this.a = Float.parseFloat(list[0]);
        this.b = Float.parseFloat(list[list.length-1].substring(1));
    }
}

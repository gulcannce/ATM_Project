import java.util.Scanner;

public class Hesap {

    private String hesapNumarası ;
    private String şifre;
    private double bakiye;
    private String islemGecmisi = "";

    public Hesap(String hesapNumarası, String şifre, double bakiye){


        this.hesapNumarası = hesapNumarası;
        this.şifre = şifre;
        this.bakiye= bakiye;

    }

    public boolean sifreDogrulama(String şifre){
        return this.şifre.equals(şifre);

    }
    public double getBakiye(){
        return this.bakiye;

    }
    public  void paraYatırma(double para){

        if (para>0) {
            this.bakiye += para;
            islemGecmisi += "islemgecmisi: "  + para + "tl";
        }else {
            System.out.println("yetersiz bakiye");

        }
    }
    public void paracekme (double para){
        if (para>0&&para<=this.bakiye) {
            this.bakiye -= para;
            islemGecmisi += "islemgecmisi: "+ para + "tl";

            System.out.println("istedilen miktar cekildi: " + para);
        }else {

            System.out.println("yetersiz bakiye: ");


        }

    }
    public void setIslemGecmisi(){
        if (islemGecmisi.isEmpty()) {
            System.out.println("gecersiz işlem: ");

        }else {
            System.out.println("işlem basarılı: " + islemGecmisi);


        }
    }







}

import java.util.HashMap;
import java.util.Scanner;

public class ATM {

    public static HashMap<String, Hesap> Hesaplar = new HashMap<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ATM.Hesaplar.put("2345678102", new Hesap("2345678102", "7221", 1000.00));
        System.out.println("bankamıza hoşgeldiniz");

        Hesap hesap = giriş(scanner);
        if (hesap == null) {
            System.out.println("3 kez hayatalı giriş yaptınız ATM'den çıkılıyor");
            return;

        }
        boolean seçim = true;
        while (seçim) {
            System.out.println("\nbir işlem seçin");
            System.out.println("1: Bakiye görüntüme: ");
            System.out.println("2: Para yatarma: ");
            System.out.println("3: Para çekme: ");
            System.out.println("4: İşlem geçmişi: ");
            System.out.println("5: Çıkış");
            int giriş = scanner.nextInt();
            switch (giriş) {
                case 1:
                    System.out.println("kalan bakiye: " + hesap.getBakiye());
                    break;
                case 2:
                    double parayatırın = scanner.nextDouble();
                    hesap.paraYatırma(parayatırın);
                    System.out.println("para yatırın:");
                    break;
                case 3:
                    double paraçekin = scanner.nextDouble();
                    hesap.paracekme(paraçekin);
                    System.out.println("para çekin");
                    break;
                case 4:
                    hesap.setIslemGecmisi();

                case 5:
                    seçim = false;
                    System.out.println("Başarılı çıkış: ");
                    break;
            }
        }
    }

    public static Hesap giriş(Scanner scanner) {
        System.out.print("hesap numaranızı girin: ");
        String hesapNumarası = scanner.next();
        Hesap hesap = Hesaplar.get(hesapNumarası);

        if (Hesaplar.containsKey(hesapNumarası)){
            int deneme = 0;
            while (deneme < 3) {
                System.out.print("şifrenizi giriniz");
                String şifre = scanner.next();
                if (hesap.sifreDogrulama(şifre)) {

                    System.out.println("başarı giriş");
                    return hesap;

                } else {
                    deneme++;
                    System.out.println("hatalı şifre.kalan deneme hakkınız " + (3 - deneme));
                }
            }
            System.out.println("3 kez hayatalı giriş yaptınız ATM'den çıkılıyor");

        } else {
            System.out.println("hesap bulunamadı:");
        }
        return null;

    }
}


































import java.util.Scanner;
class Sarjor{
    private final int mermiKapasitesi;
    private int mevcutMermiSayisi;

    public Sarjor(int mermiKapasitesi,int mevcutMermiSayisi){
        this.mermiKapasitesi=mermiKapasitesi;
        this.mevcutMermiSayisi = mevcutMermiSayisi;
    }

    public int getMermiKapasitesi() {
        return mermiKapasitesi;
    }

    public int getMevcutMermiSayisi() {
        return mevcutMermiSayisi;
    }

    public void setMevcutMermiSayisi(int mevcutMermiSayisi) {
        this.mevcutMermiSayisi = mevcutMermiSayisi;
    }
    public void mermiAtesle() {
        if (getMevcutMermiSayisi() > 0) {
            setMevcutMermiSayisi(getMevcutMermiSayisi() - 1);
        }
    }
    public void mermiDoldur(){
        setMevcutMermiSayisi(getMermiKapasitesi());
        System.out.println("Şarjör Dolduruldu. Mermi Sayısı : "+ getMevcutMermiSayisi());
    }
}
class Silah{
    private Sarjor sarjor;
    private final int etkinMenzil;

    public int getEtkinMenzil() {
        return etkinMenzil;
    }

    public Sarjor getSarjor() {
        return sarjor;
    }

    public Silah(int etkinMenzil){
        this.etkinMenzil = etkinMenzil;
    }
    public void sarjorNesnesiAta(int mermiKapasitesi,int mevcutMermiSayisi){
        sarjor = new Sarjor(mermiKapasitesi,mevcutMermiSayisi);
    }
    public void atesEt(int menzil){
        getSarjor().mermiAtesle();

    }
    public void silahDoldur(){
        getSarjor().mermiDoldur();
    }
}
class OtomatikSilah extends Silah{
    public static final int tekAtisMermi = 3;

    public OtomatikSilah(int etkinMenzil){
        super(etkinMenzil);
    }

    public void atesEt(int menzil) { //mermiler 3'er 3'er azaliyor
        for (int i = 0; i < OtomatikSilah.tekAtisMermi; i++) {
            super.atesEt(menzil);
        }
        if (getSarjor().getMevcutMermiSayisi() > 0) {
            System.out.println("Ateş Edildi.");
            System.out.println("Kalan Mermi Sayısı : " + getSarjor().getMevcutMermiSayisi());
            if(getEtkinMenzil()<menzil){
                System.out.println("Hedef Vurulamadı (Menzil Dışı).");
            }
            else if(getEtkinMenzil()>=menzil){
                System.out.println("Hedef Başarıyla Vuruldu!");
            }
        }
        else{
            System.out.println("Şarjörde Mermi Kalmadı.");
        }

    }

}
public class Main {

    public static void main(String[] args) {
        int menzil, mermiKapasitesi,tercih;
        Scanner klavye = new Scanner(System.in);
        System.out.println("\nElinizdeki Silahın Etkin Menzilini Giriniz : \n");
        menzil = klavye.nextInt();
        OtomatikSilah oto = new OtomatikSilah(menzil);
        System.out.println("Lütfen Şarjör Kapasitesini Giriniz : ");
        mermiKapasitesi = klavye.nextInt();
        oto.sarjorNesnesiAta(mermiKapasitesi,mermiKapasitesi);//Dolu Şarjör ile Başlattım.
        while (true) {
            System.out.println("Ateş Etmek İçin 1'e basınız. Şarjör Doldurmak İçin 2'ye Basınız. Çıkış için 3'e Basınız.");
            tercih = klavye.nextInt();
            if (tercih == 1) {
                System.out.println("Lütfen Hedef İle Aranızdaki Menzili Giriniz (metre) : ");
                menzil = klavye.nextInt();
                oto.atesEt(menzil);
            }
            else if (tercih == 2) {
                oto.silahDoldur();
            }
            else if (tercih == 3) {
                break;
            } else {
                System.out.println("Yanlış Girdi Girildi.\nTekrar Deneyiniz.");
            }
        }
        /*Eger Normal Silah Denemek Istiyorsaniz Bu Kodlari Kullanin
        Silah silah = new Silah(500);
        silah.sarjorNesnesiAta(15,2);//
        System.out.println(silah.getSarjor().getMevcutMermiSayisi());
        silah.atesEt(400);
        System.out.println("Ateş Edildi");
        System.out.println(silah.getSarjor().getMevcutMermiSayisi());
        silah.atesEt(600);
        System.out.println("Ateş Edildi");
        System.out.println(silah.getSarjor().getMevcutMermiSayisi());
        silah.atesEt(400);//Merminin Bittiği Durum
        silah.silahDoldur();*/
    }
    }

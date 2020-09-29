import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
import java.util.Scanner;

public class UI {
    
    public static void main(String[] args) {

        MainMenu();

    }

    public static void MainMenu() {
        int pilihanMenu;
        Scanner input = null; 
        
        input = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("              MENU");
        System.out.println("-----------------------------------");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Regresi Linier Berganda");
        System.out.println("6. Keluar");
        System.out.println("-----------------------------------");
        System.out.print("Masukkan pilihan Menu : ");
        pilihanMenu = input.nextInt();

        if (pilihanMenu==1) {
            clearScreen();
            MenuSPL();
        } else if (pilihanMenu==2) {
            clearScreen();
            MenuDeterminan();
        } else if (pilihanMenu==3) {
            clearScreen();
            MenuInvers();
        } else if (pilihanMenu==4) {
            clearScreen();
            MenuInterpolasi();
        } else if (pilihanMenu==5) {
            clearScreen();
            MenuRegresi();
        } else if (pilihanMenu==6) {
            System.out.println("-----------------------------------");
            System.out.println("Terima kasih telah mencoba");
            System.out.println("020-Azhar");
            System.out.println("080-Danan");
            System.out.println("200-Dehan Ganteng Sekali");
            System.out.println("-----------------------------------");
            System.exit(0);
        } else {
            clearScreen();
            System.out.println("PILIHAN MENU TIDAK VALID, COBA LAGI");
            MainMenu();
        }

        // input.close(); 
    }


    public static void MenuSPL(){

    }

    public static void MenuDeterminan(){
        
    }

    public static void MenuInvers(){
        
    }

    public static void MenuInterpolasi(){
        int pilihanMenu;
        Scanner input = null;
        Interpolasi mInterpolasi = new Interpolasi(0,2);

        input = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("           PILIH CARA BACA");
        System.out.println("-----------------------------------");
        System.out.println("1. Baca Dari Terminal");
        System.out.println("2. Baca Dari File");
        System.out.println("3. Kembali");
        System.out.println("-----------------------------------");
        System.out.print("Masukkan pilihan : ");
        pilihanMenu = input.nextInt();
        input.close();

        if (pilihanMenu==1) {
            float x,y;
            Interpolasi z;
            x = mInterpolasi.bacaInterpolasi();
            y = mInterpolasi.InterpolasiPolinom(x);
            z = mInterpolasi.ConvertToMatrixAug();
            mInterpolasi.tulisInterpolasi(x,y,z);

        } else if (pilihanMenu==2) {
            float x,y;
            Interpolasi z;
            Scanner file = new Scanner(System.in);
            String filebaca, filetulis;
            
            System.out.print("Tuliskan nama file yang akan dibaca (contoh data1.txt): ");
            filebaca = file.next();
            x = mInterpolasi.bacaFileInterpolasi(filebaca);
            
            y = mInterpolasi.InterpolasiPolinom(x);
            z = mInterpolasi.ConvertToMatrixAug();

            System.out.print("Tuliskan nama file yang akan disimpan (contoh data2.txt): ");
            filetulis = file.next();
            mInterpolasi.tulisFileInterpolasi(x,y,z, filetulis);

            file.close();
            
        } else if (pilihanMenu==3) {
            clearScreen();
            MainMenu();
            
        } else {
            clearScreen();
            System.out.println("PILIHAN MENU TIDAK VALID, COBA LAGI");
            MenuInterpolasi();
        }
    }

    public static void MenuRegresi(){
        int pilihanMenu;
        String namaFile;
        char simpan;
        Scanner input = null;
        // Scanner input2 = null;
        Regresi mRegresi = new Regresi(0,0);

        try {
            input = new Scanner(System.in);

            System.out.println("-----------------------------------");
            System.out.println("           PILIH CARA BACA");
            System.out.println("-----------------------------------");
            System.out.println("1. Baca Dari Terminal");
            System.out.println("2. Baca Dari File");
            System.out.println("3. Kembali");
            System.out.println("-----------------------------------");
            System.out.print("Masukkan pilihan : ");
            pilihanMenu = input.nextInt();
            
            if (pilihanMenu!=1 && pilihanMenu!=2 && pilihanMenu!=3) {
                System.out.println("Masukkan Tidak Valid, Coba Lagi");
                System.out.print("Masukkan pilihan : ");
                pilihanMenu = input.nextInt();
            }

            if (pilihanMenu==1) {
                System.out.println("-----------------------------------");

                mRegresi.bacaRegresi();

                System.out.println("-----------------------------------");
                System.out.println("Data Regresi Berhasil Terbaca");

            } else if (pilihanMenu==2) {
                System.out.println("-----------------------------------");
                System.out.println("List file valid :");
                getAllDataFiles();
                System.out.println("-----------------------------------");
                System.out.print("Masukkan nama file data regresi : ");

                namaFile = input.next();
                mRegresi.bacaFileRegresi(namaFile);

                System.out.println("-----------------------------------");
                System.out.println("Data Regresi Berhasil Terbaca");
                
            } else if (pilihanMenu==3) {
                clearScreen();
                MainMenu();
            }

            if (pilihanMenu==1 || pilihanMenu==2) {
                System.out.println("-----------------------------------");
                mRegresi.tulisRegresi();
                System.out.println("-----------------------------------");
                System.out.print("Simpan Hasil? (y/n) : ");

                simpan = input.next().charAt(0);
                if (simpan=='y') {
                    System.out.println("-----------------------------------");
                    System.out.print("Masukkan nama file untuk disimpan <ekstensi .txt>: ");
    
                    namaFile = input.next();
                    mRegresi.tulisFileRegresi(namaFile);
                }
            }
            tekanEnter();
            clearScreen();
            MainMenu();
            
        } catch (Exception e) {
            System.out.println("Terjadi Error");
            e.printStackTrace();
        }
        
        
    }


    /** List input file yang valid */
    public static void getAllDataFiles() {
        String curDir = "../src/data";
        File data = new File(curDir);
        File[] listFile = data.listFiles();
        for(File f : listFile){
            System.out.println(f.getName());
        }
    }

    /** Clear Screen */
    public static void clearScreen() {
        // Butuh Bantuan
        for (int i = 0; i < 50; ++i) System.out.println();   
        // System.out.flush();
    }
    
    /** Tekan Enter untuk melanjutkan */
    public static void tekanEnter(){
        System.out.println("Tekan \"ENTER\" untuk melanjutkan...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
     }
}

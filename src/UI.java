import java.io.File;
import java.util.Scanner;

public class UI {
    
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("         Tubes-1-Algeo-2020");
        System.out.println("---------------------------------------");
        System.out.println("Author :");
        System.out.println("- Muhammad Azhar Faturahman (13519020)");
        System.out.println("- Daru Bagus Dananjaya (13519080)");
        System.out.println("- Muhammad Dehan Al Kautsar (13519200)");
        System.out.println("---------------------------------------");
        
        tekanEnter();
        clearScreen();
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
        int pilihanMenu, pilihanMetode;
        String namaFile;
        char simpan;
        Scanner input = null;
        SPL mSPL = new SPL(0,0);

        try {
            input = new Scanner(System.in);

            System.out.println("-----------------------------------");
            System.out.println("               MENU SPL");
            System.out.println("-----------------------------------");
            System.out.println("           PILIH CARA BACA");
            System.out.println("-----------------------------------");
            System.out.println("1. Baca Dari Terminal");
            System.out.println("2. Baca Dari File");
            System.out.println("3. Kembali");
            System.out.println("-----------------------------------");
            System.out.print("Masukkan pilihan : ");
            pilihanMenu = input.nextInt();
            
            // VALIDASI PILIHAN MENU
            while (pilihanMenu!=1 && pilihanMenu!=2 && pilihanMenu!=3) {
                System.out.println("Masukkan Tidak Valid, Coba Lagi");
                System.out.print("Masukkan pilihan : ");
                pilihanMenu = input.nextInt();
            }

            if (pilihanMenu==1) {
                System.out.println("-----------------------------------");

                mSPL.bacaSPL();

                System.out.println("-----------------------------------");
                System.out.println("Data matriks SPL Berhasil Terbaca");

            } else if (pilihanMenu==2) {
                System.out.println("-----------------------------------");
                System.out.println("List file valid :");
                getAllDataFiles();
                System.out.println("-----------------------------------");
                System.out.print("Masukkan nama file data matriks SPL : ");

                namaFile = input.next();
                mSPL.bacaFileSPL(namaFile);

                System.out.println("-----------------------------------");
                System.out.println("Data matriks SPL Berhasil Terbaca");
                
            } else if (pilihanMenu==3) {
                clearScreen();
                MainMenu();
            }

            // PILIH METODE
            if (pilihanMenu == 1 || pilihanMenu == 2) {
                System.out.println("-----------------------------------");
                System.out.println("             MENU SPL");
                System.out.println("-----------------------------------");
                System.out.println("           PILIH METODE");
                System.out.println("-----------------------------------");
                System.out.println("1. Metode Eliminasi Gauss");
                System.out.println("2. Metode Eliminasi Gauss Jordan");
                System.out.println("3. Metode Matriks Balikan");
                System.out.println("4. Metode Kaidah Cramer");
                System.out.println("5. Kembali");
                System.out.println("-----------------------------------");
                System.out.print("Masukkan pilihan : ");
                pilihanMetode = input.nextInt();

                // VALIDASI PILIHAN SUBMENU
                while (pilihanMetode!=1 && pilihanMetode!=2 && pilihanMetode!=3 && pilihanMetode!=4 && pilihanMetode!=5) {
                    System.out.println("Masukkan Tidak Valid, Coba Lagi");
                    System.out.print("Masukkan pilihan : ");
                    pilihanMetode = input.nextInt();
                }
                
                System.out.println("-----------------------------------");
                if (pilihanMetode == 1) {
                    System.out.println("Metode Eliminasi Gauss");
                    mSPL.metodeGauss();
                }
                else if (pilihanMetode == 2) {
                    System.out.println("Metode Eliminasi Gauss Jordan");
                    mSPL.metodeGaussJordan();
                }
                else if (pilihanMetode == 3) {
                    System.out.println("Metode Matriks Balikan");
                    mSPL.metodeInvers();
                }
                else if (pilihanMetode == 4) {
                    System.out.println("Metode Kaidah Cramer");
                    mSPL.metodeCramer();
                    
                }
                else { //pilihan Metode == 5
                    pilihanMenu = 3;
                    clearScreen();
                    MainMenu();
                }
            }

            // MAU DISIMPAN?
            if (pilihanMenu==1 || pilihanMenu==2) {
                System.out.println("-----------------------------------");
                mSPL.tulisSPL();
                System.out.println("-----------------------------------");
                System.out.print("Simpan Hasil? (y/n) : ");

                simpan = input.next().charAt(0);
                if (simpan=='y') {
                    System.out.println("-----------------------------------");
                    System.out.print("Masukkan nama file untuk disimpan <ekstensi .txt>: ");
    
                    namaFile = input.next();
                    mSPL.tulisFileSPL(namaFile);
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

    public static void MenuDeterminan(){
        int pilihanMenu, pilihanMetode;
        String namaFile;
        char simpan;
        Scanner input = null;
        Matriks mMatriks = new Matriks(0,0);

        input = new Scanner(System.in);

        System.out.println("INGAT!!!! DALAM MENCARI DETERMINAN HARUS MENGGUNAKAN MATRIKS BUJURSANGKAR");
        System.out.println("-----------------------------------");
        System.out.println("           MENU DETERMINAN");
        System.out.println("-----------------------------------");
        System.out.println("           PILIH CARA BACA");
        System.out.println("-----------------------------------");
        System.out.println("1. Baca Dari Terminal");
        System.out.println("2. Baca Dari File");
        System.out.println("3. Kembali");
        System.out.println("-----------------------------------");
        System.out.print("Masukkan pilihan : ");
        pilihanMenu = input.nextInt();

        while (pilihanMenu!=1 && pilihanMenu!=2 && pilihanMenu!=3) {
            System.out.println("Masukkan Tidak Valid, Coba Lagi");
            System.out.print("Masukkan pilihan : ");
            pilihanMenu = input.nextInt();
        }

        if (pilihanMenu == 1){
            System.out.println("-----------------------------------");

            mMatriks.bacaMatriks();

            System.out.println("-----------------------------------");
            System.out.println("Data matriks Berhasil Terbaca");
        }
        else if (pilihanMenu==2){
            String namafile;
            Scanner file = new Scanner(System.in);

            System.out.println("-----------------------------------");
            System.out.println("List file valid :");
            getAllDataFiles();
            System.out.println("-----------------------------------");
            System.out.print("Masukkan nama file data matriks : ");

            namafile = input.next();
            mMatriks.bacaFileMatriks(namafile);

            System.out.println("-----------------------------------");
            System.out.println("Data matriks Berhasil Terbaca");
        } else if (pilihanMenu==3) {
            clearScreen();
            MainMenu();
        }

        if (pilihanMenu == 1 || pilihanMenu == 2) {
            System.out.println("-----------------------------------");
            System.out.println("           MENU DETERMINAN");
            System.out.println("-----------------------------------");
            System.out.println("           PILIH METODE");
            System.out.println("-----------------------------------");
            System.out.println("1. Metode Eliminasi Gauss");
            System.out.println("2. Metode Ekspansi Kofaktor");
            System.out.println("3. Kembali");
            System.out.println("-----------------------------------");
            System.out.print("Masukkan pilihan : ");
            pilihanMetode = input.nextInt();

            // VALIDASI PILIHAN SUBMENU
            while (pilihanMetode!=1 && pilihanMetode!=2 && pilihanMetode!=3) {
                System.out.println("Masukkan Tidak Valid, Coba Lagi");
                System.out.print("Masukkan pilihan : ");
                pilihanMetode = input.nextInt();
            }

            if (pilihanMetode == 1) {
                float nilai;
                nilai = mMatriks.DeterminanGauss();
                System.out.print("Nilai determinan dari matriks adalah ");
                System.out.println(nilai);
            }
            else if (pilihanMetode == 2) {
                float nilai;

                nilai = mMatriks.DeterminanGauss();
                System.out.print("Nilai determinan dari matriks adalah ");
                System.out.println(nilai);
            }
            else {
                System.out.println("PILIHAN MENU TIDAK VALID, COBA LAGI");
                MenuDeterminan();
            }
        }

        else if (pilihanMenu == 3) {
            clearScreen();
            MainMenu();
        }

        else {
            System.out.println("PILIHAN MENU TIDAK VALID, COBA LAGI");
            MenuDeterminan();
        }

        // MAU DISIMPAN?
        if (pilihanMenu==1 || pilihanMenu==2) {
            System.out.println("-----------------------------------");
            System.out.print("Simpan Hasil? (y/n) : ");

            simpan = input.next().charAt(0);
            if (simpan=='y') {
                System.out.println("-----------------------------------");
                System.out.print("Masukkan nama file untuk disimpan <ekstensi .txt>: ");

                namaFile = input.next();
                mMatriks.tulisFileMatriks(namaFile);
            }
        }
        tekanEnter();
        clearScreen();
        MainMenu();

        
    }

    public static void MenuInvers(){
        int pilihanMenu, pilihanMetode;
        String namaFile;
        char simpan;
        Scanner input = null;
        Matriks mMatriks = new Matriks(0,0);
        Matriks MInv = new Matriks(0,0);

        input = new Scanner(System.in);

        System.out.println("INGAT!!!! DALAM MENCARI INVERS HARUS MENGGUNAKAN MATRIKS BUJURSANGKAR");
        System.out.println("-----------------------------------");
        System.out.println("             MENU INVERS");
        System.out.println("-----------------------------------");
        System.out.println("           PILIH CARA BACA");
        System.out.println("-----------------------------------");
        System.out.println("1. Baca Dari Terminal");
        System.out.println("2. Baca Dari File");
        System.out.println("3. Kembali");
        System.out.println("-----------------------------------");
        System.out.print("Masukkan pilihan : ");
        pilihanMenu = input.nextInt();

        //Validasi Input
        while (pilihanMenu!=1 && pilihanMenu!=2 && pilihanMenu!=3) {
            System.out.println("Masukkan Tidak Valid, Coba Lagi");
            System.out.print("Masukkan pilihan : ");
            pilihanMenu = input.nextInt();
        }

        if (pilihanMenu == 1){
            System.out.println("-----------------------------------");

            mMatriks.bacaMatriks();

            System.out.println("-----------------------------------");
            System.out.println("Data matriks Berhasil Terbaca");
        }
        else if (pilihanMenu==2){
            String namafile;
            Scanner file = new Scanner(System.in);

            System.out.println("-----------------------------------");
            System.out.println("List file valid :");
            getAllDataFiles();
            System.out.println("-----------------------------------");
            System.out.print("Masukkan nama file data matriks : ");

            namafile = input.next();
            mMatriks.bacaFileMatriks(namafile);

            System.out.println("-----------------------------------");
            System.out.println("Data matriks Berhasil Terbaca");
        } else if (pilihanMenu==3) {
            clearScreen();
            MainMenu();
        }

        if (pilihanMenu == 1 || pilihanMenu == 2){
            System.out.println("-----------------------------------");
            System.out.println("            MENU INVERS");
            System.out.println("-----------------------------------");
            System.out.println("           PILIH METODE");
            System.out.println("-----------------------------------");
            System.out.println("1. Metode Eliminasi Gauss-Jordan");
            System.out.println("2. Metode Ekspansi Kofaktor");
            System.out.println("3. Kembali");
            System.out.println("-----------------------------------");
            System.out.print("Masukkan pilihan : ");
            pilihanMetode = input.nextInt();

            // VALIDASI PILIHAN SUBMENU
            while (pilihanMetode!=1 && pilihanMetode!=2 && pilihanMetode!=3) {
                System.out.println("Masukkan Tidak Valid, Coba Lagi");
                System.out.print("Masukkan pilihan : ");
                pilihanMetode = input.nextInt();
            }

            if (pilihanMetode == 1){
                MInv = mMatriks.InverseGaussJordan();
                System.out.println("Matriks invers yang terbentuk adalah: ");
                MInv.tulisMatriks();
            }
            else if (pilihanMetode == 2){
                MInv = mMatriks.InversKofaktor();
                System.out.println("Matriks invers yang terbentuk adalah: ");
                MInv.tulisMatriks();
            }
            else{
                System.out.println("PILIHAN MENU TIDAK VALID, COBA LAGI");
                MenuInvers();
            }

        }
        else if (pilihanMenu == 3){
            clearScreen();
            MainMenu();
        }
        else{
            System.out.println("PILIHAN MENU TIDAK VALID, COBA LAGI");
            MenuInvers();
        }

        // MAU DISIMPAN?
        if (pilihanMenu==1 || pilihanMenu==2) {
            // System.out.println("-----------------------------------");
            // mMatriks.tulisMatriks();
            System.out.println("-----------------------------------");
            System.out.print("Simpan Hasil? (y/n) : ");

            simpan = input.next().charAt(0);
            if (simpan=='y') {
                System.out.println("-----------------------------------");
                System.out.print("Masukkan nama file untuk disimpan <ekstensi .txt>: ");

                namaFile = input.next();
                mMatriks.tulisFileMatriks(namaFile);
            }
        }
        tekanEnter();
        clearScreen();
        MainMenu();
    }

    public static void MenuInterpolasi(){
        int pilihanMenu;
        float x,y;
        Interpolasi z;
        char simpan;
        String namaFile;
        Scanner input = null;
        Interpolasi mInterpolasi = new Interpolasi(0,2);

        input = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("           MENU INTERPOLASI");
        System.out.println("-----------------------------------");
        System.out.println("           PILIH CARA BACA");
        System.out.println("-----------------------------------");
        System.out.println("1. Baca Dari Terminal");
        System.out.println("2. Baca Dari File");
        System.out.println("3. Kembali");
        System.out.println("-----------------------------------");
        System.out.print("Masukkan pilihan : ");
        pilihanMenu = input.nextInt();

        // VALIDASI PILIHAN MENU
        while (pilihanMenu!=1 && pilihanMenu!=2 && pilihanMenu!=3) {
            System.out.println("Masukkan Tidak Valid, Coba Lagi");
            System.out.print("Masukkan pilihan : ");
            pilihanMenu = input.nextInt();
        }

        if (pilihanMenu==1) {
            System.out.println("-----------------------------------");

            x = mInterpolasi.bacaInterpolasi();

            System.out.println("-----------------------------------");
            System.out.println("Data Interpolasi Berhasil Terbaca");

        } else if (pilihanMenu==2) {
            System.out.println("-----------------------------------");
            System.out.println("List file valid :");
            getAllDataFiles();
            System.out.println("-----------------------------------");
            System.out.print("Masukkan nama file data interpolasi : ");

            namaFile = input.next();
            x = mInterpolasi.bacaFileInterpolasi(namaFile);

            System.out.println("-----------------------------------");
            System.out.println("Data Interpolasi Berhasil Terbaca");
            
        } else if (pilihanMenu==3) {
            x = 0;
            clearScreen();
            MainMenu();
            
        } else {
            x = 0;
            System.out.println("PILIHAN MENU TIDAK VALID, COBA LAGI");
            MenuInterpolasi();
        }
        
        
        // MAU DISIMPAN?
        if (pilihanMenu==1 || pilihanMenu==2) {
            System.out.println("-----------------------------------");

            // Proses
            y = mInterpolasi.InterpolasiPolinom(x);
            z = mInterpolasi.ConvertToMatrixAug();

            // Tampilkan
            mInterpolasi.tulisInterpolasi(x, y, z);
            
            System.out.println("-----------------------------------");
            System.out.print("Simpan Hasil? (y/n) : ");

            simpan = input.next().charAt(0);
            if (simpan=='y') {
                System.out.println("-----------------------------------");
                System.out.print("Masukkan nama file untuk disimpan <ekstensi .txt>: ");

                namaFile = input.next();
                mInterpolasi.tulisFileInterpolasi(x, y, z, namaFile);
            }
        }
        tekanEnter();
        clearScreen();
        MainMenu();



    }

    public static void MenuRegresi(){
        int pilihanMenu;
        String namaFile;
        char simpan;
        Scanner input = null;
        Regresi mRegresi = new Regresi(0,0);

        try {
            input = new Scanner(System.in);
            System.out.println("-----------------------------------");
            System.out.println("             MENU REGRESI");
            System.out.println("-----------------------------------");
            System.out.println("           PILIH CARA BACA");
            System.out.println("-----------------------------------");
            System.out.println("1. Baca Dari Terminal");
            System.out.println("2. Baca Dari File");
            System.out.println("3. Kembali");
            System.out.println("-----------------------------------");
            System.out.print("Masukkan pilihan : ");
            pilihanMenu = input.nextInt();
            
            // VALIDASI PILIHAN MENU
            while (pilihanMenu!=1 && pilihanMenu!=2 && pilihanMenu!=3) {
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

            // MAU DISIMPAN?
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
        File dataFile = new File(curDir);
        File[] listFile = dataFile.listFiles();
        for(File f : listFile){
            System.out.println(f.getName());
        }
    }

    /** Clear Screen */
    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();   
    }
    
    /** Tekan Enter untuk melanjutkan */
    public static void tekanEnter(){
        System.out.println("Tekan \"ENTER\" untuk melanjutkan...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
     }
}

import java.io.File;
import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        String srcData = "../src/data";

        // File data = new File(srcData);
        // getAllFiles(data);

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

        input.close();

        
        
    }


    public static void MenuSPL(){

    }

    public static void MenuDeterminan(){
        
    }

    public static void MenuInvers(){
        
    }

    public static void MenuInterpolasi(){
        
    }

    public static void MenuRegresi(){
        int pilihanMenu;
        Scanner input = null;
        Regresi mRegresi = new Regresi(0,0);

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

        if (pilihanMenu==1) {
            



        } else if (pilihanMenu==2) {
            
        } else if (pilihanMenu==3) {
            
        } else {

        }
        
    }



    public static void getAllFiles(File curDir) {
        File[] listFile = curDir.listFiles();
        for(File f : listFile){
            System.out.println(f.getName());
        }
    }

    public static void clearScreen() {
        // Butuh Bantuan
        for (int i = 0; i < 50; ++i) System.out.println();   
        // System.out.flush();
    }  
}

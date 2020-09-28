import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Interpolasi extends SPL {


    Interpolasi(int NBrsEff, int NKolEff) {
        super(NBrsEff,NKolEff);
    }


    void InterpolasiPolinom()
    //Melakukan proses interpolasi polinom dengan menggunakan metode eliminasi gauss dalam matriks augmented.
    {
        Scanner input = new Scanner(System.in);
        Scanner file = new Scanner(System.in);

        System.out.println("Pilihan:");
        System.out.println("1. Baca dari keyboard");
        System.out.println("2. Baca dari file");
        System.out.println("Format dalam memilih: 1 atau 2");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.close();

        if (pilihan == 2) {
            String namafile = file.nextString();
            this.bacaFileSPL(namafile);
            file.close();
        }
        else if (pilihan == 1) {
            int i, j;
            Scanner input = new Scanner(System.in);
            Scanner N = new Scanner(System.in);

            System.out.print("Masukkan Banyaknya n : ");
            int NBrsEff = N.nextInt();
            int NKolEff = 2;

            N.close();

            while (NBrsEff > this.maxNBrsKol || NKolEff > this.maxNBrsKol) {
                this.doubleMatriks();
            }

            this.NBrsEff = NBrsEff;
            this.NKolEff = NKolEff;

            for (i = 0; i < this.NBrsEff; i++) {
                for (j = 0; j < this.NKolEff; j++) {
                    this.Matriks[i][j] = input.nextFloat();
               }
          }
          input.close();
        }
        


    }
    
}

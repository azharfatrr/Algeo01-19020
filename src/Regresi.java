
import java.io.File;
import java.util.Scanner;

public class Regresi extends SPL {
    /* ***** ATRIBUTE ***** */

    /** Menyimpan Tabel Berisi Data dari tiap X1i, X2i, .. , Xni, dan nilai Yi 
     * Disimpan pada MATRIKS
    */

    /* ***** METHODS ***** */

    /* *** Konstruktor membentuk MATRIKS AUGMENTED SPL *** */
    Regresi(int NBrsEff, int NKolEff) {
        super(NBrsEff,NKolEff);
    }

    /* *** KELOMPOK BACA/TULIS *** */
    /** Baca Data Regresi
     * I.S. Matriks Data Regresi Terdefinisi
    * F.S. Matriks Data Regresi Berisi Nilai
    */
    void bacaRegresi() {
        int i, j;
        int N; // Banyaknya Peubah
        int I; // Banyaknya Data
        Scanner input = new Scanner(System.in);
        Scanner meta = new Scanner(System.in);

        System.out.print("Masukkan Banyaknya Peubah : ");
        N = meta.nextInt();
        System.out.print("Masukkan Banyaknya Data : ");
        I = meta.nextInt();

        meta.close();

        while (N > this.maxNBrsKol || I > this.maxNBrsKol) {
            this.doubleMatriks();
        }

        this.NBrsEff = N + 1;
        this.NKolEff = I;

        for (i = 0; i < this.NBrsEff; i++) {
            for (j = 0; j < this.NKolEff; j++) {
                this.Matriks[i][j] = input.nextFloat();
            }
        }
        input.close();
    }

    /** Baca Data Regresi
    * I.S. Matriks Data Regresi Terdefinisi
    * F.S. Matriks Data Regresi Berisi Nilai dari file
    */
    void bacaFileRegresi(String namaFile) {
        bacaFileMatriks(namaFile);
    }

    /* ** SELEKTOR ** */

    /* Mengembalikan Banyaknya Peubah */
    int nPeubah() {
        return this.NKolEff - 1;
    }

    /* Mengembalikan Banyaknya Data */
    int nData() {
        return this.NBrsEff;
    }

    Matriks normalEstimation() {
        Matriks MNE = new Matriks(this.nPeubah()+1,this.nPeubah());

        int k = 0; // Menentukan posisi
        for (int i = MNE.GetFirstIdxBrs(); i <= MNE.GetLastIdxBrs() ; i++) {
            for (int j = MNE.GetFirstIdxKol(); j <= MNE.GetLastIdxKol(); j++) {
                float sum = 0;
                for (int l = this.GetFirstIdxBrs(); l <= this.GetLastIdxBrs(); l++) {
                    sum += this.GetElmt(j,l);
                }
            }
        }


        return MNE;

    }

}

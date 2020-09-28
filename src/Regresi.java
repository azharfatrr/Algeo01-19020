
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

    /** TO DO
     * - Tulis Persamaan Regresi di Terminal dan File
     * - Tulis Hasil Regresi di Terminal dan File
     */

    /* ** SELEKTOR ** */

    /* Mengembalikan Banyaknya Peubah */
    int nPeubah() {
        return this.NKolEff - 1;
    }

    /* Mengembalikan Banyaknya Data */
    int nData() {
        return this.NBrsEff;
    }

    /** Melakukan Normal Estimation Equation untuk Multiple Linier Regression  
    * I.S. Matriks Data Regresi Terdefinisi
    * F.S. Dikembalikan SPL hasil normalEstimation dan siap untuk disolve untuk setiap nilai b
    */
    SPL normalEstimation() {
        SPL MNE = new SPL(this.nPeubah()+1,this.nPeubah()+2);

        int k = -1; // Menentukan posisi (status)
        int n;
        for (int i = MNE.GetFirstIdxBrs(); i <= MNE.GetLastIdxBrs() ; i++) {

            for (int j = this.GetFirstIdxKol(); j <= this.GetLastIdxKol(); j++) {
                float sum = 0;
                n = j + 1;
                for (int l = this.GetFirstIdxBrs(); l <= this.GetLastIdxBrs(); l++) {
                    if (i==0) {
                        sum += this.GetElmt(l,j);
                    } else {
                        sum += this.GetElmt(l,j)*this.GetElmt(l,k);
                    }
                   
                }
                if (j==0 && i==0) {
                    MNE.Matriks[i][j] = this.nData();
                } else if (j==0) {
                    MNE.Matriks[i][j] = MNE.Matriks[j][i];
                } 
                MNE.Matriks[i][n] = sum;
            }
            k++;
        }
        return MNE;
    }

    /** Memberikan hasil Regresi dari Parameter yang akan diminta
    * I.S. Matriks Data Regresi Terdefinisi
    * F.S. Dikembalikan hasil regresi untuk setiap paramater yang akan diminta
    */
    float hasilRegresi() {
        SPL MHasil = this.normalEstimation();
        Scanner input = new Scanner(System.in);
        float P;
        
        // Apakah perlu ganti Metode?
        MHasil.solveGauss();

        float hasil = MHasil.Solusi[0] ; // Inisialisasi

        
        for (int i = 1; i <= this.nPeubah(); i++) {
            System.out.print("Masukkan Nilai Parameter " + i + ": ");
            P = input.nextFloat();
            hasil += P*MHasil.Solusi[i];
        }

        input.close();
        return hasil;
    }
}


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Regresi extends SPL {
    /* ***** ATRIBUTE ***** */

    /** Menyimpan Parameter yang ingin dicari berapa hasil Regresinya
     * Indeks [0..this.nPeubah-1]
     */
    float Parameter[];

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
        Scanner input = null; 
        try {
            input = new Scanner(System.in);
            
            System.out.print("Masukkan Banyaknya Peubah : ");
            N = input.nextInt();
            System.out.print("Masukkan Banyaknya Data : ");
            I = input.nextInt();


            while (N > this.maxNBrsKol || I > this.maxNBrsKol) {
                this.doubleMatriks();
            }

            this.NBrsEff = I;
            this.NKolEff = N + 1;

            System.out.println("Masukkan tabel data <x1 x2 .. xk y> : ");
            for (i = 0; i < this.NBrsEff; i++) {
                for (j = 0; j < this.NKolEff; j++) {
                    this.Matriks[i][j] = input.nextFloat();    
                }
            }

            this.bacaParameter();

        } catch (Exception e) {
            System.err.println("Error di bacaRegresi");
        }
    }

    /** Baca Data Regresi
    * I.S. Matriks Data Regresi Terdefinisi
    * F.S. Matriks Data Regresi Berisi Nilai dari file
    */
    void bacaFileRegresi(String namaFile) {
        bacaFileMatriks(namaFile);
        this.bacaParameter();
    }

    /** Baca Parameter Xk
    * I.S. Matriks Data Regresi Terdefinisi
    * F.S. Atribut Parameter Matriks Data Regresi Terisi
    */
    void bacaParameter() {
        Scanner masukkan = null;

        try {
            masukkan = new Scanner(System.in);
            this.Parameter = new float[this.nPeubah()];

            for (int i = 0; i < this.nPeubah(); i++) {
                System.out.print("Masukkan Nilai Parameter X" + (i+1) + ": ");
                this.Parameter[i] = masukkan.nextFloat();  
            }
        } catch (Exception e) {
            System.err.println("Error di parameter");
        } 
    }


    /** Tulis Hasil Regresi
    * I.S. Matriks Data Regresi Terdefinisi dan Atribut Parameter Terdefinisi
    * F.S. Persamaan Regresi dan Hasil Regresi ditulis pada terminal
    */
   void tulisRegresi() {
        Regresi MNormal = this.normalEstimation();

        MNormal.Parameter = this.Parameter;
        float hasil = MNormal.hasilRegresi();

        if (MNormal.jenisSolusi()==0) {
            String persamaanRegresi = "Persamaan Regresi :\ny = " + MNormal.Persamaan[0] + " ";

            for (int i = 1; i <= this.nPeubah(); i++) {
                if (MNormal.Solusi[i]<0) {
                    persamaanRegresi += "- " + Math.abs(MNormal.Solusi[i]) + "*X" + i + " ";
                } else {
                    persamaanRegresi += "+ " + Math.abs(MNormal.Solusi[i]) + "*X" + i + " ";
                }
            }

            System.out.println(persamaanRegresi);
            System.out.println("Hasil Regresi : "+ hasil);

        } else {
            System.err.println("Regresi tidak berhasil");
        }
   }

   /** Tulis Hasil Regresi ke File
    * I.S. Matriks Data Regresi Terdefinisi dan Atribut Parameter Terdefinisi
    * F.S. Persamaan Regresi dan Hasil Regresi ditulis pada tfile
    */
   void tulisFileRegresi(String namaFile) {
        String line;
        Regresi MNormal = this.normalEstimation();

        MNormal.Parameter = this.Parameter;
        float hasil = MNormal.hasilRegresi();

        try {
            String namaFileDir = "./hasil/" + namaFile;
            FileWriter writeSPL = new FileWriter(namaFileDir);

            if (MNormal.jenisSolusi()==0) {
                String persamaanRegresi = "Persamaan Regresi :\ny = " + MNormal.Persamaan[0] + " ";

                for (int i = 1; i <= this.nPeubah(); i++) {
                    if (MNormal.Solusi[i]<0) {
                        persamaanRegresi += "- " + Math.abs(MNormal.Solusi[i]) + "x" + i + " ";
                    } else {
                        persamaanRegresi += "+ " + Math.abs(MNormal.Solusi[i]) + "x" + i + " ";
                    }
                }

                line = persamaanRegresi + "\nHasil Regresi : " + hasil;
            } else {
                line = "Regresi tidak berhasil";
            }

            writeSPL.write(line);
            writeSPL.close();
            System.out.println("Berhasil menyimpan hasil regresi pada folder hasil, file \"" + namaFile + "\".");

        } catch (IOException e) {
            System.err.println("Terjadi error.");
            e.printStackTrace();
        }
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

    /** Melakukan Normal Estimation Equation untuk Multiple Linier Regression  
    * I.S. Matriks Data Regresi Terdefinisi
    * F.S. Dikembalikan SPL REGRESI hasil normalEstimation dan siap untuk disolve untuk setiap nilai b
    */
    Regresi normalEstimation() {
        Regresi MNE = new Regresi(this.nPeubah()+1,this.nPeubah()+2);

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
    * I.S. SPL REGRESI hasil Normal Estimation dan Atribut Parameter terdefinisi
    * F.S. Dikembalikan hasil regresi
    */
    float hasilRegresi() {
        float P;
        // Karena I.S. adalah SPL REGRESI yang telah dilakukan Normal Estimation, maka
        int nParameter = this.NKolEff-2;
        
        this.metodeGauss();

        if (this.jenisSolusi() == 0) {
            float hasil = this.Solusi[0] ; // Inisialisasi

            for (int i = 0; i < nParameter; i++) {
                P = this.Parameter[i];
                hasil += P*this.Solusi[i+1];
            }
            return hasil;
            
        } else {
            return -999999;
        }

    }
}

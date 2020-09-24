import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matriks {
     /* ***** ATRIBUTE ***** */
     private int maxNBrsKol = 1; //panjang maksimum baris dan kolom matriks
     float [][] Matriks = new float[maxNBrsKol][maxNBrsKol]; //inisialisasi matriks 1x1
     int NBrsEff; /* banyaknya/ukuran baris yg terdefinisi */
	int NKolEff; /* banyaknya/ukuran kolom yg terdefinisi */

     /* Matriks Yang terdefinisi memiliki indeks dari [0..NBrsEff-1][0..NKolEff-1] */

     /* ***** METHODS ***** */

     /* *** Konstruktor membentuk MATRIKS *** */
     Matriks(int NBrsEff, int NKolEff) {
          // KAMUS
          int i, j;

          // ALGORITMA
          // Ubah ukuran matriks
          while (NBrsEff > this.maxNBrsKol || NKolEff > this.maxNBrsKol) {
               this.doubleMatriks();
          }

          // Inisialisasi isi matriks
          this.NBrsEff = NBrsEff;
          this.NKolEff = NKolEff;

          for (i = 0; i < NBrsEff; i++) {
               for (j = 0; j < NKolEff; j++) {
                    this.Matriks[i][j] = 0;
               }
          }

     }

     /* *** KELOMPOK BACA/TULIS *** */
     /**
      * Baca Matriks I.S. Membaca matriks pada layar F.S. Matriks terdefinisi nilai
      * elemen efektifnya, berukuran NB x NK
      */
     void bacaMatriks() {
          int i, j;
          Scanner input = new Scanner(System.in);

          for (i = 0; i < this.NBrsEff; i++) {
               for (j = 0; j < this.NKolEff; j++) {
                    this.Matriks[i][j] = input.nextFloat();
               }
          }
          input.close();
     }

     /**
      * Tulis Matriks I.S. Matriks terdefinisi dan memiliki nilai F.S. Menampilkan
      * matriks pada layar
      */
     void tulisMatriks() {
          // mencetak elemen-elemen matriks hingga indeks M,N
          int i, j;

          for (i = 0; i < this.NBrsEff; i++) {
               for (j = 0; j < this.NKolEff; j++) {
                    System.out.print(this.Matriks[i][j] + " ");
               }
               System.out.println();
          }
     }

     /** Baca Matriks dari File Txt
      * I.S. File txt berisi Array Matriks
      * F.S. Terbaca Matriks dan disimpan dalam variabel */
     void bacaFileMatriks(String namaFile) throws FileNotFoundException
     {
          // Kamus
          File file = new File(namaFile);
          int NBrs = 0;
          int NKol = 0;
          int i,j; // Indeks

          Scanner matriks = new Scanner(file); // Digunakan untuk memindahkan matriks

          // Algoritma
          
          // Menghitung banyaknya baris matriks
          while (matriks.hasNextLine()) {
               NBrs++;
               matriks.nextLine();
          }
          matriks.close();

          matriks  = new Scanner(file);
          Scanner line = new Scanner(matriks.nextLine());
          // Menghitung banyaknya kolom baris matriks
          while (line.hasNextFloat()) {
               NKol++;
               line.nextFloat();
          }
          line.close();
          matriks.close();
          
          this.NBrsEff = NBrs;
          this.NKolEff = NKol;

          matriks  = new Scanner(file);
          // Cek apakah ukuran muat
          while (NBrs > this.maxNBrsKol || NKol > this.maxNBrsKol) {
               this.doubleMatriks();
          }

          // Isi Matriks
          for (i = 0; i < NBrs; i++) {
               for (j = 0; j < NKol; j++) {
                    this.Matriks[i][j] = matriks.nextFloat();
               }
          }
          matriks.close();
     }


     /* *** KELOMPOK OPERASI PRIMITIF ***/

     void transpose (int M, int N, float Matt[][]) {
          //Membuat matriks transpose
          int i,j;

          for (i = 0; i <= M; i++) {
               for (j = 0; j <= N; j++) {
                    Matt[j][i] = this.Matriks[i][j];
               }
          }
     }

     /* *** MEMORY MANAGEMENT *** */

     /**
      * Mengubah ukuran maksimum Baris dan Kolom Matriks menjadi 2x semula I.S.
      * Matriks Terdefinisi F.S. Panjang maksimum Baris dan Kolom Matriks menjadi 2x
      * semula Ukuran memory matriks menjadi 4x semula
      **/
     void doubleMatriks() {
          // Kamus
          this.maxNBrsKol = this.maxNBrsKol * 2;
          float[][] NewMatriks = new float[this.maxNBrsKol][this.maxNBrsKol];

          // Algoritma
          NewMatriks = this.copyArrayMatriks();
          this.Matriks = NewMatriks;
     }

     /**
      * Mengubah ukuran maksimum Baris dan Kolom Matriks menjadi 2x semula I.S.
      * Matriks Terdefinisi dan panjang baris dan kolom maksumim 2x NBrsEff dan NKolEff
      * F.S. Panjang maksimum Baris dan Kolom Matriks menjadi 1/2x semula Ukuran
      * memory matriks menjadi 1/4x semula
      **/
     void halfMatriks() {
          if ((this.NBrsEff <= this.maxNBrsKol / 2) && (this.NKolEff <= this.maxNBrsKol / 2)) {
               // Kamus
               this.maxNBrsKol = this.maxNBrsKol * 1 / 2;
               float[][] NewMatriks = new float[this.maxNBrsKol][this.maxNBrsKol];

               // Algoritma
               NewMatriks = this.copyArrayMatriks();
               this.Matriks = NewMatriks;
          } else {
               System.err.println("Matriks tidak bisa diperkecil");
          }
     }

     /** Mengcopy array matriks ke tempat lain */
     float[][] copyArrayMatriks() {
          // Kamus
          float[][] MHsl = new float[this.maxNBrsKol][this.maxNBrsKol];

          // Algoritma
          for (int i = 0; i < this.NBrsEff; i++) {
               for (int j = 0; j < this.NBrsEff; j++) {
                    MHsl[i][j] = this.Matriks[i][j];
               }
          }
          return MHsl;
     }

     /** Mencopy matriks ke matriks lain */
     Matriks copyMatriks() {
          // Kamus
          Matriks MCopy = new Matriks(this.NBrsEff, this.NKolEff);
          // Algoritma
          MCopy.Matriks = this.copyArrayMatriks();
          MCopy.maxNBrsKol = this.maxNBrsKol;
          MCopy.NBrsEff = this.NBrsEff;
          MCopy.NKolEff = this.NKolEff;

          return MCopy;
     }

     /* Mengakses Elemen Matriks */
     float Elmt(int i, int j) {
          return this.Matriks[i][j];
     }

     /* Set element matriks[i][j] dengan val */
     void SetElmt(int i, int j, float value) {
          this.Matriks[i][j] = value;
     }

     /* Mengembalikan indeks baris pertama */
     int GetFirstIdxBrs() {
          return 0;
     }

     /* Mengembalikan indeks kolom pertama */
     int GetFirstIdxKol() {
          return 0;
     }

     /* Mengembalikan indeks baris terakhir */
     int GetLastIdxBrs(){
          return this.GetFirstIdxBrs()+this.NBrsEff-1;
     }

     /* Mengembalikan indeks kolom terakhir */
     int GetLastIdxKol(){
          return this.GetFirstIdxKol()+this.NKolEff-1;
     }

     /* Mengembalikan elemen diagonal! */
     float GetDiagonal(int i) {
          return this.Elmt(i,i);
     }

     /*       KELOMPOK OPERASI OBE          */
     void PlusRow(int origin, int target, float koef) {
     /*Melakukan operasi Rasal+(koef)*Rakhir */
          int j;

          for (j=this.GetFirstIdxKol(); j<=this.GetLastIdxKol(); j++) {
               this.SetElmt(target, j, (this.Elmt(target, j)+(koef*this.Matriks[origin][j])));
          }
     }

     void SwapRow(int origin, int target) {
          /* Melakukan operasi pertukaran baris */
          int j;
          float temp;

          for (j=this.GetFirstIdxKol(); j<=this.GetLastIdxKol(); j++) {
               // elemen 
               temp = this.Elmt(origin, j);
               this.SetElmt(origin, j, this.Elmt(target, j));
               this.SetElmt(target, j, temp);
          }
     }

     void MakeSatu(int i, float koef) {
          /* Membagi baris i dengan konstanta koef untuk membuat 1 utama */
          int j;
          for (j=this.GetFirstIdxKol(); j<=this.GetLastIdxKol(); j++){
               this.SetElmt(i, j, (this.Elmt(i, j)/koef));
          }
     }



}

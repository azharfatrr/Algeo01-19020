/* kelas array matrix */

class Matriks {
     //Atribut
     private int maxNBrsKol = 1;
     double [][] Matriks = new double[1][1]; //inisialisasi matriks 2x2
     int NBrs;
     int NKol;


     // Method
     Matriks(int NBrs, int NKol) { //Konstruktor
          int i,j;

          // Ganti ukuran matriks
          while(NBrs>maxNBrsKol || NKol>maxNBrsKol) {
               this.maxNBrsKol = this.maxNBrsKol*2;

               double [][] NewMatriks = new double[this.maxNBrsKol][this.maxNBrsKol];
               this.Matriks = NewMatriks;
          }
          
          // Inisialisasi isi matriks
          this.NBrs = NBrs;
          this.NKol = NKol;

          for (i=0;i<NBrs;i++) {
               for (j=0;j<NKol;j++) {
                    this.Matriks[i][j] = -99;
               }
          }
          
          
     }

     void isiMatriks (int N, int M) {
          //mengisi elemen matriks dengan nilai i+j
          int i,j;
          for (i=0;i<N;i++) {
               for (j=0;j<M;j++) {
                    this.Matriks[i][j] = i+j;
               }
          }
     }

     void tulisMatriks () {
          // mencetak elemen-elemen matriks hingga indeks M,N
          int i,j;

          for (i=0;i < this.NBrs;i++) {
               for (j=0;j < this.NKol;j++) {
                    System.out.print(this.Matriks[i][j]+" ");
               }
               System.out.println();
          }
     }

     void transpose (int M, int N, double Matt[][]) {
          //Membuat matriks transpose
          int i,j;

          for (i=0;i<=M;i++) {
               for (j=0;j<=N;j++) {
                    Matt[j][i] = this.Matriks[i][j];
               }
          }          
     }
}

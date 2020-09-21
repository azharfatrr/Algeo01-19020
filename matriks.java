/* kelas array matrix */

class matriks {
     //Atribut
     int [][] Mat = new int[10][10]; //matriks 10x10

     //Method
     matriksEmpty() { //Konstruktor
          int i,j;

          for (i=0;i<10;i++) {
               for (j=0;j<10;j++) {
                    this.Mat[i][j] = 0;
               }
          }
     }

     void isiMatriks (int N, int M) {
          //mengisi elemen matriks dengan nilai i+j
          int i,j;
          for (i=0;i<N;i++) {
               for (j=0;j<M;j++) {
                    this.Mat[i][j] = i+j;
     }

     void tulisMatriks (int M, int N) {
          // mencetak elemen-elemen matriks hingga indeks M,N
          int i,j;

          for (i=0;i<=M;i++) {
               for (j=0;j<=N;i++) {
                    System.out.print(this.Mat[i][j]+" ");
               }
               System.out.println();
          }
     }

     void transpose (int M, int N, int Matt[][]) {
          //Membuat matriks transpose
          int i,j;

          for (i=0;i<=M;i++) {
               for (j=0;j<=N;j++) {
                    Matt[j][i] = this.Mat[i][j];
               }
          }          
     }
}
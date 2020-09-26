
public class Main {
    public static void main(String[] args) {
        Matriks M = new Matriks(0,0);

        M.bacaFileMatriks("cek.txt");
        M.tulisMatriks();

        Matriks N = new Matriks(3,3);
        N.tulisMatriks();
        N.bacaMatriks();
        N = N.InversKofaktor();
        N.tulisMatriks();

    }
}

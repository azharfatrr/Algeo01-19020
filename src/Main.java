
public class Main {
    public static void main(String[] args) {
        Matriks M = new Matriks(0,0);

        M.bacaFileMatriks("cek.txt");
        M.tulisMatriks();

        M.bacaMatriks();
        M = M.InversKofaktor();
        M.tulisMatriks();

    }
}

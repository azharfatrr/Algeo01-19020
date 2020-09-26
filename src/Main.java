
public class Main {
    public static void main(String[] args) {
        Matriks M = new Matriks(0,0);

        M.bacaFileMatriks("cek.txt");
        M.GaussJordanElimination();
        M.tulisMatriks();


    }
}

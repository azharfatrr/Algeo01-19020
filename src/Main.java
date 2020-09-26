
public class Main {
    public static void main(String[] args) {
        Matriks M = new Matriks(0,0);

        //M.bacaMatriks();

        //M.tulisMatriks();

        //SPL M = new SPL(0,0);
        float Det;
        Matriks Invers;
        M.bacaFileMatriks("cek.txt");
        Invers = M.InverseGaussJordan();
        Invers.tulisMatriks();
        //M.bacaFileSPL("cek.txt");
        //M.tulisSPL();


    }
}

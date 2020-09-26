
public class Main {
    public static void main(String[] args) {
<<<<<<< Updated upstream
        Matriks M = new Matriks(0,0);

        M.bacaMatriks();

        M.tulisMatriks();

=======
        SPL M = new SPL(0,0);
        float Det;
        M.bacaFileMatriks("cek.txt");
        Det = M.DeterminanGauss();
        M.tulisMatriks();
        //M.bacaFileSPL("cek.txt");
        //M.tulisSPL();
>>>>>>> Stashed changes


    }
}

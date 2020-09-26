
public class Main {
    public static void main(String[] args) {

        SPL M1 = new SPL(0,0);
        M1.bacaFileSPL("cek.txt");
        M1.tulisSPL();
        System.out.println(M1.jenisSolusi());

        // Matriks M = new Matriks(0,0);
        // float Det;
        // M.bacaFileMatriks("cek.txt");
        // Det = M.DeterminanGauss();
        // M.tulisMatriks();



    }
}

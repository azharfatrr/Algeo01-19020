
public class Main {
    public static void main(String[] args) {
        SPL M = new SPL(0,0);

        M.bacaFileMatriks("cek.txt");
        M.GaussJordanElimination();
        M.tulisMatriks();
        M.bacaFileSPL("cek.txt");
        M.tulisSPL();


    }
}

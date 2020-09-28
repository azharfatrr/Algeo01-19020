
public class Main {
    public static void main(String[] args) {

        Regresi M = new Regresi(0, 0);
        // System.out.println("Matriks Augmented Awal");
        // M1.tulisSPL();

        // System.out.println("Matriks Augmented Telah dilakukan OBE");

        M.bacaFileRegresi("cek3.txt");

        SPL M1 = M.normalEstimation();

        float a = M.hasilRegresi();


        M1.tulisFileSPL("nilaiRegresi.txt");

        // float a = M.hasilRegresi();

        // System.out.println(a);
        

        // for (int i = 0; i < M1.Persamaan.length; i++) {
        //     System.out.println(M1.Persamaan[i]);
        // }

        // M1.tulisFileMatriks("coba.txt");



    }
}

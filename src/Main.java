
public class Main {
    public static void main(String[] args) {

        SPL M1 = new SPL(0,0);
        Matriks MTest = new Matriks(3, 3);
        Matriks MInv = new Matriks(3, 3);
        
        M1.bacaFileSPL("cek2.txt");
        MTest.bacaFileMatriks("cek3.txt");
        // System.out.println("Matriks Augmented Awal");
        // M1.tulisSPL();
        MTest.tulisMatriks();
        System.out.println("\n");
        // System.out.println("Matriks Augmented Telah dilakukan OBE");


        MInv = MTest.InverseGaussJordan();
        //M1.solveGauss();
        //M1.tulisFileSPL("coba.txt");
        //M1.tulisSPL();
        System.out.println("\n");
        //MInv.tulisMatriks();
        

        // for (int i = 0; i < M1.Persamaan.length; i++) {
        //     System.out.println(M1.Persamaan[i]);
        // }

        // M1.tulisFileMatriks("coba.txt");



    }
}


public class Main {
    public static void main(String[] args) {

        SPL M1 = new SPL(0,0);
        Matriks MTest = new Matriks(3, 3);
        Matriks MInv = new Matriks(3, 3);
        
        M1.bacaFileSPL("cek3.txt");
        MTest.bacaFileMatriks("cek3.txt");
        System.out.println("Matriks Augmented Awal");
        //M1.tulisSPL();

        MTest.tulisMatriks();
        float det=0;
        det = MTest.DeterminanGauss();
        System.out.println(det);

        MInv = MTest.InverseGaussJordan();
        
        System.out.println("Matriks Augmented Telah dilakukan OBE");
        
        //M1.SPLInvers();
        //M1.solveGauss();
        //M1.tulisSPL();
        MInv.tulisMatriks();
        

        /*for (int i = 0; i < M1.Persamaan.length; i++) {
            System.out.println(M1.Persamaan[i]);
        }*/



    }
}

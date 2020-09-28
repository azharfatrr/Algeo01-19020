
public class Main {
    public static void main(String[] args) {

        SPL M1 = new SPL(0,0);
        
        M1.bacaFileSPL("cek.txt");
        System.out.println("Matriks Augmented Awal");
        M1.tulisSPL();



        System.out.println("Matriks Augmented Telah dilakukan OBE");

        M1.solveGauss();
        M1.tulisSPL();
        

        for (int i = 0; i < M1.Persamaan.length; i++) {
            System.out.println(M1.Persamaan[i]);
        }



    }
}

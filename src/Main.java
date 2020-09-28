
public class Main {
    public static void main(String[] args) {

        SPL M1 = new SPL(0,0);
        M1.bacaFileSPL("cek2.txt");
        System.out.println("Matriks Augmented Awal : ");
        M1.tulisSPL();

        int indikatorDet = 0;
        M1.GaussElimination(indikatorDet);
        System.out.println("Matriks Augmented Akhir : ");
        M1.tulisSPL();
        //System.out.println(M1.jenisSolusi());
        //M1.solveGauss();

        /*for (int i = 0; i < M1.Solusi.length; i++) {
            System.out.println(M1.Solusi[i]);
        }*/



    }
}

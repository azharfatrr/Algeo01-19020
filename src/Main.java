
public class Main {
    public static void main(String[] args) {

        SPL M1 = new SPL(0,0);
        M1.bacaFileSPL("cek.txt");
        M1.tulisSPL();
        int indikatorDet = 0;
        M1.GaussElimination(indikatorDet);
        M1.tulisSPL();
        System.out.println(M1.jenisSolusi());
        M1.solveGauss();

        for (int i = 0; i < M1.Solusi.length; i++) {
            System.out.println(M1.Solusi[i]);
        }



    }
}

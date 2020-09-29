
public class Main {
    public static void main(String[] args) {



        // Regresi
        /*Regresi M = new Regresi(0, 0);

        M.bacaRegresi();
        M.tulisRegresi();

        M.tulisFileRegresi("hasilRegresi.txt");*/
        Matriks M = new Matriks(0,0);

        Matriks Inv = new Matriks(0,0);

        M.bacaFileMatriks("cek3.txt");

        float Det;
        Det = M.DeterminanKofaktor();
        System.out.println(Det);
        
        Det = M.DeterminanGauss();
        
        System.out.println(Det);
        





    }
}

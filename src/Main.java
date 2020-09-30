
public class Main {
    public static void main(String[] args) {

        Regresi M = new Regresi(0,0);
        SPL M1 = new SPL(0,0);
        Matriks M2,M3;

        // int k=0;
        // float b = 1;
        // for (int i = 0; i < M.NBrsEff; i++) {
        //     for (int j = 0; j < M.NKolEff; j++) {
        //         M.Matriks[i][j] = b/(j+1+k);
        //     }
        //     k++;
        // }

        // M.tulisMatriks();
        // System.out.println();

        M.bacaFileRegresi("testcase_8.txt");
        // M.GJordanElimination();
        M.tulisRegresi();
        // M2 = M.InversKofaktor();
        // M3 = M.InverseGaussJordan();
        // // // M.metodeInvers();
        // // // System.out.println();
        
        // M2.tulisMatriks();
        // System.out.println();
        // M3.tulisMatriks();

        // M1.bacaFileSPL("testcase_1d_1.txt");
        // // M.GaussElimination();
        // System.out.println();
        // M.tulisMatriks();

        // M2.bacaFileSPL("testcase_1d_1.txt");
        // M2.metodeCramer();
        // System.out.println();
        // M2.tulisSPL();
        



    }

    

}

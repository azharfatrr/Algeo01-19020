
public class Main {
    public static void main(String[] args) {



        // // Regresi
        Regresi M = new Regresi(0, 0);

        M.bacaFileRegresi("./data/dataRegresi.txt");
        M.tulisRegresi();

        M.tulisFileRegresi("hasilRegresi.txt");




    }
}

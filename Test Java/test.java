import java.util.Scanner;

// * Output Hello World

public class test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Scanner in = new Scanner (System.in);
        System.out.print("nama : ");
        String nama = in.nextLine();

        System.out.println("usia : ");
        int usia = in.nextInt();

        System.out.print("Nama saya " + nama + ", " + usia + " tahun");

        int i;
        for (i = 1; i <= usia; i++) {
            System.out.println("i = " + i);
           
        
        }
        
    }   
}
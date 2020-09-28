import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Interpolasi extends SPL {


    Interpolasi(int NBrsEff, int NKolEff) {
        super(NBrsEff,NKolEff);
    }

	float bacaInterpolasi()
	{
		int i, j;
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Banyaknya n : ");
        int NBrsEff = input.nextInt();
        int NKolEff = 2;

        while (NBrsEff > this.maxNBrsKol || NKolEff > this.maxNBrsKol) {
        	this.doubleMatriks();
        }

        this.NBrsEff = NBrsEff;
        this.NKolEff = NKolEff;

        for (i = 0; i < this.NBrsEff; i++) {
            for (j = 0; j < this.NKolEff; j++) {
            	this.Matriks[i][j] = input.nextFloat();
            }
        }
		
		System.out.print("Masukkan nilai x yang akan ditaksir : ");
        float x = input.nextFloat();
        
      	input.close();    
		
		return x;
	}


    float InterpolasiPolinom(float x)
    //Melakukan proses interpolasi polinom dengan menggunakan metode eliminasi gauss dalam matriks augmented.
    {
        //Scanner input = new Scanner(System.in);
        //Scanner file = new Scanner(System.in);

        //System.out.println("Pilihan:");
        //System.out.println("1. Baca dari keyboard");
        //System.out.println("2. Baca dari file");
        //System.out.println("Format dalam memilih: 1 atau 2");
        //System.out.print("Masukkan pilihan: ");
        //int pilihan = input.nextInt();
        //input.close();

        //if (pilihan == 2) {
          //  String namafile = file.nextString();
            //this.bacaFileSPL(namafile);
            //file.close();
        //}
        //else if (pilihan == 1) {
            //int i, j;
            //Scanner input = new Scanner(System.in);
            //Scanner N = new Scanner(System.in);

//            System.out.print("Masukkan Banyaknya n : ");
  //          int NBrsEff = N.nextInt();
    //        int NKolEff = 2;
//
  //          N.close();

    //        while (NBrsEff > this.maxNBrsKol || NKolEff > this.maxNBrsKol) {
      //          this.doubleMatriks();
        //    }

          //  this.NBrsEff = NBrsEff;
            //this.NKolEff = NKolEff;

            //for (i = 0; i < this.NBrsEff; i++) {
              //  for (j = 0; j < this.NKolEff; j++) {
                //    this.Matriks[i][j] = input.nextFloat();
               //}
          //}
          //input.close();
        //}
        float y = 0;
        int j, pangkat;
        //Scanner inputs = new Scanner(System.in);



        SPL augmented;
        augmented = this.ConvertToMatrixAug();

		augmented.Solusi = new float [augmented.NKolEff-1];
        augmented.Persamaan = new String [augmented.NKolEff-1];
        augmented.Status = new int [augmented.NKolEff-1];

        augmented.GaussElimination();
        augmented.solusiGauss();

        pangkat = 0;
        for (j = 0; j < augmented.GetLastIdxKol(); j++) {
            y += augmented.Solusi[j]*Math.pow(x,pangkat);
            pangkat++;
        }
        return y;
    }

    SPL ConvertToMatrixAug()
    // I.S. terdapat ragam (xn,yn) dan nilai x yang akan ditaksir
    // F.S. terbentuk matriks yang akan siap untuk di eliminasi gauss jordan dan ditemukan solusinya
    {
        SPL Mat;

        Mat = new SPL(this.NBrsEff, this.NKolEff+1);
        int pangkat = 0;
        int i,j;
        int k,l;
        double temp1;
        float temp2;

        for (i = 0; i < this.NBrsEff; i++) {
            k = 0;
            for (l = 0; l < Mat.GetLastIdxKol(); l++) {
                temp1 = Math.pow(this.GetElmt(i,0),l);
                temp2 = (float) temp1;
                Mat.SetElmt(k,l,temp2);
            }
            Mat.SetElmt(k,Mat.GetLastIdxKol() , this.GetElmt(i,1));
            k++;
        }

        return Mat;
    }
    
}

//Cara akses Interpolasi
//Interpolasi M1 = new Interpolasi(3,2);
//float x;
//x = M1.bacaInterpolasi();
//float y;
//y = M1.InterpolasiPolinom(x);
//System.out.println(y);

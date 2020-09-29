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

        System.out.println("Masukkan kombinasi titik: ");

        for (i = 0; i < this.NBrsEff; i++) {
            for (j = 0; j < this.NKolEff; j++) {
            	this.Matriks[i][j] = input.nextFloat();
            }
        }
		
		System.out.print("Masukkan nilai x yang akan ditaksir : ");
        float x = input.nextFloat();
        
      	// input.close();    
		
		return x;
	}

    float bacaFileInterpolasi(String namafile)
    {
        bacaFileMatriks(namafile);

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai x yang akan ditaksir : ");
        float x = input.nextFloat();
        
      	// input.close();
        
        return x;
    }

	void tulisInterpolasi(float x,float y, Interpolasi z)
	{
        int i,j;
        char variabel;

        System.out.println("Persamaan Polinom: ");
        for (i = 0; i <= z.GetLastIdxBrs(); i++) {
            variabel = 'a';
            for (j = 0; j < z.GetLastIdxKol(); j++) {
                if (j == z.GetLastIdxKol()-1) {
                    System.out.print(variabel);
                    variabel++;
                    System.out.print("*");
                    System.out.print(z.GetElmt(i,j));
                    System.out.print(" = ");
                }
                else if (j == 0) {
                    System.out.print(variabel);
                    variabel++;
                    System.out.print(" + ");
                }
                else {
                    System.out.print(variabel);
                    variabel++;
                    System.out.print("*");
                    System.out.print(z.GetElmt(i,j));
                    System.out.print(" + ");
                }
            }
            System.out.println(z.GetElmt(i,z.GetLastIdxKol()));
        }

        System.out.println(" ");

		System.out.print("Hasil Interpolasi dari ");
        System.out.print(x);
        System.out.print(" adalah: ");
        System.out.println(y);
	}

    void tulisFileInterpolasi(float x, float y, Interpolasi z, String namaFile)
    {
        String line;

        try {

            String namaFileDir = "./hasil/" + namaFile;
            FileWriter writeSPL = new FileWriter(namaFileDir);

            int i,j;
            char variabel;

            String persamaanPolinom = "Persamaan Polinom: \n";
            for (i = 0; i <= z.GetLastIdxBrs(); i++) {
                variabel = 'a';
                for (j = 0; j < z.GetLastIdxKol(); j++) {
                    if (j == z.GetLastIdxKol()-1) {
                        persamaanPolinom += variabel;
                        //System.out.print(variabel);
                        variabel++;
                        persamaanPolinom += '*';
                        //System.out.print("*");
                        persamaanPolinom += Float.toString(z.GetElmt(i,j));
                        //System.out.print(z.GetElmt(i,j));
                        persamaanPolinom += " = ";
                        //System.out.print(" = ");
                    }
                    else if (j == 0) {
                        persamaanPolinom += variabel;
                        //System.out.print(variabel);
                        variabel++;
                        persamaanPolinom += " + ";
                        //System.out.print(" + ");
                    }
                    else {
                        persamaanPolinom += variabel;
                        //System.out.print(variabel);
                        variabel++;
                        persamaanPolinom += "*";
                        //System.out.print("*");
                        persamaanPolinom += Float.toString(z.GetElmt(i,j));
                        //System.out.print(z.GetElmt(i,j));
                        persamaanPolinom += " + ";
                        //System.out.print(" + ");
                    }
                }
                persamaanPolinom += Float.toString(z.GetElmt(i,z.GetLastIdxKol()));
                //System.out.println(z.GetElmt(i,z.GetLastIdxKol()));
                persamaanPolinom += "\n";
            }

            line = persamaanPolinom + "\nHasil Interpolasi dari " + x + " adalah: " + y;

            writeSPL.write(line);
            writeSPL.close();
            System.out.println("Berhasil menyimpan hasil regresi pada folder hasil, file \"" + namaFile + "\".");

        } catch (IOException e) {
            System.err.println("Terjadi error.");
            e.printStackTrace();
        }
    }

    float InterpolasiPolinom(float x)
    //Melakukan proses interpolasi polinom dengan menggunakan metode eliminasi gauss dalam matriks augmented.
    {
        
        float y = 0;
        int j, pangkat;
        //Scanner inputs = new Scanner(System.in);



        Interpolasi augmented;
        augmented = this.ConvertToMatrixAug();

        int i, k;

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

    Interpolasi ConvertToMatrixAug()
    // I.S. terdapat ragam (xn,yn) dan nilai x yang akan ditaksir
    // F.S. terbentuk matriks yang akan siap untuk di eliminasi gauss jordan dan ditemukan solusinya
    {
        Interpolasi Mat;

        Mat = new Interpolasi(this.NBrsEff, this.NBrsEff+1);
        int pangkat = 0;
        int i,j;
        int k,l;
        double temp1;
        float temp2;

		k = 0;
        for (i = 0; i < this.NBrsEff; i++) {
            for (l = 0; l < Mat.GetLastIdxKol(); l++) {
                temp1 = Math.pow(this.GetElmt(i,0),l);
                temp2 = (float) temp1;
                Mat.SetElmt(k,l,temp2);
            }
            Mat.SetElmt(k,Mat.GetLastIdxKol() , this.GetElmt(i,1));
            k+=1;
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
//Interpolasi Interpolate;
//Interpolate = M1.ConvertToMatrixAug();
//System.out.println(y);

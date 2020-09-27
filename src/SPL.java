

public class SPL extends Matriks {
    /* ***** ATRIBUTE ***** */

    /** indeks solusi [0..NKol-1]
     * x1 x2 .. xn c
     * x1 berada pada indeks solusi[0]
     * x2 berada pada indeks solusi[1]
     * xn berada pada indeks solusi[NKol-1] */
    public float [] Solusi;
    
    /** Menyimpan string Persamaan (x1 = 2, x2 = a + 3 dll)
     * indeks [0..NKol-1]
     * x1 berada pada indeks Persamaan[0]
     * x2 berada pada indeks Persamaan[1]
     * xn berada pada indeks Persamaan[NKol-1] */
    public String [] Persamaan;

    /** Menyimpan status jenis variabel, apakah solusi eksak, solusi paramatik, atau dapat disubtitusikan
     * indeks [0..Nkol-1]
     * Jenis status :
     * 0 : undef,
     * 1 : solusi eksak,
     * 2 : solusi parametik,
     * 3 : solusi dapat disubtitusi */
    public int [] Status;


    /* ***** METHODS ***** */

    /* *** Konstruktor membentuk MATRIKS AUGMENTED SPL *** */
    SPL(int NBrsEff, int NKolEff) {
        super(NBrsEff, NKolEff);
    }

    /* *** KELOMPOK BACA/TULIS *** */
    /** Baca SPL Dari Terminal & Keyboard
     * I.S. Matriks Augmented Terdefinisi
     * F.S. Matriks Augmented Terisi nilai dari keyboard
     */
    void bacaSPL() {
        bacaMatriks();
        this.Solusi = new float [this.NKolEff-1];
    }

    /** Baca SPL Dari File
     * I.S. Matriks Augmented Terdefinisi
     * F.S. Matriks Augmented Terisi nilai dari keyboard
     */
    void bacaFileSPL(String namaFile) {
        bacaFileMatriks(namaFile);
        this.Solusi = new float [this.NKolEff-1];
    }

    /** Tulis SPL Ke Terminal
    * I.S. Matriks Augmented Terdefinisi dan berisi nilai
    * F.S. Matriks Augmented SPL ditulis pada terminal
    */
    void tulisSPL() {
        tulisMatriks();
    }

    /* *** KELOMPOK CEK JENIS SOLUSI ****/
    
    /** Mengembalikan jenis solusi SPL
     * I.S. Matriks Augmented Terdefinisi dan Telah dilakukan OBE
     * F.S. :
     * - Mengembalikan 0 jika solusi unik
     * - Mengembalikan 1 jika solusi banyak
     * - Mengembalikan -1 jika tidak ada solusi
    */
    int jenisSolusi() {
        int solusi = 0;
        int i; // Indeks Baris
        /* Cek Solusi Unik */
        if (isSegitigaSPL() && (this.GetLastIdxBrs()==(this.GetLastIdxKol()-1))) {
            solusi = 0;
        } else if (isSegitigaSPL() && (this.GetLastIdxBrs()!=(this.GetLastIdxKol()-1))) {
            solusi = 1;
        } else {
            i = this.GetLastIdxBrs();
            while (isRowZeroEx(i) && isLastElemtRowZero(i) && (i >= this.GetFirstIdxBrs())) {
                i--;
            }
            if (isRowZeroEx(i) && !isLastElemtRowZero(i)) {
                solusi = -1;
            } else {
                solusi = 1;
            }
        }
        return solusi;
    }

    /** Cek Matriks Segitiga Atas tanpa Kolom Terakhir
     * I.S. Matriks Augmented Terdefinisi dan Telah dilakukan OBE
     * F.S. Mengembalikan True jika merupakan Matriks Segitiga Atas, False jika bukan
     * 2 3 5 6
     * 0 3 5 9 -> True
     * 0 0 7 2
     */
    boolean isSegitigaSPL() {
        boolean segitigaAtas = true;
        int i = this.GetFirstIdxBrs();
        int j = this.GetLastIdxBrs();

        while (segitigaAtas && (i <= this.GetLastIdxBrs()) && (j <= this.GetLastIdxKol())) {
            // Cukup Cek Diagonal Utama
            if (this.GetElmt(i, j)==0) {
                segitigaAtas = false;
            } else {
                i++;
                j++;
            }
        }
        return segitigaAtas;
    }

    /** Cek Apakah Baris Terakhir (kecuali kolom terakhir) semua 0
     * I.S. Matriks Augmented Terdefinisi dan Telah dilakukan OBE
     * F.S. Mengembalikan True jika merupakan Baris Terakhir Augmented Matriks semua 0, False jika bukan
     */
    boolean isRowZeroEx(int i) {
        boolean lastRowZero = true;
        int j = this.GetFirstIdxKol();
        while (lastRowZero && (j<= (this.GetLastIdxKol()-1))) {
            if (this.GetElmt(i, j)!=0) {
                lastRowZero = false;
            } else {
                j++;
            }
        }
        return lastRowZero;
    }
    /** Cek Apakah Elemen Pada Baris dan Kolom Terakhir nol
     * I.S. Matriks Augmented Terdefinisi dan Telah dilakukan OBE
     * F.S. Mengembalikan True jika merupakan Elemen paling terakhir 0, False jika bukan
     */
    boolean isLastElemtRowZero(int i) {
        return (GetElmt(i, GetLastIdxKol()))==0;
    }

    /* *** KELOMPOK PENCARI SOLUSI METODE GAUSS *** */

    /** SOLUSI
     * I.S. Matriks Augmented Terdefinisi
     * F.S. Dihasilkan Solusi Unik yang dimasukkan ke dalam List solusi
     */
    void solveGauss() {
        if (this.jenisSolusi()==0) {
            this.solusiUnikGauss();
        } else if(this.jenisSolusi()==1) {
            this.solusiBanyakGauss();
        } else {
            System.out.println("Matriks tidak memiliki solusi");
            // this.Solusi = new float[0];
        }

    }

    /** SOLUSI UNIK 
     * I.S. Matriks Augmented Terdefinisi dan Berjenis Solusi Unik, Inisialisasi solusi dengan nilai 1
     * F.S. Dihasilkan Solusi Unik yang dimasukkan ke dalam List solusi
    */
    void solusiUnikGauss() {
        int i,j; // Indeks Baris dan Kolom
        float c;
        int k; // Indeks Solusi [0..GetLastIdxKol()-1]
        
        // for (int n = 0; n <= (this.GetLastIdxKol()-1); n++) {
        //     this.Solusi[k] = 1;
        // }

        // Back Subtitution
        for (i = this.GetLastIdxBrs(); i >= this.GetFirstIdxBrs(); i--) {
            j = GetFirstIdxKol();
            c = 0;

            // for (j = this.GetFirstIdxKol(); j <= (this.GetLastIdxKol()-1);j++) {
            //     if (j != k) {
            //         c += this.GetElmt(i, j) * this.Solusi[j];
            //     } 
            // }

            // Cari leading 1
            while (this.GetElmt(i, j)!=1 && j < GetLastIdxKol()) {
                j++;
            }
            k=j; // Set Indeks Solusi 
            j++; // Elemen setelah leading 1
            
            while (j< GetLastIdxKol()) {
                c += this.GetElmt(i, j) * this.Solusi[j];
                j ++;
            }
            
            this.Solusi[k] = this.GetElmt(i, this.GetLastIdxKol()) - c;
        }

    }

    void solusiBanyakGauss() {

    }
}
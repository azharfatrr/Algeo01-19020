

public class SPL extends Matriks {
    /* ***** ATRIBUTE ***** */
    public float [] Solusi;

    /* ***** METHODS ***** */

    /* *** Konstruktor membentuk MATRIKS AUGMENTED SPL *** */
    SPL(int NBrsEff, int NKolEff) {
        super(NBrsEff, NKolEff);
        this.Solusi = new float [this.NKolEff];
    }

    /* *** KELOMPOK BACA/TULIS *** */
    /** Baca SPL Dari Terminal & Keyboard
     * I.S. Matriks Augmented Terdefinisi
     * F.S. Matriks Augmented Terisi nilai dari keyboard
     */
    void bacaSPL() {
        bacaMatriks();
    }

    /** Baca SPL Dari File
     * I.S. Matriks Augmented Terdefinisi
     * F.S. Matriks Augmented Terisi nilai dari keyboard
     */
    void bacaFileSPL(String namaFile) {
        bacaFileMatriks(namaFile);
    }

    /** Tulis SPL Ke Terminal
    * I.S. Matriks Augmented Terdefinisi dan berisi nilai
    * F.S. Matriks Augmented SPL ditulis pada terminal
    */
    void tulisSPL() {
        tulisMatriks();
    }
}   
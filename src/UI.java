import java.io.File;

public class UI {
    public static void main(String[] args) {
        File data = new File("../src/data");
        getAllFiles(data);
    }

    public static void getAllFiles(File curDir) {
        File[] listFile = curDir.listFiles();
        for(File f : listFile){
            System.out.println(f.getName());
        }
    }


    // void MainMenu() {
            
    // }
}

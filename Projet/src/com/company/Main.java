import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;

public class Main {

    public static void main(String[] args) {
    	try{
    		File fichier = new File("./A.txt");
    		fichier.createNewFile();
    		FileWriter fw=new FileWriter(fichier);
    		fw.write("3\n0\n3\n1 2\n");
    		fw.close();
    	} catch (Exception e){}
    }
}

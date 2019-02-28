import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String file = "4\n" +
        "H 3 cat beach sun\n" +
        "V 2 selfie smile\n" +
        "V 2 garden selfie\n" +
        "H 2 garden cat";
        String[] ligne = file.split("\n");

        Parser p = new Parser();
        p.parse(file);
    	try{
    		File fichier = new File("./A.txt");
    		fichier.createNewFile();
    		FileWriter fw=new FileWriter(fichier);
    		fw.write("3\n0\n3\n1 2\n");
    		fw.close();
    	} catch (Exception e){}
    }
}

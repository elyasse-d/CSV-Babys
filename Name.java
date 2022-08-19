import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Name {
public void readfile(int year){
    String fname = "data/yob"+ year + ".txt";
    FileResource fr = new FileResource(fname);
    CSVParser parser = fr.getCSVParser(false);
    for(CSVRecord rec:parser){
        String name = rec.get(0);
        String gender = rec.get(1);
        System.out.println("Name : "+name+", Gander : "+gender + ", Number Of born"+
                                    rec.get(2));
    }
}
public void print(){
     FileResource fr = new FileResource();
     CSVParser parser = fr.getCSVParser(false);
    for(CSVRecord rec:parser){
        String name = rec.get(0);
        String gender = rec.get(1);
        System.out.println("Name : "+name+", Gander : "+gender + ", Number Of born : "+
                                    rec.get(2));
    }
}
  public void totalbirth(FileResource fr){
     int total =0;
     int totlb=0,totalf=0;
      for(CSVRecord rec : fr.getCSVParser(false)){
        int numborn = Integer.parseInt(rec.get(2));
        if(rec.get(1).equals("M")){totlb += numborn;}else{totalf+=numborn;}
        total += numborn;
    }
    System.out.println("Total of birth : "+total);
    System.out.println("Number Of boys: "+ totlb + " Total girld "+ totalf);
    }
    public void test(){
    FileResource fr = new FileResource();
    totalbirth(fr);
    
    }
}

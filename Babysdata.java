import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.io.File;
public class Babysdata {
    
    public int Rank(int year,String name, String gender){
       String fname = "data/yob"+ year + ".csv";
        FileResource fr = new FileResource(fname);
        //FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int rank=0;
        int co=0;
            for(CSVRecord rec:parser){    
             if(rec.get(1).equals(gender)){
                rank +=1;
                if(rec.get(0).equals(name)){
                    co=1;
                    break;
                    
                }
               }
           }
        
        if(co == 1){
        return rank;
        }else{return 999999;}
        
    }
        public String getName(int year,int ranke,String gender){
            String names="";
            String fname = "data/yob"+ year + ".csv";
            FileResource fr = new FileResource(fname);
            CSVParser parser = fr.getCSVParser(false);
            int counter =1;
            int ind=0;
            for(CSVRecord rec:parser){
                if(rec.get(1).equals(gender) ){
                    if(counter == ranke){
                    names = rec.get(0);
                    ind=1;
                    break;
                    }else{counter++;}
                    
                }
                
            }
            if(ind == 1){
            return names;}else{return "not found";}
        }
         public void whatIsNameInYear(String name, int year, int newyear,String gender){
             int Ranke = Rank(year,name,gender);
             String new_name=getName(newyear,Ranke,gender);
             System.out.println("The name :"+name+" is ranked "+Ranke+" It would be :"+new_name+" in :"+newyear);
            
            }
            public double getAverageRank(String name,String gender){
                DirectoryResource dr= new DirectoryResource();
                double total=0;
                double count=0;
                double averge=0;
                for(File f : dr.selectedFiles()){
                    //FileResource fr = new FileResource(f);
                    String file_name= f.getName();
                    String file_year=file_name.substring(3,7);
                    int file_years=Integer.parseInt(file_year);
                    total +=Rank(file_years,name,gender);
                    count++;
                }
                
                if(count != 0){
                  averge = total/count;
                }
                else{
                averge = 0;
                   }
                return averge;
            }
            public int getTotalBirthsRankedHigher(int year,String name, String gender){
                String fname = "data/yob"+ year + ".csv";
                FileResource fr = new FileResource(fname);
                CSVParser parser = fr.getCSVParser(false);
                int total=0;
                     for(CSVRecord rec:parser){    
                     if(rec.get(1).equals(gender)){
                         total  += Integer.parseInt(rec.get(2)); 
                            if(rec.get(0).equals(name)){
                               break;
                       }
                   }
                 }
                
                
                return total;
            }
                
                public void totalgender(int year, String gender){
                    String fname = "data/yob"+ year + ".csv";
                        FileResource fr = new FileResource(fname);
                        CSVParser parser = fr.getCSVParser(false);
                        int total=0;
                     for(CSVRecord rec:parser){    
                         if(rec.get(1).equals(gender)){
                         total  += Integer.parseInt(rec.get(2)); 
                            
                       }
                   
                     }
                     System.out.println("Totale number of "+gender+", is :"+total);
                }
                public void highestRank(String name,String gender){
                    DirectoryResource dr= new DirectoryResource();
                    int curr =0;
                    int rank=0;
                    for(File f : dr.selectedFiles()){
                           String file_name= f.getName();
                           String file_year=file_name.substring(3,7);
                           int file_years=Integer.parseInt(file_year);
                           rank=Rank(file_years,name,gender);
                           rank = maxof(rank,curr);
                           curr=rank;
                           
                    }
                    System.out.println("The largest rank is :"+ rank);
                
                }
                public int maxof(int cur,int newe){
                    int max=0;
                    if(cur > newe){
                        max=cur;
                    }else{
                     max =newe;}
                    return max;
                }
          public void test(){
        /*double a= Rank(1971,"Frank","M");
        String A = getName(1982,450,"M");
        double AB= getAverageRank("Robert","M");
        int AC = getTotalBirthsRankedHigher(1990,"Drew","F");*/
        totalgender(1900,"F");
        //System.out.println("Result Totale birth is :"+AC+", Rank :"+a+", GetName :"+A+", GetAvergRank :"+AB);
        //whatIsNameInYear("Owen",1974,2014,"F");
        //highestRank("Mich","M");
    }
}

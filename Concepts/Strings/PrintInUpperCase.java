
import java.io.BufferedReader;
import java.io.InputStreamReader;

// import for Scanner and other utility classes
import java.util.*;
import java.io.IOException;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class PrintInUpperCase {
    
    static char upperCase(char c){
        int diff=c-'a';
        if(diff>=0){
            return (char) (diff+'A');
        }
        else return c;
    }
    
    static void usingDelimiter(){
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // int t = Integer.parseInt(br.readLine());

    
        // while(t>0){

            String line = br.readLine();

            StringTokenizer tokens = new StringTokenizer(line,"\s+");

            while(tokens.hasMoreTokens()){

                System.out.println(tokens.nextToken().toUpperCase());
            }
            // t--;
     // }
        }
        catch(IOException e){

        }
        
    }

    static void usingCustom(){
        
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){

            String s = sc.next();
            
            for(int i=0; i<s.length(); i++){

                System.out.print(upperCase(s.charAt(i)));
            }

            System.out.println();
        }
        sc.close();
        
    }
    public static void main(String args[] ) throws Exception {

    usingCustom();
       

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class BufferReader_ReadArray extends Throwable{

    static void readArray(){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            Integer t = Integer.parseInt(br.readLine());
            // System.out.println(t);
            while(t > 0){
            
                String[] l1 =  br.readLine().split("\s");
                int size = Integer.parseInt(l1[0]);
                int rotation = Integer.parseInt(l1[1]);
                String values = br.readLine();
                int rot = size - rotation;
                String[] numbers = values.split("\s");

                StringBuilder result = new StringBuilder("");
                if( rot == 0 || rotation == 0){
                    System.out.print(values);
                }
                else if( rot > 0)
                {
                    for(int i = rot; i< size; i++){
                        result.append(numbers[i]).append(" ");
                    }
                    for(int i = 0; i< rot; i++){
                        result.append(numbers[i]).append(" ");
                    }
                    // Stream.of(numbers).skip(rot).forEach(n -> result.append(n).append(" "));
                    // Stream.of(numbers).limit(rot).forEach(n -> result.append(n).append(" "));
                }
                else{
                    rot = rotation % size;

                    if(rot == 0)
                    System.out.print(values);
                    else{
                        rot = size - rotation % size;
                            
                        for(int i = rot; i< size; i++){
                            result.append(numbers[i]).append(" ");
                        }
                        for(int i = 0; i< rot; i++){
                            result.append(numbers[i]).append(" ");
                        }
                        // Stream.of(numbers).skip(rot).forEach(n -> result.append(n).append(" "));
                        // Stream.of(numbers).limit(rot).forEach(n -> result.append(n).append(" "));
                    }
                }
                System.out.println(result.toString().trim());
               t--;
            }
        }
        catch(IOException e){

        }
                
    }

    public static void main(String[] args){

        readArray();

    }
}

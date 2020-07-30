import java.util.Arrays;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] ints = new int[]{10,20,30,40,90};
        System.out.println("Second biggest =" + Arrays.toString(ints) +" "+ app.findSecondBiggest(ints));
    }
    private Optional<Integer> findSecondBiggest(int[] ints){
        if(ints.length<2)
            return Optional.empty();
        int biggest = (ints[0]>ints[1]?ints[0]:ints[1]);
        int secondBiggest = (biggest ==ints[0])?ints[1]:ints[0];
        for (int i=2; i<ints.length;i++){
            if (ints[i]>biggest){
                secondBiggest = biggest;
                biggest = ints[i];
            }else{
                secondBiggest = ints[i];
            }
        }
        return Optional.of(secondBiggest);
    }
}

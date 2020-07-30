public class app {
    public static void main(String[] args) {
        app app = new app();
        int[] ints = {1,2,5,66,4,5,7,88,97,12,3,45,66};

    }
    private void print(int[] ints){
        for (int i:ints){
            if (i%5==0&& i%7==0){
                System.out.printf("%d HelloWorld",i);
            }else{
                if (i%5==0){
                    System.out.printf("%d Hello", i);
                }
                if (i%7==0){
                    System.out.printf("%d World",i);
                }
            }
        }
    }
}

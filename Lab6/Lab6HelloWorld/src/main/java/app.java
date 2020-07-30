public class app {
    public static void main(String[] args) {
        app app = new app();
        int[] ints = {1,2,5,35,66,4,5,7,88,97,12,3,45,66};
        app.print(ints);
    }
    private void print(int[] ints){
        for (int i:ints){
            if (i%5==0&& i%7==0){
                System.out.printf("%d HelloWorld\n",i);
            }else{
                if (i%5==0){
                    System.out.printf("%d Hello\n", i);
                }
                if (i%7==0){
                    System.out.printf("%d World\n",i);
                }
            }
        }
    }
}

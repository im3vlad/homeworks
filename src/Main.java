public class Main {
    public static void main(String[] args) {
        Pi.PiInterface sc = () -> Math.PI;
        System.out.println(sc.getPiValue());

}
}


package homework4;

public class Arrow {
    public static void main(String[] args) {
        String input = ">>-->-><<<><><>>--><--<<>>-->>><><--<<--<<>>>>----->>--><<---<<--<<<-<<>>-->>-->";
        String result = input.replaceAll("(>>-->)|(<--<<)", "");
        System.out.println((input.length()-result.length())/5);
    }
}

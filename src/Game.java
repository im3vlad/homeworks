import java.util.Objects;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        String vasya = "Вася";
        String petya = "Петя";
        String rock = "камень";
        String knife = "нож";
        String paper = "бумага";

        String [] game = {rock,knife,paper};
        int vasyaValue;
        int petyaValue;


        do {
            vasyaValue = new Random().nextInt(game.length);
            petyaValue = new Random().nextInt(game.length);
        if (Objects.equals(game[vasyaValue], rock) && Objects.equals(game[petyaValue], paper)) {
            System.out.println(petya + " Победил");
        }else if (Objects.equals(game[vasyaValue], knife) && Objects.equals(game[petyaValue], rock)) {
            System.out.println(petya + " Победил");
        }else if (Objects.equals(game[vasyaValue], knife) && Objects.equals(game[petyaValue], paper)) {
            System.out.println(vasya + " Победил");
        }else if (Objects.equals(game[vasyaValue], paper) && Objects.equals(game[petyaValue], rock)) {
            System.out.println(vasya + " Победил");
        }else if (Objects.equals(game[vasyaValue], paper) && Objects.equals(game[petyaValue], knife)) {
            System.out.println(petya + " Победил");
        }else if (Objects.equals(game[vasyaValue], rock) && Objects.equals(game[petyaValue], knife)) {
            System.out.println(vasya + " Победил");
    }
        } while (petyaValue == vasyaValue);





    }
}



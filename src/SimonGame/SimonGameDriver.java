/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimonGame;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Harshilkumar Vaghela(3116318)
 * @date October 28,2020(Assignment-2)
 */
public class SimonGameDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] a = {"red", "blue", "green", "yellow"};//for random color
        boolean k = true;
        Random r = new Random();
        ArrayList<String> game = new ArrayList<>();
        int score = 0;
        while (k) {
            game.addLast(a[r.nextInt(4)]);
            for (int i = 0; i < game.size(); i++) {
                System.out.print(game.get(i));

                pause(500);

                for (int j = 0; j < game.get(i).length(); j++) {
                    System.out.print("\b");//only does \b for the size of the string printed in the code above
                }
                pause(700);

            }
            String input = JOptionPane.showInputDialog("Enter answer").toLowerCase();
            String[] inputArray = input.split(" ");
            ArrayList<String> answer = new ArrayList<>();
            for (String l : inputArray) {
                answer.addLast(l);
            }
            if (!answer.equals(game)) {
                k = false;
            } else {
                score++;
            }
        }
        System.out.println("Game over, your score is " + score);

    }

    public static void pause(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}

package io.illcoder.casinoRoyale.core;

/**
 * Created by sstrauss on 9/23/15.
 * pause functions for user interface
 */


public class GameControl {



        /**
         * Pauses for 1/2 a second.
         */
        static public void pause () {
            try {
                Thread.sleep(500);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        /**
         * Pauses for
         * @param amountOfTime * 1000 to convert to milliseconds.
         */

    static public void pause(int amountOfTime) {
        amountOfTime *= 1000;
        try {
            Thread.sleep(amountOfTime);                 //1000 milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }


    }

}


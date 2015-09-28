//package test.illcoder.casinoRoyale;
//
//import io.illcoder.casinoRoyale.blackjack.BlackjackEngine;
//import io.illcoder.casinoRoyale.core.Player;
//import org.junit.Assert;
//import org.junit.Test;
//
//
///**
// * Created by sstrauss on 9/22/15.
// */
//public class BlackjackEngineTest {
//
//    BlackjackEngine blackjackEngine = new BlackjackEngine();
//    @Test
//    public void testsPause(){
//
//        System.out.println("check timer");
//
//
//        System.out.println("__________ .__                    __          ____.                 __     \n" +
//                "\\______   \\|  |  _____     ____  |  | __     |    |_____     ____  |  | __ \n" +
//                " |    |  _/|  |  \\__  \\  _/ ___\\ |  |/ /     |    |\\__  \\  _/ ___\\ |  |/ / \n" +
//                " |    |   \\|  |__ / __ \\_\\  \\___ |    <  /\\__|    | / __ \\_\\  \\___ |    <  \n" +
//                " |______  /|____/(____  / \\___  >|__|_ \\ \\________|(____  / \\___  >|__|_ \\ \n" +
//                "        \\/            \\/      \\/      \\/                \\/      \\/      \\/ ");
//
//
//        System.out.println("__________ .__                    __          ____.                 __     \n" +
//                "\\______   \\|  |  _____     ____  |  | __     |    |_____     ____  |  | __ \n" +
//                " |    |  _/|  |  \\__  \\  _/ ___\\ |  |/ /     |    |\\__  \\  _/ ___\\ |  |/ / \n" +
//                " |    |   \\|  |__ / __ \\_\\  \\___ |    <  /\\__|    | / __ \\_\\  \\___ |    <  \n" +
//                " |______  /|____/(____  / \\___  >|__|_ \\ \\________|(____  / \\___  >|__|_ \\ \n" +
//                "        \\/            \\/      \\/      \\/                \\/      \\/      \\/ ");
//
//    }
//
//    Player p1 = new Player("Sean");
//    @Test
//    public void testBlackJackConstructorWithPlayerInput(){
//
//
//        BlackjackEngine blackjackEngine = new BlackjackEngine(p1);
//        Assert.assertEquals("Should be the created Player at the beginning of the game", "Sean", p1.getName());
//
//    }
//
//    @Test
//    public void checkStayFunction(){
//        BlackjackEngine blackjackEngine = new BlackjackEngine(p1);
//        Assert.assertEquals("Should print message saying message", "You must think your lucky!", blackjackEngine.stay());
//    }
//
//
////    @Test
////    public void checkBlackJackPointConstrains(){
////        Assert.assertEquals("If score ever goes above 21, that player automatically loses.", "You lose", );
////    }
//
//    @Test
//    public void checkIfInputIsBeingTakenInAsInt(){
//        Assert.assertEquals("Should return the users wager as an int", 50, blackjackEngine.takeWager(p1));
//    }
//
//    @Test
//    public void testRunGameBlackJackLogic(){
//        blackjackEngine.runGame(p1);
//    }
//
//}
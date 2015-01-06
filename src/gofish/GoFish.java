/*
 Dan Poumakis
 CIS 141
 GoFish Card Game

 This game is player vs. computer

 Player will choose a card from their hand and ask the computer for that card
 if computer has it then he will give you it and you will have a pair. If not,
 computer will go fish. Computer will remember the cards you ask for and use them
 against you to provide somewhat of a challenge. Winner is determined by whoever
 runs out of cards in their hand first or whoever has the most pairs when the deck
 runs out of cards.
 */
package gofish;

public class GoFish
{

    public static void main(String[] args)
    {
        boolean noWinner = true;
        boolean userWins = false;
        boolean computerWins = false;

        Card askedCard;
        Card randomCard;

        Player user = new Player(7);
        Player computer = new Player(7);

        user.checkHandForPairs();
        computer.checkHandForPairs();

        while (Player.deck.getNumCardsLeft() > 1 && noWinner)
        {
            System.out.println("\nUSER'S TURN");
            askedCard = user.chooseCardFromHand();
            if (computer.hasCard(askedCard))
            {
                user.removeCard(askedCard);
                if (user.handIsEmpty())
                {
                    System.out.println("\nUSER WINS!");
                    userWins = true;
                    System.exit(0);
                }
            } else
            {
                System.out.println("No, go fish.");
                user.goFish();
                user.checkHandForPairs();
            }
            if (!userWins)
            {
                System.out.println("\nCOMPUTER'S TURN");
                randomCard = computer.randomCardFromHand();
                if (user.hasCard(randomCard))
                {
                    computer.removeCard(randomCard);
                    if (computer.handIsEmpty())
                    {
                        System.out.println("\nCOMPUTER WINS!");
                        computerWins = true;
                        System.exit(0);
                    }
                } else
                {
                    System.out.println("No, go fish.");
                    computer.goFish();
                    computer.checkHandForPairs();
                }
            }
            if (userWins || computerWins)
            {
                noWinner = false;
            }
        }
        if (noWinner)
        {
            if (user.getPairsFound() > computer.getPairsFound())
            {
                System.out.println("\nUSER WINS!");
            } else
            {
                System.out.println("\nCOMPUTER WINS!");
            }
        }
    }
}

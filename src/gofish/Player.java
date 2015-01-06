package gofish;

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{

    public static Deck deck = new Deck();
    public static ArrayList<Card> askedCards;

    private int pairsFound;

    private ArrayList<Card> hand;

    public Player(int numberOfCards)
    {
        hand = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++)
        {
            hand.add(deck.getTopCard());
        }
    }

    public int getPairsFound()
    {
        return pairsFound;
    }

    public int checkHandForPairs()
    {
        for (int i = 0; i < hand.size(); i++)
        {
            Card currentCard = hand.get(i);
            for (int j = 0; j < hand.size(); j++)
            {
                Card otherCard = hand.get(j);
                if (currentCard.faceEquals(otherCard) && j != i)
                {
                    hand.remove(currentCard);
                    hand.remove(otherCard);
                    pairsFound++;
                }
            }
        }
        return pairsFound;
    }

    public void printHand()
    {
        for (int i = 0; i < hand.size(); i++)
        {
            Card userCard = hand.get(i);
            System.out.println((i + 1) + " --> " + userCard.toString());
        }
    }

    public Card chooseCardFromHand()
    {
        askedCards = new ArrayList<>();
        int cardToChoose;
        Scanner keyboard = new Scanner(System.in);

        printHand();
        System.out.print("Which card would you like to choose? ");

        cardToChoose = keyboard.nextInt() - 1;
        while (cardToChoose > hand.size() - 1 && !hand.isEmpty())
        {
            System.out.print("Please enter a valid choice --> ");
            cardToChoose = keyboard.nextInt() - 1;
        }

        System.out.println("Computer, do you have --> " + hand.get(cardToChoose).getFaceString());

        askedCards.add(hand.get(cardToChoose));

        return hand.get(cardToChoose);
    }

    public void removeCard(int i)
    {
        hand.remove(i);
    }

    public void removeCard(Card other)
    {
        hand.remove(other);
    }

    public boolean hasCard(Card other)
    {
        boolean cardFound = false;

        for (int i = 0; i < hand.size(); i++)
        {
            Card currentCard = hand.get(i);

            if (currentCard.faceEquals(other))
            {
                System.out.println("Yes, I do have --> " + currentCard.getFaceString());
                this.removeCard(i);
                cardFound = true;
                break;
            }
        }
        return cardFound;
    }

    public boolean handIsEmpty()
    {
        return hand.isEmpty();
    }

    public void goFish()
    {
        hand.add(deck.getTopCard());
    }

    public Card randomCardFromHand()
    {
        /*
         This is to make the computer more intelligent
         Program will look through cards that user has asked for
         as if its remembering what the user is asking.
         */
        for (int i = 0; i < hand.size(); i++)
        {
            Card currentCard = hand.get(i);
            for (int j = 0; j < askedCards.size(); j++)
            {
                Card otherCard = askedCards.get(j);
                if (currentCard.faceEquals(otherCard))
                {
                    return currentCard;
                }
            }
        }
        /*
         If computer doesn't find match in cardsAsked then it will
         make a random choice
         */
        int randomInt = (int) (Math.random() * hand.size()) + 1;
        System.out.println("User, do you have --> " + hand.get(randomInt - 1).getFaceString());
        return hand.get(randomInt - 1);
    }

}

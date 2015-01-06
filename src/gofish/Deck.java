package gofish;

class Deck
{

    private Card[] cards;
    private int numCardsLeft;
    private Card topCard;

    public Deck()
    {

        numCardsLeft = 52;
        cards = new Card[numCardsLeft];

        int count = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int value = 1; value <= 13; value++)
            {
                cards[count] = new Card(value, suit);
                count++;
            }
        }
        shuffle();
    }

    public void shuffle()
    {
        int numOfSwaps = (int) (Math.random() * 100 + 25);
        for (int i = 0; i < numOfSwaps; i++)
        {
            swapRandom();
        }
        topCard = cards[numCardsLeft - 1];
    }

    private void swapRandom()
    {
        int a = (int) (Math.random() * 52);
        int b = (int) (Math.random() * 52);

        Card temp = cards[a];
        cards[a] = cards[b];
        cards[b] = temp;
    }

    public Card getTopCard()
    {
        Card oldTopCard;
        numCardsLeft--;
        oldTopCard = topCard;
        topCard = cards[numCardsLeft - 1];

        return oldTopCard;
    }

    public int getNumCardsLeft()
    {
        return numCardsLeft;
    }

    @Override
    public String toString()
    {
        String s = "Deck: \n";
        for (int i = 0; i < numCardsLeft; i++)
        {
            s = s + cards[i] + "\n";
        }
        return s;
    }
}

package gofish;

class Card
{

    public static final int CLUBS = 1;
    public static final int DIAMONDS = 2;
    public static final int HEARTS = 3;
    public static final int SPADES = 4;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 1;

    private int suit;
    private int face;

    public Card()
    {
        this.face = ACE;
        this.suit = SPADES;
    }

    public Card(int face, int suit)
    {
        this.face = face;
        this.suit = suit;
    }

    public boolean equals(Card other)
    {
        boolean suitMatched = (this.suit == other.getSuitValue());
        boolean faceMatched = (this.face == other.getFaceValue());
        boolean isEqual = (suitMatched && faceMatched);

        return isEqual;
    }

    public boolean faceEquals(Card other)
    {
        return this.face == other.getFaceValue();
    }

    public int getSuitValue()
    {
        return suit;
    }

    public int getFaceValue()
    {
        return face;
    }

    public void setSuit(int suit)
    {
        if (suit == CLUBS || suit == DIAMONDS || suit == HEARTS || suit == SPADES)
        {
            this.suit = suit;
        } else
        {
            //the input is invalid
        }
    }

    public void setFace(int face)
    {
        if (face >= 2 && face <= 10)
        {
            this.face = face;
        } else if (face == ACE || face == KING || face == QUEEN || face == JACK)
        {
            this.face = face;
        } else
        {
            //the input is invalid
        }
    }

    public String getSuitString()
    {
        String s = "";
        switch (suit)
        {
            case CLUBS:
                s = "Clubs";
                break;
            case DIAMONDS:
                s = "Diamonds";
                break;
            case HEARTS:
                s = "Hearts";
                break;
            case SPADES:
                s = "Spades";
                break;
            default:
                System.out.println("Something when wrong. This should never print");
                break;
        }
        return s;
    }

    public String getFaceString()
    {
        String f = "";
        switch (face)
        {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                f = face + "";
                break;
            case JACK:
                f = "Jack";
                break;
            case QUEEN:
                f = "Queen";
                break;
            case KING:
                f = "King";
                break;
            case ACE:
                f = "Ace";
                break;
            default:
                break;
        }
        return f;
    }

    @Override
    public String toString()
    {
        String s;
        s = getFaceString() + " of " + getSuitString();
        return s;
    }
}

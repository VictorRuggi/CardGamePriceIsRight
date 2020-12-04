public class Card
{
	private String name;
	private int value;

	public Card()
	{
	}

	/*Aces are wild*/
	public Card(String name)
	{
		this.name = name;
	}

	public Card(String name, int value)
	{
		this.name = name;
		this.value = value;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public int getValue()
	{
		return value;
	}
}
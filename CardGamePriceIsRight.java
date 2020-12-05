import javax.swing.*;
import java.util.*;

public class CardGamePriceIsRight
{
	public static void main(String[] args)
	{
		int range = (int)(Math.random() * 5) * 1000 + 1000; /*Range is between 1000 and 5000*/
		int carValue = (15000 + (int)(Math.random() * 8 * 1000)); /*Car Value is between [15000, 23000[ */
		int startValue = 15000;
		ArrayList<Card> cards = new ArrayList<Card>(52);
		cards.add(new Card("two", 2));
		cards.add(new Card("two", 2));
		cards.add(new Card("two", 2));
		cards.add(new Card("two", 2));
		cards.add(new Card("three", 3));
		cards.add(new Card("three", 3));
		cards.add(new Card("three", 3));
		cards.add(new Card("three", 3));
		cards.add(new Card("four", 4));
		cards.add(new Card("four", 4));
		cards.add(new Card("four", 4));
		cards.add(new Card("four", 4));
		cards.add(new Card("five", 5));
		cards.add(new Card("five", 5));
		cards.add(new Card("five", 5));
		cards.add(new Card("five", 5));
		cards.add(new Card("six", 6));
		cards.add(new Card("six", 6));
		cards.add(new Card("six", 6));
		cards.add(new Card("six", 6));
		cards.add(new Card("seven", 7));
		cards.add(new Card("seven", 7));
		cards.add(new Card("seven", 7));
		cards.add(new Card("seven", 7));
		cards.add(new Card("eight", 8));
		cards.add(new Card("eight", 8));
		cards.add(new Card("eight", 8));
		cards.add(new Card("eight", 8));
		cards.add(new Card("nine", 9));
		cards.add(new Card("nine", 9));
		cards.add(new Card("nine", 9));
		cards.add(new Card("nine", 9));
		cards.add(new Card("ten", 10));
		cards.add(new Card("ten", 10));
		cards.add(new Card("ten", 10));
		cards.add(new Card("ten", 10));
		cards.add(new Card("king", 10));
		cards.add(new Card("king", 10));
		cards.add(new Card("king", 10));
		cards.add(new Card("king", 10));
		cards.add(new Card("jack", 10));
		cards.add(new Card("jack", 10));
		cards.add(new Card("jack", 10));
		cards.add(new Card("jack", 10));
		cards.add(new Card("queen", 10));
		cards.add(new Card("queen", 10));
		cards.add(new Card("queen", 10));
		cards.add(new Card("queen", 10));
		cards.add(new Card("ace"));
		cards.add(new Card("ace"));
		cards.add(new Card("ace"));
		cards.add(new Card("ace"));

		Card card;
		int cardIndex;
		int moneyAdded;
		String aceInput; //If an ace is drawn
		String startValueStr = ""+startValue; //Start Value as String, Formatting Purposes
		String moneyAddedStr; //Money Added as String (for ace), Formatting Purposes

		String selection = JOptionPane.showInputDialog("The car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price" + "\nDo you want to stop? Press y or type yes to stop.");

		while(!(selection.equalsIgnoreCase("y") || selection.equalsIgnoreCase("yes")))
		{
			cardIndex = (int)(Math.random() * cards.size());
			card = cards.remove(cardIndex);

			if(card.getName().equals("ace")){
				/*Formatting Purposes*/
					aceInput = JOptionPane.showInputDialog("You drew an ace. Aces are wild. Input any value to add to the car price in between 0 to one less than the car price, or any five digit number that is larger than or equal to the current car price.\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
					moneyAdded = Integer.parseInt(aceInput);

					if(moneyAdded >= 0 && moneyAdded < startValue){
						startValue += moneyAdded;
						startValueStr = ""+startValue;

						if(moneyAdded >= 1000 && moneyAdded < startValue){
							moneyAddedStr = ""+moneyAdded;
							selection = JOptionPane.showInputDialog("You added $" + moneyAddedStr.substring(0, moneyAddedStr.length()-3) + "," + moneyAddedStr.substring(moneyAddedStr.length()-3, moneyAddedStr.length()) + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else if(moneyAdded >= 0 && moneyAdded < 1000){
							selection = JOptionPane.showInputDialog("You added $" + moneyAdded + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
					}
					else if(moneyAdded >= startValue && moneyAdded < 100000){
						startValue = moneyAdded;
						startValueStr = ""+startValue;
						selection = JOptionPane.showInputDialog("The car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
					}
					else {
						aceInput = JOptionPane.showInputDialog("Invalid input. Input any value to add to the car price in between 0 to 9999, or any five digit number that is larger than or equal to the current car price to end the game.\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
					}
			}
			else {
				switch(card.getName()){
					case "two":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "three":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "four":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "five":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "six":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "seven":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "nine":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "ten":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "king":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "queen":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					case "jack":{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew a " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
					default:{
						//Formatting Purposes
						if(startValue % 1000 == 0){
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew an " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						else {
							moneyAdded = (card.getValue() * 100);
							startValue += moneyAdded;
							startValueStr = ""+startValue;
							selection = JOptionPane.showInputDialog("You drew an " + card.getName() + ".\nThe car is currently worth: $" + startValueStr.substring(0, startValueStr.length()-3) + "," + startValueStr.substring(startValueStr.length()-3, startValueStr.length()) + "\nYou must be within $" + (range / 1000) + ",000 of the price.\nDo you want to stop? Press y or type yes to stop");
						}
						break;
					}
				}
			}
		}

		int lowRange = startValue;
		int hiRange = startValue + range;

		System.out.println("Your guess: " + startValue);
		System.out.println("The price must be between " + lowRange + " and " + hiRange);
		System.out.println("The price of the car is: " + carValue);

		if(carValue >= lowRange && carValue <= hiRange)
		{
			System.out.println("\n\nCongratulations, you just won a $" + carValue + " car!");
		}
		else
		{
			System.out.println("\n\nBetter luck next time");
		}
	}
}


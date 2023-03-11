package com.example;


public class Main 
{
//Arrays
	public Main()
	{
		Options optMenu = new Options();
	}

	public static void main(String[] args)
	{
		Main play = new Main();
	}
	
	//LINKS
	//GroupLayout Example:
	//https://www.cs.auckland.ac.nz/references/java/java1.5/tutorial/uiswing/layout/groupExample.html
	//GroupLayout API:
	//https://docs.oracle.com/javase/7/docs/api/javax/swing/GroupLayout.html#addLayoutComponent(java.lang.String,%20java.awt.Component)
	//GroupLayout Tutorial/Explained:
	//https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html

	//Crazy stuff that's happened while I've been working on this lol
	//Just making a list because some of it is cool or useful and
	//I'd like to remember.
    	//March 10: I had 20 easy box action listeners, and they were all copies of the one for c1. I was going through them all and using
			//ctrl + f to select each action listener and replace e1 with the next number. I got through about 8 of them, and I went to move
			//on to the next one, but it had already been finished? I checked the rest of the ones that I still had to do, and they'd all
			//been finished for me. Somehow VSC knew what I was doing and did it automatically. Thanks VSC lol.
		//March 11: I had gotten the clear button working in the custom challenge options menu, but I had to change some other stuff and
			//all of a sudden, the clear button stopped working. It would remove all the buttons, but it wouldn't take the challenges out
			//of the customChallenges ChalArrayBag. I troubleshooted for almost an hour before deciding I was going to make my own solution.
			//I half-assed a new method for the ChalArrayBag method that was called removeAll(), and just copy-pasted the constructor body's
			//code into it, hoping it would overwrite the data array with an empty one. Basically just restarting the array from scratch.
			//Miraculously, it worked lol. Need to remember to implement that method in my array bags from now on.
}

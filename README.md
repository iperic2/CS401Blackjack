# CS401Blackjack

Updated README:
This is a version of BlackJack, or "21" in which up to 6 players can play against each other in a game. Players will be able to create an account to track their money and winnings so if they decide to play later on, they will have the amount of money from the previous play time. [Note: We can begin with simulated, fake money, and then expand to real money that players can deposit. Then we can allow players to choose if they want to play with simulated or real money.]

Games and account management will occur on a website. [Expand to mobile app in the future]

Product Architecture (From SRS Doc:)
Card Object - makes card class objects, initialize a private integer, cardValue, and a private string variable, suit, and contains method for setting the values of the variables.
Deck Object - creates an array of 52 card objects, has a draw function to randomly pass out two cards to each player. 
Player Object – creates a player object that handles all user containers.
Money Object – Contain the Initial amount of chips for each user. Creates an accumulating money object for each user.
Rule Database – Contains all the rules of the game and decides which user wins.
Authentication Database - Prompts users to either create a new account or authenticate account, load previous money object if returning player or creates new player object.

Refer to SRS Requirements Document for detailed information on implementation.

-------------------------

Original Group README:

#Our group plan to create a gambling simulator using the game of blackjack as the only way to earning or losing money.
#In Our project we will use Object-Oriented Programming (OOP) for interactions between card objects, player objects, money objects, etc.
#We will need a system method to interact with the hand object to determine the winner, a dealer method to interact with the cards objects/list and randomly pass out two cards to the players.
#Lastly, we will create a method that will take in the amount of money objects and saves it in a variable that stores the total money amount. In terms of servers, we need to establish a credential method to verify users and fetch the correct money object/list.
#We also need that method to fetch the correct player object so it saves the user’s progress.

package tiktok.com;

import java.util.Scanner;

import tiktok.com.TicTacToe.Result;


public class Tik
{


public static void main(String[] args)
{
	



Scanner userInput = new Scanner(System.in);
String user1 = "Player X";
String user2 = "Player O";

TicTacToe game = new TicTacToe(user1, user2); 
while (game.winner() == Result.INCOMPLETE)
{
int r,c; 
boolean done = false; 

do 
{
game.printboard();

System.out.print(game.getCurPlayer()+"‘s turn.\n");
System.out.println(game.getCurPlayer()+", Enter row(0, 1, or 2)"); 
r = userInput.nextInt();

System.out.println(game.getCurPlayer()+", Enter column(0, 1, or 2)");
c = userInput.nextInt(); 



if (!game.inbounds(r,c))
System.out.println("Sorry, those are invalid entries.");
else
{
if (!game.Move(r,c))
System.out.println("Sorry, that square is taken.");
else
done = true; 
}
}
while (!done);

game.changeTurn(); 
}

game.printboard(); 
Result win = game.winner(); 
if (win == Result.DRAW)
System.out.println("The game is a draw!");

else
{
System.out.print(game.whoWon(win)+" has won the game!");
}
}
}
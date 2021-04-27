# hexChess
A chess game set on a hexagonal grid!

![Game board with one side's pieces set up](board.png?raw=true "Title")

The pieces of this game: 
  - Pawns (plain hexagons): can move forwards (up-left and up-right) but only capture horizontally (left and right)
  - Bishops (hexagon with small circle inside): can move in an X shape, infinite distance
  - Knights (hexagon with N inside): can jump to any of the 6 surrounding hexes of the same color
  - King (hexagon with a K inside): can move 1 hex in any direction
  - Queen (hexagon with a Q inside): can move in any direction infinitely
  
Currently, the game board drawing is set up, and I have to make the game logic implemented. I will also implement multiplayer by encoding a "move" as a string (similar to chess move notation) that players can send to each other to synchronize their games (this could also integrate with a chat client that would provide the message sending functionality built in to the game)

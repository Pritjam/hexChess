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

5/21/2021

Game logic is somewhat implemented! Pieces can move and capture. The game will check for move validity and let you know if something is wrong (hopefully without crashing). Currently there is no turn enforcement or win checking. To run the game, just compile all of the files and then run Main. I'll make an executable jar with the next release.

MOVE NOTATION

The notation for moves is pretty simple. Each move is a 4 character string, made of 2 coordinates--source and destination. Coordinates are in the QR form, where the Q axis runs from left to right, a to i. The R coordinates run from bottom-left to top-right, from 1 to 9. This means that the black knights are at a1, c1, and e1 (from left to right) and the blue bishops are at e8 and h8 (left and right).

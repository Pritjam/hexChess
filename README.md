# hexChess
A chess game set on a hexagonal grid!

![Game board with one side's pieces set up](board.png?raw=true "Title")

The pieces of this game: 
  - Pawns (plain hexagons): can move forwards (up-left and up-right) but only capture horizontally (left and right)
  - Bishops (hexagon with small circle inside): can move in an X shape, infinite distance
  - Knights (hexagon with N inside): can jump to any of the 6 surrounding hexes of the same color
  - King (hexagon with a K inside): can move 1 hex in any direction
  - Queen (hexagon with a Q inside): can move in any direction infinitely

MOVE NOTATION

The notation for moves is pretty simple. Each move is a 4 character string, made of 2 coordinates--source and destination. Coordinates are in the QR form, where the Q axis runs from left to right, a to i. The R coordinates run from bottom-left to top-right, from 1 to 9. This means that the black knights are at a1, c1, and e1 (from left to right) and the blue bishops are at e8 and h8 (left and right).

You can also mark a tile by typing "mark qr" with qr being the qr coordinates of the tile, as well as "clear qr" to unmark the tile.

Take turns typing in moves until a king is captured, at which point the game closes.

# Chess-Project---M1-MIAGE
## Overall project

Analyze chess games :
- Display score evolution of any game : replay the game with a classic PGN player and see below the pre-calculated score evolution.
- Games ranking according the overall score evolution (Sum of the score fluctuations).
- Detect blunder mates in some games.
- Sort by player's ELO in games.
- Visualize the position when blunder mate is detected.
- Bigger score evolution from a position (Visible considered position).

##Analysis
###Global
* Overall ranking of the 5 best players.

* Overall ranking of the 5 best game by global score.

* Databases statistics : 
    - Number of games
    - Number of players	
    - Number of events

###Players

- Winrate percentage
- Number of errors (blunder mates)


###Games
Table with 
- Game's date
- Event
- White Player
- Black Player
- Opening used
- Result at the end

For each game
- Score's fluctuation
- Replay the game in the PGN player

###Openings

Table with 
- Opening's name
- Linked moves
- Number of moves

For each opening
- Replay the opening in the PGN player
- Opening's winrate (Black, White, Deuce)

###Score's evolution from a considered position

- Best score's evolutions from a position

##Technologies : 
- datatables.js : JavaScript plugin managing JSON data in HTML tables.
- highcharts.js : JavaScript plugin building charts from JSON data. 
- chessboard.js : is a standalone JavaScript Chess Board.
- JSON : (JavaScript Object Notation), open standard format to transmit data objects consisting of attribute–value pairs.
- JAVA : Programming language that is concurrent, class-based, object-oriented.
- HTML : HyperText Markup Language is the standard markup language used to create web pages.
- CSS : Cascading Style Sheets (CSS) is a style sheet language used for describing the presentation of a document written in a markup language.
- Javascript : is a high-level, dynamic, untyped, and interpreted programming language.
- mySQL : is an open-source relational database management system 
- JUnit 4 : is a unit testing framework for the Java programming language. 

##Java development structure :
Packages
- objet : MODEL
- json : traitement JSON
- database : data extraction from the database
- analysis : data analysis
- run : main program
- tools : tool classes
- unitTest : unit test

##Licences

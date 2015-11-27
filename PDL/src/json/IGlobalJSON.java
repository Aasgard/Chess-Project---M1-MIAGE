package json;

public interface IGlobalJSON {
	public final String PATH = "JSONContainer/";
	
	public final String GAME_FILE = "Game.json";
	public final String OPENING_FILE = "Opening.json";
	public final String PLAYER_FILE = "Player.json";	
	public final String RANKINGPOSITION_FILE = "RankingPosition.json";
	
	public final String ID = "id";

	
	//CONSTANTE GAME
	public final String ID_WHITE = "id_white";
	public final String ID_BLACK = "id_black";
	public final String PGN = "pgn";
	public final String EVOL_SCORE_MOVE = "evol_score_move";
	public final String MOVE_AVERAGE = "move_average";
	public final String DATE = "date";
	public final String SCORE_TOTAL_VAR	= "score_total_variation";
	public final String ID_OPENING = "id_opening";
	public final String SCORES = "scores";
	public final String NUMBER_MOVE = "number_move";
	public final String SCORE = "score";
	public final String FEN = "fen";
	
	//CONSTANTE PLAYER
	public final String NAME = "name";
	public final String ERRORS = "errors";
	public final String IDGAME = "idGame";
	public final String NB_OF_ERROR = "nb_of_error";
	public final String ERROR_FEN = "error_fen";
	public final String NB_GAME_PLAYED = "nb_games_played";
	public final String NB_GAME_WIN = "nb_games_win";
	
	//CONSTANTE OPENING
	public final String NAME_OPENING = "name_opening";
	
}

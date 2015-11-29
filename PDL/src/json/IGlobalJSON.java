package json;

public interface IGlobalJSON {
	public final String PATH = "JSONContainer/";
	
	public final String GAME_FILE = "Game.json";
	public final String OPENING_FILE = "Opening.json";
	public final String PLAYER_FILE = "Player.json";	
	public final String RANKINGPOSITION_FILE = "RankingPosition.json";
	public final String GLOBALSTAT_FILE = "statsBDD.json";
	public final String GLOBALBESTPLAYER_FILE = "bestPlayers.json";
	public final String GLOBALBESTGAME_FILE = "bestGames.json";
	
	//Constante de GAME/Player/Opening
	public final String ID = "id";
	
	//Constante de Player/Opening
	public final String NAME = "name";
	
	//CONSTANTE de Player/RankingPosition
	public final String ID_GAME = "id_game";
	
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
	public final String ERRORS = "errors";
	public final String NB_OF_ERROR = "nb_of_error";
	public final String ERROR_FEN = "error_fen";
	public final String NB_GAME_PLAYED = "nb_games_played";
	public final String NB_GAME_WIN = "nb_games_win";
	
	//CONSTANTE OPENING
	public final String NAME_OPENING = "name_opening";
	public final String NB_MOVES = "nb_moves";
	public final String MOVES = "moves";
	public final String WIN = "win";
	public final String DATA = "data";
	public final String Y = "Y";
	public final String COLOR = "color";
	
	//CONSTANTE RANKINGPOSITION
	public final String INIT_FEN = "init_fen";
	public final String CLASSEMENT = "classement";
	public final String PLAYER_NAME = "player_name";
	public final String BEST_FEN = "best_fen";
	public final String EVOL_SCORE_GLOBAL = "evol_score_global";
	
	//Constantes GlobalStats
	public final String GLOBAL_STATS = "global_stats";
	public final String LIBELLE = "libelle";
	public final String VALEUR = "valeur";
	public final String NB_PLAYERS = "Nombre de joueurs";
	public final String NB_GAMES = "Nombre de games";
	public final String NB_EVENT = "Nombre d'evenements";
	
	public final String BEST_PLAYERS = "best_players";
	public final String RANG_PLAYER = "rang";
	
	
	public final String BEST_GAMES = "best_games";
	public final String RANG_GAME = "rang";
	public final String EVENT = "evenement";
	public final String DATE_GAME = "date";
	public final String SCORE_GLOBAL = "score_global";
	
}

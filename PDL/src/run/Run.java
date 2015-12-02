package run;

import java.util.List;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import analysis.Analysis;
import object.*;
import tests.StopWatch;
import tools.Folder;
import tools.SFTP;

public class Run {

	
	public static void main(String[] args) throws JSchException, SftpException {
		
		/* Initialisation du chronom�tre */
		StopWatch sw = new StopWatch();
		
		Analysis anal = new Analysis();
		
		Folder jsoncontainer = new Folder("JSONContainer");
		
		//SFTP sftp = new SFTP("gesticompte", "sarzeau56370", "109.8.192.56", 22);
	
		@SuppressWarnings("unused")
		List<Game> alGames = anal.getGames();
		
		/* G�n�ration des fichiers JSON de la Homepage */
		anal.globalStats();
		anal.analyzePlayers();
		anal.analyzeScoreGame();
		anal.globalBestGame();
		anal.analyzeOpenings();
		anal.analyzeScoreEvolutionFromPosition();
		//anal.bestPlayers();
		//anal.bestGames();
		
		/* Transfert des fichiers g�n�r�s sur le serveur Web distant */
		//sftp.transferFolder(jsoncontainer, "/var/www/gesticompte.fr/json");
		//sftp.transferFile("JSONContainer/bestGames.json", "/var/www/gesticompte.fr/json");
		//sftp.transferFile("JSONContainer/statsBDD.json", "/var/www/gesticompte.fr/json");
		//sftp.transferFile("JSONContainer/statsBDD.json", "/var/www/gesticompte.fr/json");
		//sftp.transferFile("JSONContainer/statsBDD.json", "/var/www/gesticompte.fr/json");
		
		System.out.println("Temps mis : " + sw.elapsedTime() + " secondes.");
		System.out.println("Fichiers transf�r�s. D�connexion du serveur SFTP ...");
		//sftp.closeConnection();
		System.out.println("SFTP termin�. Script d'analyse termin�.");
		
		jsoncontainer.printFolder();
		
		System.out.println("Temps mis : " + sw.elapsedTime() + " secondes.");
	}

}

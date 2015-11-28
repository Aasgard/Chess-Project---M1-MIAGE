package run;

import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import analysis.Analysis;
import object.*;
import tests.StopWatch;
import tools.SFTP;

public class Run {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws JSchException, SftpException {
		
		StopWatch sw = new StopWatch();
		
		Analysis anal = new Analysis();
		SFTP sftp = new SFTP("gesticompte", "sarzeau56370", "109.8.192.56", 22);
		/*JSch jsch = new JSch();
		Session session =  jsch.getSession("gesticompte", "109.8.192.56", 22);
		session.setPassword("sarzeau56370");
		jsch.setConfig("StrictHostKeyChecking", "no");
		session.connect();
		System.out.println("Connexion établie");
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp c = (ChannelSftp) channel;*/
	
		List<Game> alGames = anal.getGames();
		
		/* Génération des fichiers JSON de la Homepage */
		anal.globalStats();
		//anal.bestPlayers();
		//anal.bestGames();
		
		/* Transfert des fichiers générés sur le serveur Web distant */
		sftp.transferFile("JSONContainer/statsBDD.json", "/var/www/gesticompte.fr/json");
		//sftp.transferFile("JSONContainer/statsBDD.json", "/var/www/gesticompte.fr/json");
		//sftp.transferFile("JSONContainer/statsBDD.json", "/var/www/gesticompte.fr/json");
		//sftp.transferFile("JSONContainer/statsBDD.json", "/var/www/gesticompte.fr/json");
		
		System.out.println("Temps mis : " + sw.elapsedTime() + " secondes.");
		System.out.println("Fichiers transférés. Déconnexion du serveur SFTP ...");
		sftp.closeConnection();
		System.out.println("SFTP terminé. Script d'analyse terminé.");
		
		
		System.out.println("Temps mis : " + sw.elapsedTime() + " secondes.");
	}

}

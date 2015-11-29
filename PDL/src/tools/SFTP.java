package tools;

import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTP extends JSch {

	private String username;
	private Session session = null;
	private String mdp;
	private String serveurIP;
	private int port;
	private Channel chan = null;
	private ChannelSftp chansftp = null;
	
	@SuppressWarnings("static-access")
	public SFTP(String username, String mdp, String serveurIP, int port) {
		this.username = username;
		this.mdp = mdp;
		this.serveurIP = serveurIP;
		this.port = port;
		
		try {
			this.session = this.getSession(this.username, this.serveurIP, this.port);
			this.session.setPassword(this.mdp);
			this.setConfig("StrictHostKeyChecking", "no");
			this.session.connect();
			System.out.println("Connexion établie au serveur SFTP " + this.serveurIP + " sur le port " + this.port);
			
			this.chan = this.session.openChannel("sftp");
			this.chan.connect();
			this.chansftp = (ChannelSftp) this.chan;
		} catch (JSchException e){
			e.printStackTrace();
		}
	}
	
	public void transferFile(String filePath, String landPath){
		try {
			this.chansftp.put(filePath,landPath);
			System.out.println("Fichier courant [" + filePath + "] transféré avec succès. Destination : [" + landPath + "]");
		} catch (SftpException e) {
			e.printStackTrace();
		}
	}
	
	public void transferFolder(Folder f, String landPath){
		List<String> alFilesName = f.getFilesName();
		
		for (String name : alFilesName) {
			this.transferFile(name, landPath);
		}
	}
	
	public void closeConnection(){
		this.chansftp.disconnect();
		this.chan.disconnect();
		this.session.disconnect();
		System.out.println("Connexion SFTP au serveur " + this.serveurIP + " terminée. [Toutes les connexions ont été fermées].");
	}
	
	
	
}

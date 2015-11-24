package tests;

import java.io.File;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class TestFTP {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws JSchException, SftpException {
		
		JSch jsch = new JSch();
		Session session =  jsch.getSession("gesticompte", "109.8.192.56", 22);
		session.setPassword("sarzeau56370");
		jsch.setConfig("StrictHostKeyChecking", "no");
		session.connect();
		System.out.println("Connexion établie");
		
		Channel channel = session.openChannel("sftp");
		channel.connect();
		ChannelSftp c = (ChannelSftp) channel;
		c.put("text.txt","/var/www/PDL/");
		
	}

}

package gr.shmmy.ntua.dms.utils;

import java.io.File;

import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.digester.Digester;
import org.apache.log4j.Logger;

public class Utils {

	private static final Logger log = Logger.getLogger(Utils.class);

	public static boolean fileAlreadyExists(String fileStorePath,
			String fileName) {

		log.info("Checking if file - " + fileName + " exists in "
				+ fileStorePath + " directory.");
		File dir = new File(fileStorePath);

		if (dir != null) {
			File[] filesInDir = dir.listFiles();
			for (int i = 0; i < filesInDir.length; i++) {

				if (fileName.equals(filesInDir[i].getName())) {
					return true;
				}
			}
		}

		return false;
	}
	
	public static String hash(String password){
		return DigestUtils.sha1Hex(password);
	}
}

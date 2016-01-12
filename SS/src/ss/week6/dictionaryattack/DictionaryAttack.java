package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<String, String>();
	private Map<String, String> hashDictionary = new HashMap<String, String>();

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws IOException 
	 */
	public void readPasswords(String filename) throws IOException {
		File file = new File(filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String text = null;
		while ((text = reader.readLine()) != null) {
			String[] unpa = text.split(": ");
			passwordMap.put(unpa[0], unpa[1]);
		}
		reader.close();



	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytesOfMessage = password.getBytes();
			return new String(Hex.encodeHex(md.digest(bytesOfMessage)));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Checks the password for the user in the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		if (passwordMap.containsKey(user)) {
			return getPasswordHash(password).equals(passwordMap.get(user));
		}
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
	 * the original password.
	 * @param filename filename of the dictionary.
	 * @throws IOException 
	 */
	public void addToHashDictionary(String filename) throws IOException {
		File file = new File(filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String text = null;
		while ((text = reader.readLine()) != null) {
			hashDictionary.put(getPasswordHash(text), text);
		}
		reader.close();
	}
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		Map<String, String> result = new HashMap<String, String>();
		for (String user : passwordMap.keySet()) {
			if (hashDictionary.containsKey(passwordMap.get(user))) {
				result.put(user, hashDictionary.get(passwordMap.get(user)));
			}
		}
		System.out.println(result.size());
		System.out.println(passwordMap.size());
		System.out.println(result);
	}
	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();
		da.readPasswords("C:\\Users\\Sander\\git\\SoftwareSystems\\"
    				+ "SS\\src\\ss\\week6\\test\\LeakedPasswords.txt");
		da.addToHashDictionary("C:\\Users\\Sander\\git\\SoftwareSystems\\"
						+ "SS\\src\\ss\\week6\\test\\commonpasses.txt");
		da.doDictionaryAttack();
	}

}

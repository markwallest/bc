package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

public class Block {
	private int index;
	private Date timeStamp;
	private ArrayList<Transaction> transactions;
	private int nonce;
	private String hash;
	private String previousBlockHash;
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	public int getNonce() {
		return nonce;
	}
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	
	public static String hashBlock(String previousBlockHash, String currentBlockData, int nonce) {
		String dataAsString = previousBlockHash  + currentBlockData + String.valueOf(nonce);
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		}
		byte[] encodedhash = digest.digest(dataAsString.getBytes(StandardCharsets.UTF_8));
		String hash = bytesToHex(encodedhash);
		
		return hash;
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public int MineBlock() {
		int nonce = 0;
		String hash = hashBlock(this.previousBlockHash, this.toString(), nonce);
		while(!hash.substring(0, 4).equals("0000")) {
			nonce++;
			hash = hashBlock(this.previousBlockHash, this.toString(), nonce);
			System.out.println(hash);
		}
		return nonce;
	}

	@Override
	public String toString() {
		return "Block [index=" + index + ", timeStamp=" + timeStamp + ", transactions=" + transactions + ", nonce="
				+ nonce + ", hash=" + hash + ", previousBlockHash=" + previousBlockHash + "]";
	}
	
	
	
	
	

}

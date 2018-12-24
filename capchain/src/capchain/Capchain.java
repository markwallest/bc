package capchain;

import java.util.Date;

import model.Block;
import model.Blockchain;

public class Capchain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Blockchain bc = new Blockchain();
        Block lastBlock = bc.getLatestBlock();
        Block newBlock = new Block();
        newBlock.setIndex(1);
        newBlock.setNonce(4);
        newBlock.setHash(Block.hashBlock(lastBlock.getHash(), newBlock.toString(), 0));
        newBlock.setPreviousBlockHash(lastBlock.getHash());
        newBlock.setTimeStamp(new Date());
        newBlock.setTransactions(null);
        bc.addBlock(newBlock);
	}

}

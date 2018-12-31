package model;

import java.util.ArrayList;
import java.util.Date;

public class Blockchain {
	private ArrayList<Block> blockChain;

	public Blockchain() {
		this.blockChain = new ArrayList<>();
		Block genesysBlock = new Block();
		genesysBlock.setIndex(0);
		genesysBlock.setNonce(0);
		genesysBlock.setPreviousBlockHash(null);
		genesysBlock.setTimeStamp(new Date());
//		genesysBlock.setHash(Block.hashBlock(null,  genesysBlock.toString(), 4));
		this.blockChain.add(genesysBlock);
		System.out.println("blockchain : "+ this.blockChain);
		
		
	}

	public ArrayList<Block> getBlockChain() {
		return blockChain;
	}

	public void setBlockChain(ArrayList<Block> blockChain) {
		this.blockChain = blockChain;
	}
	
	public void addBlock(Block b) {
		b.MineBlock();
		this.blockChain.add(b);
	}
	
	public Block getLatestBlock() {
		return this.blockChain.get(this.blockChain.size() - 1);
	}
	
	
}

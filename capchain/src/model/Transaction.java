package model;

public class Transaction {
	private Long amount;
	private String sender;
	private String recipient;
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", sender=" + sender + ", recipient=" + recipient + "]";
	}
//	
	
	

}

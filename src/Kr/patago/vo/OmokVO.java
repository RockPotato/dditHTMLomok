package Kr.patago.vo;

public class OmokVO {
	private String pan;
	private String pan_order;
	private String history;
	private String winner;
	
	private String i;
	private String j;
	
	public String getI() {
		return i;
	}
	public void setI(String i) {
		this.i = i;
	}
	public String getJ() {
		return j;
	}
	public void setJ(String j) {
		this.j = j;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPan_order() {
		return pan_order;
	}
	public void setPan_order(String pan_order) {
		this.pan_order = pan_order;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	@Override
	public String toString() {
		return "OmokVO ["
				+ (pan != null ? "pan=" + pan + ", " : "")
				+ (pan_order != null ? "pan_order=" + pan_order + ", " : "")
				+ (history != null ? "history=" + history + ", " : "")
				+ (winner != null ? "winner=" + winner + ", " : "")
				+ (getPan() != null ? "getPan()=" + getPan() + ", " : "")
				+ (getPan_order() != null ? "getPan_order()=" + getPan_order()
						+ ", " : "")
				+ (getHistory() != null ? "getHistory()=" + getHistory() + ", "
						: "")
				+ (getWinner() != null ? "getWinner()=" + getWinner() + ", "
						: "")
				+ (getClass() != null ? "getClass()=" + getClass() + ", " : "")
				+ "hashCode()="
				+ hashCode()
				+ ", "
				+ (super.toString() != null ? "toString()=" + super.toString()
						: "") + "]";
	}
	
	
	
}

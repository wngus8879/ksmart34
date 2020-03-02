package kr.or.ksmart.springboot34_mybatis.domain;

public class Goods {
	private String gCode;
	private String mId;
	private String gName;
	private String gCate;
	private String gPrice;
	private String gColor;
	private String gSize;
	private String gDate;
	private String gDesc;
	
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getgDate() {
		return gDate;
	}
	public void setgDate(String gDate) {
		this.gDate = gDate;
	}
	public String getgCode() {
		return gCode;
	}
	public void setgCode(String gCode) {
		this.gCode = gCode;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgCate() {
		return gCate;
	}
	public void setgCate(String gCate) {
		this.gCate = gCate;
	}
	public String getgPrice() {
		return gPrice;
	}
	public void setgPrice(String gPrice) {
		this.gPrice = gPrice;
	}
	public String getgColor() {
		return gColor;
	}
	public void setgColor(String gColor) {
		this.gColor = gColor;
	}
	public String getgSize() {
		return gSize;
	}
	public void setgSize(String gSize) {
		this.gSize = gSize;
	}
	public String getgDesc() {
		return gDesc;
	}
	public void setgDesc(String gDesc) {
		this.gDesc = gDesc;
	}
	
	@Override
	public String toString() {
		return "Goods [gCode=" + gCode + ", mId=" + mId + ", gName=" + gName + ", gCate=" + gCate + ", gPrice=" + gPrice
				+ ", gColor=" + gColor + ", gSize=" + gSize + ", gDate=" + gDate + ", gDesc=" + gDesc + "]";
	}

	
	
}

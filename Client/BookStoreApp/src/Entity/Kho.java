package Entity;

public class Kho {
	private String maSach;
	private int tongSoLuong;
	private int tonKho;
	
	public Kho(String maSach, int tongSoLuong, int tonKho) {
		super();
		this.maSach = maSach;
		this.tongSoLuong = tongSoLuong;
		this.tonKho = tonKho;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public int getTongSoLuong() {
		return tongSoLuong;
	}
	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}
	public int getTonKho() {
		return tonKho;
	}
	public void setTonKho(int tonKho) {
		this.tonKho = tonKho;
	}
	
}

package Entity;

public class ChiTietHoaDon {
	private String maHoaDon;
	private String maSach;
	private int soLuong;
	
	public ChiTietHoaDon(String maHoaDon, String maSach, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maSach = maSach;
		this.soLuong = soLuong;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}

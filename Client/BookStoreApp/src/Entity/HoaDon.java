package Entity;

public class HoaDon {
	private String maHoaDon;
	private String tenKhachHang;
	private String ngayLap;
	private double tongTien;
	
	public HoaDon(String maHoaDon, String tenKhachHang, String ngayLap, double tongTien) {
		super();
		this.maHoaDon = maHoaDon;
		this.tenKhachHang = tenKhachHang;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
	
}

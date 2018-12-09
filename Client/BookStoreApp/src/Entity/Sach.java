package Entity;

public class Sach {
	private String maSach;
	private String tenSach;
	private String maLoaiSach;
	private int giaMua;
	private String moTa;
	
	public Sach(String maSach, String tenSach, String maLoaiSach, int giaMua, String moTa) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.maLoaiSach = maLoaiSach;
		this.giaMua = giaMua;
		this.moTa = moTa;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getMaLoaiSach() {
		return maLoaiSach;
	}
	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}
	public int getGiaMua() {
		return giaMua;
	}
	public void setGiaMua(int giaMua) {
		this.giaMua = giaMua;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}

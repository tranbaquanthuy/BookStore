package Entity;

public class TacGia {
	private String maTacGia;
	private String tenTacGia;
	private String namSinh;
	private String queQuan;
	
	public TacGia(String maTacGia, String tenTacGia, String namSinh, String queQuan) {
		super();
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
		this.namSinh = namSinh;
		this.queQuan = queQuan;
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public String getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	
}

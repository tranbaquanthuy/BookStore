package Entity;

public class TaiKhoan {
	private String username;
	private String pass;
	private String name;
	private int id;
	private String chucVu;
	
	public TaiKhoan(String username, String pass, String name, int id, String chucVu) {
		super();
		this.username = username;
		this.pass = pass;
		this.name = name;
		this.id = id;
		this.chucVu = chucVu;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	
}

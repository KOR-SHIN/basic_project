package project;

public class MemberVO {

	/*
	 * <데이터베이스 해당 테이블 컬럼 조회 QUERY> SELECT 'private String' || lower(column_name)
	 * || ';' FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'MEMBER'
	 */

	private String mem_id;
	private String mem_pass;
	private String mem_name;
	private String mem_regno1;
	private String mem_regno2;
	private String mem_add1;
	private String mem_add2;
	private String mem_hp;
	private String mem_mail;
	private String mem_job;
	private String mem_mileage;
	private String mem_delete;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_regno1() {
		return mem_regno1;
	}

	public void setMem_regno1(String mem_regno1) {
		this.mem_regno1 = mem_regno1;
	}

	public String getMem_regno2() {
		return mem_regno2;
	}

	public void setMem_regno2(String mem_regno2) {
		this.mem_regno2 = mem_regno2;
	}

	public String getMem_add1() {
		return mem_add1;
	}

	public void setMem_add1(String mem_add1) {
		this.mem_add1 = mem_add1;
	}

	public String getMem_add2() {
		return mem_add2;
	}

	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}

	public String getMem_hp() {
		return mem_hp;
	}

	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}

	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

	public String getMem_job() {
		return mem_job;
	}

	public void setMem_job(String mem_job) {
		this.mem_job = mem_job;
	}

	public String getMem_mileage() {
		return mem_mileage;
	}

	public void setMem_mileage(String mem_mileage) {
		this.mem_mileage = mem_mileage;
	}

	public String getMem_delete() {
		return mem_delete;
	}

	public void setMem_delete(String mem_delete) {
		this.mem_delete = mem_delete;
	}

}

package model.dto;

public class ReplyDto {
	private String rp_num;
	private String rp_id;
	private String rp_text;
	private String rp_ori;
	private String rp_time;

	public ReplyDto() {
	}

	
	public ReplyDto(String rp_text) {
		this.rp_text = rp_text;
	}


	public ReplyDto(String rp_id, String rp_text, String rp_ori) {
		this.rp_id = rp_id;
		this.rp_text = rp_text;
		this.rp_ori = rp_ori;
	}


	public ReplyDto(String rp_id, String rp_text, String rp_ori, String rp_time) {
		this.rp_id = rp_id;
		this.rp_text = rp_text;
		this.rp_ori = rp_ori;
		this.rp_time = rp_time;
	}
	

	public String getRp_num() {
		return rp_num;
	}

	public void setRp_num(String rp_num) {
		this.rp_num = rp_num;
	}

	public String getRp_id() {
		return rp_id;
	}

	public void setRp_id(String rp_id) {
		this.rp_id = rp_id;
	}

	public String getRp_text() {
		return rp_text;
	}

	public void setRp_text(String rp_text) {
		this.rp_text = rp_text;
	}

	public String getRp_ori() {
		return rp_ori;
	}

	public void setRp_ori(String rp_ori) {
		this.rp_ori = rp_ori;
	}

	public String getRp_time() {
		return rp_time;
	}

	public void setRp_time(String rp_time) {
		this.rp_time = rp_time;
	}

}

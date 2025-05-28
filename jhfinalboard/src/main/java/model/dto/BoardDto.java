package model.dto;

public class BoardDto {
	private String num;
	private String title;
	private String content;
	private String creator;
	private String time;
	private String hit;
	private String rp_count;
	private String category;
	
	
	public BoardDto() {}
	
	public BoardDto(String title, String content, String category) {
		this.title = title;
		this.content = content;
		this.category = category;
	}

	public BoardDto(String title, String content, String creator, String category) {
		this.title = title;
		this.content = content;
		this.creator = creator;
		this.category = category;
	}

	public BoardDto(String num, String title, String content, String creator, String time, String hit,
			String rp_count) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.creator = creator;
		this.time = time;
		this.hit = hit;
		this.rp_count = rp_count;
	}

	public BoardDto(String num, String title, String content, String creator, String time, String hit, String rp_count,
			String category) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.creator = creator;
		this.time = time;
		this.hit = hit;
		this.rp_count = rp_count;
		this.category = category;
	}

	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getRp_count() {
		return rp_count;
	}

	public void setRp_count(String rp_count) {
		this.rp_count = rp_count;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}

package com.example.tools;

/**
 * @author baimi
 *时间和数据的实体类
 */
public class DataText {
	private String date;
	private String text;

	public DataText(String date,String text) {
		super();
		this.date = date;
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}

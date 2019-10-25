package com.kuaisuji.po;

public class Account {
	
	private Integer account_id;
	private Integer user_id;
	private Integer account_type;
	private Integer account_item;
	private String account_amount;
	private String account_date;
	private String account_remark;
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getAccount_type() {
		return account_type;
	}
	public void setAccount_type(Integer account_type) {
		this.account_type = account_type;
	}
	public Integer getAccount_item() {
		return account_item;
	}
	public void setAccount_item(Integer account_item) {
		this.account_item = account_item;
	}
	public String getAccount_amount() {
		return account_amount;
	}
	public void setAccount_amount(String account_amount) {
		this.account_amount = account_amount;
	}
	public String getAccount_date() {
		return account_date;
	}
	public void setAccount_date(String account_date) {
		this.account_date = account_date;
	}
	public String getAccount_remark() {
		return account_remark;
	}
	public void setAccount_remark(String account_remark) {
		this.account_remark = account_remark;
	}
	@Override
	public String toString() {
		return "Accounts [account_id=" + account_id + ", user_id=" + user_id + ", account_type=" + account_type
				+ ", account_item=" + account_item + ", account_amount=" + account_amount + ", account_date="
				+ account_date + ", account_remark=" + account_remark + "]";
	}
}

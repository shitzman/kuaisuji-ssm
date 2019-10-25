package com.kuaisuji.po;

public class Type {

	private Integer account_type;
	private Integer account_item;
	private String account_item_name;
	private String item_img_src;
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
	public String getAccount_item_name() {
		return account_item_name;
	}
	public void setAccount_item_name(String account_item_name) {
		this.account_item_name = account_item_name;
	}
	public String getItem_img_src() {
		return item_img_src;
	}
	public void setItem_img_src(String item_img_src) {
		this.item_img_src = item_img_src;
	}
	@Override
	public String toString() {
		return "Type [account_type=" + account_type + ", account_item=" + account_item + ", account_item_name="
				+ account_item_name + ", item_img_src=" + item_img_src + "]";
	}
	
	
}

package com.spider.bean;

import java.io.Serializable;
import java.util.Date;

public class MongoBaseEntity implements Serializable {

	private static final long serialVersionUID = 1545432455788963126L;
	private String id;
	private Date addTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}

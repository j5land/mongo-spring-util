package com.spider.bean;

import java.util.Calendar;
import java.util.Date;

public class JobBatchDetailInfo extends MongoBaseEntity {

	private static final long serialVersionUID = -2572170837760880403L;

	private String batchNo; // 批次号
	private Date processOverTime; // 处理结束时间
	private Long processCostTime; // 消耗时间
	private String processText; // 处理内容
	private String status; // 状态 process处理中，over处理结束

	public JobBatchDetailInfo() {
	}

	public JobBatchDetailInfo(String batchNo, String processText) {
		this.batchNo = batchNo;
		this.processText = processText;
		this.status = JobContent.STATUS_PROCESS;
		this.setAddTime(Calendar.getInstance().getTime());
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getProcessOverTime() {
		return processOverTime;
	}

	public void setProcessOverTime(Date processOverTime) {
		this.processOverTime = processOverTime;
	}

	public Long getProcessCostTime() {
		return processCostTime;
	}

	public void setProcessCostTime(Long processCostTime) {
		this.processCostTime = processCostTime;
	}

	public String getProcessText() {
		return processText;
	}

	public void setProcessText(String processText) {
		this.processText = processText;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

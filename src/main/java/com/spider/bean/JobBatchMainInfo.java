package com.spider.bean;

import java.util.Calendar;
import java.util.Date;

public class JobBatchMainInfo extends MongoBaseEntity {

	private static final long serialVersionUID = -4617698540714372511L;
	private String batchNo; //批次号
	private Date lastProcessTime; // 最后条记录处理时间
	private Long totalCostTime; // 总共处理时间
	private Long totalCount; // 总处理记录数
	private Long processCount; // 已经处理总数
	private String status;
	private String name;	//批次名
	
	public JobBatchMainInfo(){}
	public JobBatchMainInfo(String batchNo, Long totalCount, String name) {
		this.batchNo = batchNo;
		this.totalCount = totalCount;
		this.status = JobContent.STATUS_NEW;
		this.setAddTime(Calendar.getInstance().getTime());
	}

	public Date getLastProcessTime() {
		return lastProcessTime;
	}

	public void setLastProcessTime(Date lastProcessTime) {
		this.lastProcessTime = lastProcessTime;
	}

	public Long getTotalCostTime() {
		return totalCostTime;
	}

	public void setTotalCostTime(Long totalCostTime) {
		this.totalCostTime = totalCostTime;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getProcessCount() {
		return processCount;
	}

	public void setProcessCount(Long processCount) {
		this.processCount = processCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

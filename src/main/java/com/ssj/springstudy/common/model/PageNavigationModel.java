package com.ssj.springstudy.common.model;

public class PageNavigationModel {
	private int pageStartNumber;
	private int pageEndNumber;
	private int totalPageCount;
	private int nowPageNumber;
	private int totalRecodeCount;


	public int getTotalRecodeCount() {
		return totalRecodeCount;
	}

	public void setTotalRecodeCount(int totalRecodeCount) {
		this.totalRecodeCount = totalRecodeCount;
	}

	public int getPageStartNumber() {
		return pageStartNumber;
	}

	public void setPageStartNumber(int pageStartNumber) {
		this.pageStartNumber = pageStartNumber;
	}

	public int getPageEndNumber() {
		return pageEndNumber;
	}

	public void setPageEndNumber(int pageEndNumber) {
		this.pageEndNumber = pageEndNumber;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getNowPageNumber() {
		return nowPageNumber;
	}

	public void setNowPageNumber(int nowPageNumber) {
		this.nowPageNumber = nowPageNumber;
	}

	@Override
	public String toString() {
		return "PageNavigationModel{" +
				"pageStartNumber=" + pageStartNumber +
				", pageEndNumber=" + pageEndNumber +
				", totalPageCount=" + totalPageCount +
				", nowPageNumber=" + nowPageNumber +
				", totalRecodeCount=" + totalRecodeCount +
				'}';
	}
}

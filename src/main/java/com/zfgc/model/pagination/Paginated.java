package com.zfgc.model.pagination;

import com.zfgc.model.BaseZfgcModel;

public abstract class Paginated extends BaseZfgcModel{

	private Integer numberOfPages;
	private Integer totalItems;
	
	@Override
	public String getHMAC() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
}

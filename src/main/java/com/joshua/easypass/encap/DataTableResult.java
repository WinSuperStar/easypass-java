package com.joshua.easypass.encap;

import java.io.Serializable;
import java.util.List;

public class DataTableResult<T> implements Serializable {

	private static final long serialVersionUID = -8068185077058204802L;
	
	private Integer draw;
	
	private Long recordsTotal;

	private List<T> data;
	
	private Long recordsFiltered;
	
	private String error;

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}

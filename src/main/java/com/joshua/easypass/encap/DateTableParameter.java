package com.joshua.easypass.encap;

import java.io.Serializable;

public class DateTableParameter implements Serializable {

	private static final long serialVersionUID = -1110611663513288526L;
	
	private Integer draw;
    private Integer start;//
    private Integer length;
    
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
    
	
	public int currentPageIndex() {
		if(start ==null || start == 0) {
			return 0;
		}else {
			return start/length;
		}
	}
	
    
}

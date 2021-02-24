package com.mypham.paging;

import com.mypham.sorter.Sorter;

public class PageRequest implements Pageble 
{
	private Long page;
	private Long maxPageItem;
	private Sorter sorter;
	public PageRequest(Long page , Long maxPageItem , Sorter sorter)
	{
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}
	@Override
	public Long getPage() 
	{
		return this.page;
	}

	@Override
	public Long getLimit() {
		return this.maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		if (this.sorter!=null)
			return this.sorter;
		return null;
	}

	@Override
	public Long getOffset() {
		if (this.maxPageItem!=null)
			return (this.page-1) * this.maxPageItem;
		return null;
	}
}

package com.mypham.paging;

import com.mypham.sorter.Sorter;

public interface Pageble 
{
	Long getPage();
	Long getLimit();
	Sorter getSorter();
	Long getOffset();
}

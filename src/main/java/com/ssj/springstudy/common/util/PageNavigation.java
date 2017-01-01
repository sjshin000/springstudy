package com.ssj.springstudy.common.util;

import com.ssj.springstudy.common.model.PageNavigationModel;
import org.springframework.util.StringUtils;

/**
 * Created by sjshin on 2017-01-01.
 */
public class PageNavigation {

   	public static PageNavigationModel pageNavigation(int pagingCount, int listCount, int nowPageNumber) {
        System.err.println("===========>>>>" + " : "+  pagingCount + " : "+ listCount + " : "+ nowPageNumber);

        PageNavigationModel pageNavigationModel = new PageNavigationModel();
        if(nowPageNumber == 0 || StringUtils.isEmpty(nowPageNumber)) {
            nowPageNumber = 1;
        } else {
        pageNavigationModel.setNowPageNumber(nowPageNumber);
        }

        if(StringUtils.isEmpty(pagingCount) || (StringUtils.isEmpty(listCount))) {
            //exception 처리
            return null;
        }

            //1페이지면 271~277  // 2페이지면 261~270 // 토탈페이지가 1->28, 2->27, 3-> 26
            //totalPage - nowPage = 27+1,

//        int pageStartNumber = (nowPageNumber *  pagingCount) - (pagingCount - 1);  //현재페지는 2 페이징처리20 이면 1: 1~20, 2: 21~40
//        int pageEndNumber = (nowPageNumber *  pagingCount) > listCount ? listCount : (nowPageNumber *  pagingCount);

        int totalPageCount = (listCount / pagingCount) + 1;
        int pageStartNumber = (totalPageCount - nowPageNumber) * pagingCount + 1;
        int pageMaxNumber = (totalPageCount - nowPageNumber) * pagingCount + pagingCount;
        int pageEndNumber = pageMaxNumber > listCount ? listCount : pageMaxNumber;

        pageNavigationModel.setPageStartNumber(pageStartNumber);
        pageNavigationModel.setPageEndNumber(pageEndNumber);
        pageNavigationModel.setTotalPageCount(totalPageCount);
        pageNavigationModel.setTotalRecodeCount(listCount);

		return pageNavigationModel;
	}
}

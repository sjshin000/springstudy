package com.ssj.springstudy.common.util;

import com.ssj.springstudy.common.model.PageNavigationModel;
import org.junit.Test;

/**
 * Created by sjshin on 2017-01-01.
 */
public class PageNavigationTest {

    @Test
    public void pageNavigationTest() {
        PageNavigation pageNavigation = new PageNavigation();
        int pagingCount = 10;
        int listCount = 277;
        int nowPageNumber = 2;
        PageNavigationModel pageNavigationModel = pageNavigation.pageNavigation(pagingCount, listCount, nowPageNumber);
        System.out.println(pageNavigationModel.toString());

        //1페이지면 271~277  // 2페이지면 261~270 // 토탈페이지가 1->28, 2->27, 3-> 26
        //totalPage - nowPage = 27+1,
    }
}

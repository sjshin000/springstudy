package com.ssj.springstudy.common.model;

import java.util.List;

/**
 * Created by sjshin on 2017-01-01.
 */
public class ParentBoard<T> {
    private PageNavigationModel pageNavigationModel;
    private List<T> boardList;

    public PageNavigationModel getPageNavigationModel() {
        return pageNavigationModel;
    }

    public void setPageNavigationModel(PageNavigationModel pageNavigationModel) {
        this.pageNavigationModel = pageNavigationModel;
    }

    public List<T> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<T> boardList) {
        this.boardList = boardList;
    }

    @Override
    public String toString() {
        return "ParentBoard{" +
                "pageNavigationModel=" + pageNavigationModel +
                ", boardList=" + boardList +
                '}';
    }
}

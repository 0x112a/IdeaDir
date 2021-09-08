package com.intoan.note.util;

import lombok.Data;

import java.util.List;

@Data
public class PageUtil<T> {

    //curently page number
    private Integer pageNumber;

    // every page display number
    private Integer pageSize;

    private long totalCount;

    private Integer totalPages;

    private Integer prePage;

    private Integer nextPage;

    private Integer startNavPage;

    private Integer endNavPage;

    private List<T> dataList;

    public PageUtil(Integer pageNumber,Integer pageSize,long totalCount){

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        //Todo
        // this.totalPages = (int)Math.ceil(totalCount/pageSize);
        // 转换成浮点型并向上取整
        this.totalPages = (int)Math.ceil(totalCount/( pageSize * 1.0));

        this.prePage = pageNumber - 1 > 0 ? pageNumber -1 : 1;

        this.nextPage = pageNumber + 1 > totalPages ? totalPages : pageNumber + 1;

        this.startNavPage = pageNumber - 5;
        this.endNavPage = pageNumber + 4;

        if (this.startNavPage < 1) {
            this.startNavPage = 1;

            this.endNavPage = this.startNavPage + 9 > this.totalPages ? this.totalPages : this.startNavPage + 9;
        }

        if (this.endNavPage > this.totalPages){
            this.endNavPage = this.totalPages;

            this.startNavPage =  this.endNavPage - 9 < 1 ? 1: this.endNavPage -9;
        }

    }


}

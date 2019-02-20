package com.qfedu.service;

import com.qfedu.domain.Recode;
import com.qfedu.vo.PageVo;
import com.qfedu.vo.ResultVo;

/**
 *@Author feri
 *@Date Created in 2019/2/19 09:56
 */
public interface RecodeService {
    //新增
    ResultVo save(Recode recode);
    ResultVo queryById(int id);
    ResultVo queryLike(String msg);
    PageVo<Recode> queryPage(int page,int size);


}

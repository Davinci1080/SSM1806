package com.qfedu.service.impl;

import com.qfedu.dao.RecodeDao;
import com.qfedu.domain.Recode;
import com.qfedu.service.RecodeService;
import com.qfedu.util.ResultUtil;
import com.qfedu.vo.PageVo;
import com.qfedu.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/2/19 10:27
 */
@Service
public class RecodeServiceImpl implements RecodeService {
    @Autowired
    private RecodeDao recodeDao;
    @Override
    public ResultVo save(Recode recode) {
        return ResultUtil.exec(recodeDao.save(recode)>0,"新增记录",null);
    }

    @Override
    public ResultVo queryById(int id) {
        Recode recode=recodeDao.queryById(id);
        return ResultUtil.exec(recode!=null,"查询详细",recode);
    }

    @Override
    public ResultVo queryLike(String msg) {
        msg='%'+msg+'%';
        return ResultUtil.exec(true,"",recodeDao.queryByLike(msg));
    }

    @Override
    public PageVo<Recode> queryPage(int page, int size) {
        return ResultUtil.exec(page,size,recodeDao.queryCount(),recodeDao.queryByPage((page-1)*size,size));
    }
}

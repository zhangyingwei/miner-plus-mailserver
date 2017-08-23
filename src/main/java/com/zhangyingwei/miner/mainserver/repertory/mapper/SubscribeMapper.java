package com.zhangyingwei.miner.mainserver.repertory.mapper;

import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
public interface SubscribeMapper {
    @Select("select * from mp_subscribe where flag=#{flag}")
    List<Subscribe> listSubscribesByFlag(@Param("flag") Integer flag) throws Exception;
}

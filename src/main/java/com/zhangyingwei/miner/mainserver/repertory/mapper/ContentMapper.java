package com.zhangyingwei.miner.mainserver.repertory.mapper;

import com.zhangyingwei.miner.mainserver.repertory.model.Content;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
public interface ContentMapper {
    @Select("select id,author,sitename,site,url,title,pubdate,getdate,topic,state from mp_content where getdate like #{showday} and state=#{state} and topic in ${topics}")
    List<Content> listContentsByStateAndTopic(@Param("state") Integer state,@Param("topics") String topics,@Param("showday") String showDay) throws Exception;
}

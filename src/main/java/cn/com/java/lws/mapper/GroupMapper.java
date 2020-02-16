package cn.com.java.lws.mapper;

import cn.com.java.lws.model.Group;
import java.util.List;

/**
 * 
 * @author 群组Mapper代理对象
 *
 */
public interface GroupMapper extends BaseMapper<Group> {

	//根据uid查询多个结果 
	List<Group> queryManyByUid(Integer uid) throws Exception;
	
}

package cn.com.java.lws.service.impl;

import cn.com.java.lws.model.BiGroup;
import cn.com.java.lws.model.Group;
import cn.com.java.lws.model.User;
import cn.com.java.lws.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author djin
 *   用户业务层对象
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	//初始化好友信息
	@Override
	public Map<String, Object> initFriend(User user) throws Exception {
		//根据uid查询对应好友分组数据
		List<Group> groups = groupMapper.queryManyByUid(user.getId());
		//根据uid查询对应的群信息
		List<BiGroup> biGroups = biGroupMapper.queryManyByOtherId(user.getId());
		//声明装好友列表的list集合
		List<Map<String,Object>> friendLit = new ArrayList<Map<String, Object>>();
		//总的数据集合
		Map<String,Object> data = new HashMap<>();
		//遍历好友分组集合 根据分组id封装好友数据
		for (int i=0;i<groups.size();i++){
			Map<String, Object> friendMap = new HashMap<String, Object>();
			friendMap.put("groupname",groups.get(i).getGname());
			friendMap.put("id",groups.get(i).getGid());
			friendMap.put("list",userMapper.queryManyByUidAndGid(user.getId(),groups.get(i).getGid()));
			friendLit.add(friendMap);
		}
		//根据json数据类型封装数据
		data.put("mine",user);
		data.put("friend",friendLit);
		data.put("group",biGroups);
		map.put("code", 0);
		map.put("msg", "数据加载成功");
		map.put("data", data);
		return map;
	}
}

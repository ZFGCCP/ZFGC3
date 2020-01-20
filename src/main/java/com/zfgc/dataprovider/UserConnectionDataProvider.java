package com.zfgc.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zfgc.dao.UserConnectionDao;
import com.zfgc.dbobj.UserConnectionDbObj;
import com.zfgc.dbobj.UserConnectionDbObjExample;
import com.zfgc.exception.ZfgcNotFoundException;
import com.zfgc.model.users.UserConnection;
import com.zfgc.model.users.Users;

@Component
public class UserConnectionDataProvider extends AbstractDataProvider {

	@Autowired
	UserConnectionDao userConnectionDao;
	
	public UserConnection getUserConnection(Integer userConnectionId){
		UserConnectionDbObjExample ex = userConnectionDao.getExample();
		ex.createCriteria().andUserConnectionIdEqualTo(userConnectionId);
		
		List<UserConnectionDbObj> connections = userConnectionDao.get(ex);
		
		if(connections.size() == 0){
			throw new ZfgcNotFoundException("userConnectionId: " + userConnectionId);
		}
		
		return mapper.map(connections.get(0), UserConnection.class);
	}
	
	public List<UserConnection> getUserConnectionByUser(Integer usersId){
		UserConnectionDbObjExample ex = userConnectionDao.getExample();
		ex.createCriteria().andUsersIdEqualTo(usersId);
		
		List<UserConnectionDbObj> connections = userConnectionDao.get(ex);
		List<UserConnection> result = new ArrayList<>();
		
		for(UserConnectionDbObj dbObj : connections){
			result.add(mapper.map(dbObj, UserConnection.class));
		}
		
		return result;
	}
	
	public UserConnection getUserConnectionBySessionId(String sessionId){
		UserConnectionDbObjExample ex = userConnectionDao.getExample();
		ex.createCriteria().andSessionIdEqualTo(sessionId);
		
		List<UserConnection> result = new ArrayList<>();
		
		if(result.size() > 0) {
			return mapper.map(result.get(0), UserConnection.class);
		}

		throw new ZfgcNotFoundException(sessionId);
	}
	
	public void insertNewConnection(UserConnection connection){
		userConnectionDao.updateOrInsert(connection);
	}
	
	public UserConnection getUserConnectionTemplate(Users user){
		UserConnection connection = new UserConnection();
		
		connection.setUsersId(user.getUsersId());
		connection.setIpAddressId(user.getPrimaryIpAddress().getIpAddressId());
		connection.setUserConnectionId(-1);
		
		return connection;
	}
	
	public void deleteUserConnection(String sessionId) {
		UserConnectionDbObjExample ex = userConnectionDao.getExample();
		ex.createCriteria().andSessionIdEqualTo(sessionId);
		
		userConnectionDao.deleteByExample(null, ex);
	}
	
	public void deleteAllUserConnections(){
		UserConnectionDbObjExample ex = userConnectionDao.getExample();
		userConnectionDao.deleteByExample(null, ex);
	}
}

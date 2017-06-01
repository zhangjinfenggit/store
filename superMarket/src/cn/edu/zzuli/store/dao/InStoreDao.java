package cn.edu.zzuli.store.dao;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import cn.edu.zzuli.dao.BaseDao;
import cn.edu.zzuli.store.vo.InStore;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年5月31日上午8:17:51 TODO
 */
public class InStoreDao extends BaseDao {

	public List<InStore> findAll() {

		String sql = "select * from inStore";

		return queryBeanList(InStore.class, sql);
	}

	public List<InStore> getInStoreByCondition(String did, String joinTime) {

		String sql = "select * from InStore ";

		if ((!StringUtils.isNullOrEmpty(did)) || (!StringUtils.isNullOrEmpty(joinTime))) {
			sql += " where  did like '%" + did + "%' and joinTime like '%" + joinTime + "%'";
		}

		return queryBeanList(InStore.class, sql);
	}

	public void saveInStore(InStore InStore) {

		String sql = "insert into InStore (oid,did,wareName,joinTime,weight,remark) values(?,?,?,?,?,?)";

		update(sql, InStore.getOid(), InStore.getDid(), InStore.getWareName(), InStore.getJoinTime(),
				InStore.getWeight(), InStore.getRemark());

	}

	public InStore getInStoreById(String id) {

		String sql = "select * from inStore where id = ?";

		return queryBean(InStore.class, sql, id);
	}

	public void updateInStore(InStore InStore) {

		String sql = "update inStore set oid = ?,did=?,wareName=?,joinTime=?,weight=?,remark=? where id = ?";

		update(sql, InStore.getOid(), InStore.getDid(), InStore.getWareName(), InStore.getJoinTime(),
				InStore.getWeight(), InStore.getRemark(), InStore.getId());

	}

	public void deleteInStoreById(String id) {

		String sql = "delete from InStore where id = ?";
		update(sql, id);
	}

	public void pushInStore(String id) {

		String sql = "update InStore set status = 1 where id = ?";
		update(sql, id);

	}

}

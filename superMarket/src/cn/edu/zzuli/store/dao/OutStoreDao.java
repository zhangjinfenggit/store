package cn.edu.zzuli.store.dao;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import cn.edu.zzuli.dao.BaseDao;
import cn.edu.zzuli.store.vo.OutStore;

/**
 * 
 * @author zhangjinfeng
 * @date 2017年6月1日下午3:18:28 TODO
 */
public class OutStoreDao extends BaseDao {

	public List<OutStore> findAll() {

		String sql = "select * from OutStore";

		return queryBeanList(OutStore.class, sql);
	}

	public List<OutStore> getOutStoreByCondition(String did, String OutTime) {

		String sql = "select * from OutStore ";

		if ((!StringUtils.isNullOrEmpty(did)) || (!StringUtils.isNullOrEmpty(OutTime))) {
			sql += " where  did like '%" + did + "%' and OutTime like '%" + OutTime + "%'";
		}

		return queryBeanList(OutStore.class, sql);
	}

	public void saveOutStore(OutStore OutStore) {

		String sql = "insert into OutStore (did,wareName,OutTime,weight,remark) values(?,?,?,?,?)";

		update(sql, OutStore.getDid(), OutStore.getWareName(), OutStore.getOutTime(), OutStore.getWeight(),
				OutStore.getRemark());

	}

	public OutStore getOutStoreById(String id) {

		String sql = "select * from OutStore where id = ?";

		return queryBean(OutStore.class, sql, id);
	}

	public void updateOutStore(OutStore OutStore) {

		String sql = "update OutStore set did=?,wareName=?,OutTime=?,weight=?,remark=? where id = ?";

		update(sql, OutStore.getDid(), OutStore.getWareName(), OutStore.getOutTime(), OutStore.getWeight(),
				OutStore.getRemark(), OutStore.getId());

	}

	public void deleteOutStoreById(String id) {

		String sql = "delete from OutStore where id = ?";
		update(sql, id);
	}

	public void pushOutStore(String id) {

		String sql = "update OutStore set status = 1 where id = ?";
		update(sql, id);

	}

}

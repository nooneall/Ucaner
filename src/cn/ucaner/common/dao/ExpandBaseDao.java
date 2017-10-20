/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.common.dao;

import java.io.Serializable;
import cn.ucaner.framework.mvc.dao.BaseDao;
import cn.ucaner.framework.mvc.entity.BaseEntity;

/**
* @Package：cn.ucaner.common.dao   
* @ClassName：ExpandBaseDao   
* @Description：   <p> 扩展基类</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月20日 下午3:46:31   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
@SuppressWarnings("rawtypes")
public interface ExpandBaseDao<T extends BaseEntity, PK extends Serializable> extends BaseDao {


}

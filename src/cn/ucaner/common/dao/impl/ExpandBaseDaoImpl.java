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
package cn.ucaner.common.dao.impl;

import java.io.Serializable;
import cn.ucaner.common.dao.ExpandBaseDao;
import cn.ucaner.framework.mvc.dao.impl.BaseDaoImpl;
import cn.ucaner.framework.mvc.entity.BaseEntity;

/**
* @Package：cn.ucaner.common.dao.impl   
* @ClassName：ExpandBaseDaoImpl   
* @Description：   <p> baseDao 扩展类</p>
* @Author： - DaoDou 
* @CreatTime：2017年10月26日 上午9:27:07   
* @Modify By：   
* @ModifyTime：  
* @Modify marker：   
* @version    V1.0
 */
@SuppressWarnings("rawtypes")
public class ExpandBaseDaoImpl<T extends BaseEntity, PK extends Serializable> extends BaseDaoImpl implements ExpandBaseDao<T, PK> {

	//private static Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);


}

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
package cn.ucaner.security.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import cn.ucaner.framework.mvc.entity.BaseEntity;

import com.alibaba.fastjson.JSON;

public class Resource extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 资源名称
	 */
	protected String name;
	/**
	 * 资源编码
	 */
	protected String code;

	/**
	 * 资源状态 1:正常 0:删除 2:禁用 默认为1
	 */
	protected Integer status;
	/**
	 * 父资源ID
	 */
	protected String parentId;
	/**
	 * 父资源名称
	 */
	protected String parentName;

	/**
	 * 备注
	 */
	protected String remark;

	/**
	 * 资源类型
	 */
	protected String type;

	/**
	 * 
	 */
	protected String value;

	/**
	 * 
	 */
	private Integer sort;

	/**
	 * 资源的操作方式 1:跳转action或页面的url 2:调用js function 3：其他<br>
	 * SecurityContant.RESOURCE_OPEN_ACTION = 1;<br>
	 * SecurityContant.RESOURCE_OPEN_FINCTION = 2;<br>
	 * SecurityContant.RESOURCE_OPEN_OTHER = 3;<br>
	 */
	protected Integer operationType;

	/**
	 * 
	 */
	@JsonIgnore
	protected String subResourcesJson;

	protected List<Resource> subResourceList;

	/**
	 * 数据权限码 add by yuce 2016-9-19 为菜单增加数据过滤
	 */
	protected String dataAuthorityCode;

	/**
	 * 对应的实体类
	 */
	protected String className;

	public Resource(String code, String name, Integer status, String parentId, String type, String value, Integer sort, Integer operationType) {
		super();
		this.name = name;
		this.status = status;
		this.code = code;
		this.parentId = parentId;
		this.type = type;
		this.value = value;
		this.sort = sort;
		this.operationType = operationType;
	}

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param code
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * @return the desc
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param code
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param code
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param code
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param code
	 *            the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getDataAuthorityCode() {
		return dataAuthorityCode;
	}

	public void setDataAuthorityCode(String dataAuthorityCode) {
		this.dataAuthorityCode = dataAuthorityCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (id != null) {
			result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		}
		result = prime * result + ( ( operationType == null ) ? 0 : operationType.hashCode() );
		result = prime * result + ( ( code == null ) ? 0 : code.hashCode() );
		result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
		result = prime * result + ( ( parentId == null ) ? 0 : parentId.hashCode() );
		result = prime * result + ( ( sort == null ) ? 0 : sort.hashCode() );
		result = prime * result + ( ( type == null ) ? 0 : type.hashCode() );
		result = prime * result + ( ( value == null ) ? 0 : value.hashCode() );
		result = prime * result + ( ( status == null ) ? 0 : status.hashCode() );
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (operationType == null) {
			if (other.operationType != null)
				return false;
		} else if (!operationType.equals(other.operationType))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (sort == null) {
			if (other.sort != null)
				return false;
		} else if (!sort.equals(other.sort))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public String getSubResourcesJson() {
		return subResourcesJson;
	}

	public void setSubResourcesJson(String subResourcesJson) {
		this.subResourcesJson = subResourcesJson;
	}

	public List<Resource> getSubResourceList() {
		if (subResourceList == null) {
			if (StringUtils.isNotBlank(subResourcesJson)) {
				subResourceList = JSON.parseArray(subResourcesJson, Resource.class);
			} else {
				subResourceList = new ArrayList<>();
			}
		}
		return subResourceList;
	}

	public void setSubResourceList(List<Resource> subResourceList) {
		this.subResourceList = subResourceList;
	}

}
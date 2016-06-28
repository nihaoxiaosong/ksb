package com.hx.model.system;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 角色表
 * @author song
 * @date 2016年6月22日下午8:58:37
 */
@Document(collection="role")
public class Role {
	/**
	 * id主键
	 */
	@Id
	private String id;
	/**
	 * 代码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 是否启用
	 * 0不启用
	 * 1启用
	 */
	private int enable;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 与该角色绑定的模块列表
	 */
	private List<Module> moduleList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Module> getModuleList() {
		return moduleList;
	}
	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}
	
}

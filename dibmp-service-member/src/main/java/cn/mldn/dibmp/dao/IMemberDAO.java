package cn.mldn.dibmp.dao;

import cn.mldn.dibmp.vo.Member;

public interface IMemberDAO {
	public Member findById(String id);
	public Member findByName(String name);
}

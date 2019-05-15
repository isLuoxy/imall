package com.luo.imall.web.dao;

import com.luo.imall.web.entity.UmsMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 会员管理自定义Dao
 * @author L99
 * @createDate 2019/5/12
 *
 */
@Repository
public interface UmsMemberDao {

    /**
     * 根据用户名获取用户对象
     * @param name
     * @return {@link UmsMember}
     */
    UmsMember findByName(String name);

    /**
     * 根据用户名和密码获取用户对象
     * @param username 用户名
     * @param password 密码
     * @return {@link UmsMember}
     */
    UmsMember findByNameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 新增会员
     * @param member {@link UmsMember}
     * @return
     */
    boolean addMember(UmsMember member);

}

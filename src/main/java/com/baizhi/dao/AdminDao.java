package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao{
    Admin queryOne(Admin admin);

    void updatePassword(Admin admin);
}

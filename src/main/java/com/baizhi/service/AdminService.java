package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    Admin findOne(Admin admin);

    void motifyPassword(Admin admin);
}

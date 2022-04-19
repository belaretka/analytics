package com.bsuir.analytics.service;

import com.bsuir.analytics.model.Admin;

public interface AdminService {
    Admin getAdmin();
    void saveAdmin(Admin admin);
    void deleteAdminById(long id);
}

package com.swp.koiCareSystem.service;

public class AccountServiceTest {
    
    public static void main(String[] args) {
        AccountService accountService = new AccountService();

        // Thông tin tài khoản cần cập nhật
        int userId = 1; // ID của tài khoản cần cập nhật
        String email = "updated.com";
        String fullName = "Updated";
        String phoneNumber = "987654321";
        String address = "456 Updated St";
        String gender = "Female";
        String oldPassword = "oldpassword"; // Mật khẩu cũ nếu cần xác thực
        String newPassword = "newpassword"; // Mật khẩu mới (có thể null nếu không đổi)

        try {
            // Thực hiện cập nhật tài khoản
            boolean isUpdated = accountService.updateAccount(userId, email, fullName, phoneNumber, address, gender, oldPassword, newPassword);
            
            // Hiển thị kết quả
            if (isUpdated) {
                System.out.println("Cập nhật tài khoản thành công.");
            } else {
                System.out.println("Cập nhật tài khoản thất bại.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}

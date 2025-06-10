package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Notification;

import java.util.List;

public interface NotificationService {
    Notification getById(Long id);
    List<Notification> getByUserId(Long userId);
    List<Notification> getUnreadByUserId(Long userId);
    Notification create(Notification notification);
    Notification markAsRead(Long id);
    void delete(Long id);
}

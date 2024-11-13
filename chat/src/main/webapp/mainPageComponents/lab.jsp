<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  session="false"%>
    <div class="chat">
        <div class="chat-header" id = "${lab.username}">
            <span class="chat-user">${lab.username}</span>
            <span class="unread-count">${lab.unreadMessagesCount}</span>
        </div>
        <div class="last-message">${lab.lastMessage}</div>
        <hr>
    </div>
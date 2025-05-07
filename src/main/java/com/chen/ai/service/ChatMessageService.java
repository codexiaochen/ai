package com.chen.ai.service;

import com.chen.ai.model.entity.ChatMessage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author abc
* @description 针对表【chat_message(聊天消息表)】的数据库操作Service
* @createDate 2025-05-07 18:15:42
*/
public interface ChatMessageService extends IService<ChatMessage> {

        /**
         * 根据会话ID获取最近的N条消息
         *
         * @param conversationId 会话ID
         * @param limit 消息数量
         * @return 消息列表
         */
        List<ChatMessage> findLatestMessages(String conversationId, int limit);

        /**
         * 根据会话ID删除消息
         *
         * @param conversationId 会话ID
         * @return 删除的记录数
         */
        Boolean deleteByConversationId(String conversationId);

}

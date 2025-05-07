package com.chen.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.ai.model.entity.ChatMessage;
import com.chen.ai.service.ChatMessageService;
import com.chen.ai.mapper.ChatMessageMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author abc
 * @description 针对表【chat_message(聊天消息表)】的数据库操作Service实现
 * @createDate 2025-05-07 18:15:42
 */
@Service
public class ChatMessageServiceImpl extends ServiceImpl<ChatMessageMapper, ChatMessage>
        implements ChatMessageService {


    /**
     * @author fgh
     * @description 针对表【chat_message(聊天消息表)】的数据库操作Service实现
     * @createDate 2025-04-30 19:56:23
     */


    @Override
    public List<ChatMessage> findLatestMessages(String conversationId, int limit) {
        // 只根据conversationId查询，不涉及messageType
        return this.lambdaQuery()
                .eq(ChatMessage::getConversationId, conversationId)
                .last("limit " + limit)
                .list();
    }

    @Override
    public Boolean deleteByConversationId(String conversationId) {
        return this.remove(lambdaQuery().eq(ChatMessage::getConversationId, conversationId));
    }


}





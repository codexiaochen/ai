package com.chen.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.ai.model.entity.ChatMessage;
import com.chen.ai.service.ChatMessageService;
import com.chen.ai.mapper.ChatMessageMapper;
import org.springframework.stereotype.Service;

/**
* @author abc
* @description 针对表【chat_message(聊天消息表)】的数据库操作Service实现
* @createDate 2025-05-07 18:15:42
*/
@Service
public class ChatMessageServiceImpl extends ServiceImpl<ChatMessageMapper, ChatMessage>
    implements ChatMessageService{

}





package com.arfin.pixchat.presentation.chat

import com.arfin.pixchat.domain.model.Message

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)

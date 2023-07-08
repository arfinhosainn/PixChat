package com.arfin.pixchat.domain.service

import com.arfin.pixchat.domain.model.Message
import com.arfin.pixchat.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {
    suspend fun initSession(
        userName: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessage(): Flow<Message>

    suspend fun closeSession()


    companion object {
        const val BASE_URL = "ws://192.168.68.109:8080"
    }

    sealed class Endpoints(val url: String) {
        object ChatSocket : Endpoints("$BASE_URL/chat-socket")
    }

}
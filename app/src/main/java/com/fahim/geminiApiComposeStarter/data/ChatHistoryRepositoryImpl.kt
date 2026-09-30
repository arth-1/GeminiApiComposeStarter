package com.fahim.geminiApiComposeStarter.data

import kotlinx.coroutines.flow.Flow

class ChatHistoryRepositoryImpl(private val dao: ChatMessageDao) : ChatHistoryRepository {
    override fun getAllMessages(): Flow<List<ChatMessageEntity>> {
        return dao.getAllMessages()
    }

    override suspend fun addMessage(text: String, isUser: Boolean) {
        dao.insertMessage(
            ChatMessageEntity(
                text = text,
                isUser = isUser,
                timestamp = System.currentTimeMillis()
            )
        )
    }

    override suspend fun clearHistory() {
        dao.clearHistory()
    }
}

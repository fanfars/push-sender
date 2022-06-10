package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEW_POST")
        .putData(
            "content", """{
          "postId": 1,
          "postAuthor": "Netology",
          "content": "Диджитал-эпоха дарит возможности онлайн-образования, но почему у одних получается ими воспользоваться, а у других — нет? Катя Гордеева вместе с командой разобралась, как изменился портрет студента. Какие результаты даёт учёба по-новому? Какие проблемы помогает решить? В фильме истории тех, чью жизнь изменило онлайн-образование, а также взгляд опытных, известных всей стране специалистов из мира образования"
          }""".trimIndent()
        )
        .setToken("cyERyC_iS_Ofqmg0RE9Kz2:APA91bEOWjrPKifFtEWdktZrIyPvPIwo0bTD34ixFu09Mx2L5giBbuDHkrJV4xiNca49zxchME8bAjT0xWJpUPEKi0Em3n6sxi9U0d2CdpcVZr24aLUN_jtnIdVBotfyI_Ue-FEVTIIB")
        .build()

    FirebaseMessaging.getInstance().send(message)
}

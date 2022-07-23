package dev.edwinperaza.triviaapp.network

import dev.edwinperaza.triviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Question

}
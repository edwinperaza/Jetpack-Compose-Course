package dev.edwinperaza.triviaapp.repository

import android.util.Log
import dev.edwinperaza.triviaapp.data.DataOrException
import dev.edwinperaza.triviaapp.model.QuestionItem
import dev.edwinperaza.triviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi
) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (e: Exception) {
            dataOrException.exception = e
            Log.e("QuestionRepository", "Exception: ${e.localizedMessage}")
        }
        return dataOrException
    }

}
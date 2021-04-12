package com.example.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    fun loadQuestions() {
        questions= ArrayList()
        addQuestion(questions, "Es Lima la capital de Perú", true)
        addQuestion(questions, "Es Lima la capital de Chile", false)
        addQuestion(questions, "Es Venezuela la capital de Chile", false)
        addQuestion(questions, "Es Caracas la capital de Venezuela", true)
        addQuestion(questions, "Es Madrid la capital de Mexico", false)
    }

    fun setupViews() {

        showSentences()

        //val btYes = findViewById<Button>(R.id.btYes)
        //have to import kotlin-android-extensions to gradle app into plugin
        btYes.setOnClickListener {
            showCorrectToast(questions[position].answer)
        }
        //val btNo = findViewById<Button>(R.id.btNo)
        btNo.setOnClickListener {
            showCorrectToast(!questions[position].answer)
        }

        btNext.setOnClickListener {
            if (position<questions.size-1){
                position++
                showSentences()
            } else {
                Toast.makeText(this, "Quiz finalizado!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun addQuestion(questions: ArrayList<Question>, sentence: String, answer: Boolean) {
        var question=Question(sentence, answer)
        questions.add(question)
    }

    fun showSentences() {
        tvSentence.text = questions[position].sentence
    }

    fun showCorrectToast(answer: Boolean){
        if (answer) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
        }
    }

}
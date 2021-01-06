package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_math_questions.*

class MathQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question> ?= null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswer : Int = 0
    private var mUsername : String ?= null
    private var mTotalQuestions : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_questions)

        mUsername = intent.getStringExtra(MathConstants.USER_NAME)
        mQuestionsList = MathConstants.getQuestions()
        mTotalQuestions = mQuestionsList!!.size

        setQuestions()

        math_tv_option_one.setOnClickListener(this)
        math_tv_option_two.setOnClickListener(this)
        math_tv_option_three.setOnClickListener(this)
        math_tv_option_four.setOnClickListener(this)
        math_btn_submit.setOnClickListener(this)
    }

    private fun setQuestions() {
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()

        if (mCurrentPosition == mTotalQuestions) {
            math_btn_submit.text = "FINISH"
        } else {
            math_btn_submit.text = "SUBMIT"
        }

        mathProgressBar.progress = mCurrentPosition
        mathProgressBar.max = mTotalQuestions
        math_tv_progress.text = "$mCurrentPosition " + "/" + "$mTotalQuestions"

        tv_math_question.text = question!!.question
        iv_math_image.setImageResource(question.image)
        math_tv_option_one.text = question.optionOne
        math_tv_option_two.text = question.optionTwo
        math_tv_option_three.text = question.optionThree
        math_tv_option_four.text = question.optionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, math_tv_option_one)
        options.add(1, math_tv_option_two)
        options.add(2, math_tv_option_three)
        options.add(3, math_tv_option_four)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNumber : Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A4A"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.math_tv_option_one -> {
                selectedOptionView(math_tv_option_one, 1)
            }
            R.id.math_tv_option_two -> {
                selectedOptionView(math_tv_option_two, 2)
            }
            R.id.math_tv_option_three -> {
                selectedOptionView(math_tv_option_three, 3)
            }
            R.id.math_tv_option_four -> {
                selectedOptionView(math_tv_option_four, 4)
            }
            R.id.math_btn_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++ // go to the next question

                    when {
                        mCurrentPosition <= mTotalQuestions -> {
                            setQuestions()
                        } else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(MathConstants.USER_NAME, mUsername)
                            intent.putExtra(MathConstants.TOTAL_QUESTIONS, mTotalQuestions)
                            intent.putExtra(MathConstants.CORRECT_ANSWER, mCorrectAnswer)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        mCorrectAnswer++
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mTotalQuestions) {
                        math_btn_submit.text = "FINISH"
                    } else {
                        math_btn_submit.text = "GO TO THE NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int) {
        when (answer) {
            1 -> {
                math_tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                math_tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                math_tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                math_tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }
}
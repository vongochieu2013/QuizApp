package com.example.quizapp

object MathConstants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_question"
    const val CORRECT_ANSWER : String = "correct_answers"

    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Find the correct answer?",
            R.drawable.ic_math_q1,
            "20",
            "22",
            "16",
            "18",
            4)

        questionsList.add(que1)

        val que2 = Question(
            2,
            "Find the correct answer?",
            R.drawable.ic_math_q2,
            "10",
            "11",
            "12",
            "13",
            3)

        questionsList.add(que2)

        val que3 = Question(
            3,
            "Find the correct answer?",
            R.drawable.ic_math_q3,
            "14",
            "126",
            "116",
            "106",
            2)

        questionsList.add(que3)

        val que5 = Question(
            4,
            "Find the correct answer?",
            R.drawable.ic_math_q5,
            "60",
            "70",
            "50",
            "80",
            1)

        questionsList.add(que5)

        val que6 = Question(
            5,
            "Find the correct answer?",
            R.drawable.ic_math_q6,
            "25",
            "28",
            "30",
            "20",
            2)

        questionsList.add(que6)

        val que7 = Question(
            6,
            "Find the correct answer?",
            R.drawable.ic_math_q7,
            "4",
            "30",
            "100",
            "20",
            4)

        questionsList.add(que7)

        return questionsList
    }
}
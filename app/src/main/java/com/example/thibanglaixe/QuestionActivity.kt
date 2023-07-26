package com.example.thibanglaixe

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*
import kotlin.math.roundToInt


class QuestionActivity : AppCompatActivity()
{
    private lateinit var serviceIntent: Intent
    private var time = 0.0
    private var Name:String?=null
    private var score:Int=0
    private  var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData> ?=null
    private var selectedOption:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(setData.name)

        questionList=setData.getQuestion()
        serviceIntent = Intent(applicationContext, TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
        setQuestion()
        startTimer()
        opt_1.setOnClickListener {
            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener {
            selectedOptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener {
            selectedOptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener {
            selectedOptionStyle(opt_4,4)
        }
        submit.setOnClickListener {
            if(selectedOption!=0)
            {
                val question= questionList!![currentPosition-1]
                if(selectedOption!=question.correct_ans)
                {
                       setColor(selectedOption,R.drawable.wrong_question_option)

                }else
                {
                    score++
                    setColor(question.correct_ans,R.drawable.correct_question_option)
                }

                if(currentPosition==questionList!!.size)
                    submit.text="FINISH"
                else
                    submit.text="Go to Next"

            }else
            {
                currentPosition++
                when{
                    currentPosition<=questionList!!.size ->{
                        setQuestion()
                    }
                    else -> {

                        var intent=Intent(this,Result::class.java)
                        intent.putExtra(setData.name,Name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())
                        intent.putExtra(setData.time12,timeTV.text)
                        startActivity(intent)
                        finish()


                    }
                }
            }
            selectedOption=0
        }

    }

    fun setColor(opt:Int, color:Int){
        when(opt)
        {
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }

    fun setQuestion()
    {
        setOptionStyle()
        val question =questionList!![currentPosition-1]
        progress_bar.progress=currentPosition
        progress_bar.max=questionList!!.size
        progress_text.text="${currentPosition}"+"/"+"${progress_bar.max}"
        question_text.text=question.question
        opt_1.text=question.option_one
        opt_2.text=question.option_two
        opt_3.text=question.option_three
        opt_4.text=question.option_four

    }
    fun setOptionStyle()
    {
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)
        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }
    fun selectedOptionStyle(view:TextView,opt: Int)
    {
        setOptionStyle()
        selectedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver()
    {
        override fun onReceive(context: Context, intent1: Intent)
        {
            time = intent1.getDoubleExtra(TimerService.TIME_EXTRA, 0.0)
            timeTV.text = getTimeStringFromDouble(time)
        }
    }

    private fun getTimeStringFromDouble(time: Double): String
    {
        val resultInt = time.roundToInt()
        val hours = resultInt % 86400 / 3600
        val minutes = resultInt % 86400 % 3600 / 60
        val seconds = resultInt % 86400 % 3600 % 60

        return makeTimeString(hours, minutes, seconds)
    }

    private fun makeTimeString(hour: Int, min: Int, sec: Int): String = String.format("%02d:%02d:%02d", hour, min, sec)
    private fun startTimer()
    {
        serviceIntent.putExtra(TimerService.TIME_EXTRA, time)
        startService(serviceIntent)

    }

    private fun stopTimer()
    {
        stopService(serviceIntent)

    }
}
package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Button
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Field for the calculation and result
        val field: EditText = findViewById(R.id.result)

        //array to hold the expression
        var expression: ArrayList<Double> = ArrayList()
        //array to hold all the operations
        var operations: ArrayList<String> = ArrayList()

        //Field for all the buttons
        val one: Button = findViewById(R.id.one)
        val two: Button = findViewById(R.id.two)
        val three: Button = findViewById(R.id.three)
        val four: Button = findViewById(R.id.four)
        val five: Button = findViewById(R.id.five)
        val six: Button = findViewById(R.id.six)
        val seven: Button = findViewById(R.id.seven)
        val eight: Button = findViewById(R.id.eight)
        val nine: Button = findViewById(R.id.nine)
        val zero: Button = findViewById(R.id.zero)
        val decimal: Button = findViewById(R.id.decimal)
        val multiply: Button = findViewById(R.id.multiply)
        val add: Button = findViewById(R.id.add)
        val subtract: Button = findViewById(R.id.subtract)
        val sqrt: Button = findViewById(R.id.sqrt)
        val divide: Button = findViewById(R.id.divide)
        val equals: Button = findViewById(R.id.equal)
        val clear: Button = findViewById(R.id.clear)
        val delete: Button = findViewById(R.id.delete)



        //On click listeners for the buttons
        one.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "1"
            field.setText(new)
        }
        two.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "2"
            field.setText(new)
        }
        three.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "3"
            field.setText(new)
        }
        four.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "4"
            field.setText(new)
        }
        five.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "5"
            field.setText(new)
        }
        six.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "6"
            field.setText(new)
        }
        seven.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "7"
            field.setText(new)
        }
        eight.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "8"
            field.setText(new)
        }
        nine.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "9"
            field.setText(new)
        }
        zero.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "0"
            field.setText(new)
        }
        decimal.setOnClickListener{view: View ->
            //parse current text
            val current = field.text.toString()

            //check if there is already a decimal point in the expression
            var decimalexist: Boolean = false
            for(x in current) {
                if(x == '.') {
                    decimalexist = true
                    break
                }
            }
            if(decimalexist == false) {
                val newText = current + "."
                field.setText(newText)
            }
        }



        //on click listeners for the operations buttons
        add.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "+"
            field.setText(new)


            operations.add("+")
        }
        subtract.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "-"
            field.setText(new)

            operations.add("-")
        }
        multiply.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "*"
            field.setText(new)

            operations.add("*")
        }
        divide.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //concatenate the new value and create a new text
            val new = current + "/"
            field.setText(new)

            operations.add("/")
        }
        sqrt.setOnClickListener{view: View ->
            //parse the current text
            val current = field.text.toString()

            //add the sqrt button
            val new = current + "√"
            field.setText(new)

            operations.add("√")
        }


        clear.setOnClickListener{view: View ->
            field.setText("")
            operations.clear()
        }

        delete.setOnClickListener { view: View ->
            val current = field.text.toString()
            val new = current.substring(0, current.length-1)
            field.setText(new)
        }


        equals.setOnClickListener{view: View ->
            // Parse the current text
            val current = field.text.toString()

            // Result variable
            var result: Double = 0.0

            //Check if there is a sqrt operation
            if(operations[0] == "√") {

                //get the numbers from the Text
                val numbers = current.split(Regex("√"))

                Log.d("CALC", numbers[1])

                //check if number is negative
                if (numbers[1].toDouble() < 0) {
                    result = Math.PI
                }
                else {
                    result = sqrt(numbers[1].toDouble())
                }

            } else {
                //Split the numbers by the operation
                val numbers = current.split(Regex("[+\\-*/√\\\\]"))

                //variable to hold result
                result = numbers[0].toDouble()

                for(i in 1 until numbers.size) {
                    when(operations[i-1]) {
                        "+" -> result += numbers[i].toDouble()
                        "-" -> result -= numbers[i].toDouble()
                        "*" -> result *= numbers[i].toDouble()
                        "/" -> {
                            val divisor = numbers[i].toDouble()
                            if (divisor == 0.0) {
                                // Handle the error, for example, return NaN
                                result = Double.NaN
                                break // Exit the loop or handle the error accordingly
                            } else {
                                result /= divisor
                            }
                        }
                        "√" -> result = sqrt(result)
                    }
                }
            }
            //Print any error messages
            if (result == Math.PI) {
                val error = "Error! Negative sqrt."
                field.setText(error)
            } else if (result.isNaN()) {
                val error = "Error! Cannot divide by zero."
                field.setText(error)
            } else {
                field.setText(result.toString())
            }
            //Restart operations list
            operations.clear()
        }
    }
}
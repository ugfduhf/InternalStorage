package com.example.internalstorage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.*
import kotlin.jvm.internal.Intrinsics

class MainActivity : AppCompatActivity() {


    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editBirth: EditText
    lateinit var btnSave:Button
    lateinit var btnRes:Button
    lateinit var textData:TextView
    val FILE_USER_NAME:String = "name"
    var temp = String
    val name = "yasser"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        editName = findViewById(R.id.edit_Name)
        editEmail = findViewById(R.id.edit_Email)
        editBirth= findViewById(R.id.edit_birthday)
        btnSave = findViewById(R.id.btn_save)
        btnRes = findViewById(R.id.btn_restore)
        textData = findViewById(R.id.tv_data)
        var username = editName
        var email = editEmail.text.toString()
        var birthday = editBirth.text

        // This lemda is save data in storage internal.
        var fileOutputStream = this.openFileOutput(FILE_USER_NAME, MODE_PRIVATE)
        fileOutputStream.use(  ::myFile )


        //This is read data of storage
      readData()





        btnSave.setOnClickListener {

//                   shared Preferences        //In Kotlin
//            var sharedPre = getSharedPreferences(FILE_USER_NAME, Context.MODE_PRIVATE)
//            var editier = sharedPre.edit()
//            editier.putString("user_name",username.text.toString())
//            editier.commit()
//
//            var intent = Intent(this,SecondActivity::class.java)
//            startActivity(intent)

//            //var shar = getSharedPreferences(FILE_USER_NAME, MODE_PRIVATE)
//            val shar = getSharedPreferences(FILE_USER_NAME, Context.MODE_PRIVATE)
//
//            val   geditor = shar.getString("user_name", "")
//            username.setText(geditor)
//*


            // this in fava
//            try {
//                // open stream if not found it, create a new file, that is only open stream not input data yet.
//                                         // this name file  // this mode can't anyone outside app usable or display it.
//                var FileOm = openFileOutput(FILE_USER_NAME, MODE_PRIVATE)
//                //PrintWriter, that is compile between stream and you .it's ordered and readable .
//                var v = PrintWriter(FileOm)
//                v.println("user ${" "} email ${" "} birthDay ")
//                // Necessary close write before the stream
//                v.close()
//                FileOm.close()
//            } catch (   e: FileNotFoundException){
//                e.printStackTrace()
//            }
        }




        btnRes.setOnClickListener {




            // This method open stream only. In java
//            var openFileInputStream = openFileInput(FILE_USER_NAME)
//            var inSR = InputStreamReader(openFileInputStream)
//            //Buffered  this operation as read the data of file as small small data.It's not directly with open input it need to adapter, it is InputStreamReader() this class.
//            var br = BufferedReader(inSR)
//            var i = String
//            while (br.readLine() != null){
//
//            }
//
//            br.close()
//            inSR.close()
//            openFileInputStream.close()
//            Toast.makeText(this,)
//
        }
    }


    fun myFile(file: FileOutputStream){
        file.write(name.toByteArray())
        Toast.makeText(this,"data ok ",Toast.LENGTH_SHORT).show()
    }
    fun readData(){
        //This is read data of storage
        val fileStream = openFileInput(FILE_USER_NAME)
        val bufferedReader = fileStream.bufferedReader()
        val sb = StringBuilder()

        bufferedReader.forEachLine {
            sb.append(it)
        }
        textData.text = sb
        //  textData.setText(sb)
    }

}
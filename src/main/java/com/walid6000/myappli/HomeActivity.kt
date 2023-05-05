package com.walid6000.myappli

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // button for logout and initializing our button.
        val logoutBtn: Button = findViewById(R.id.idBtnLogout)

        // adding onclick listener for our logout button.
        logoutBtn.setOnClickListener {
            // below line is for getting instance
            // for AuthUi and after that calling a
            // sign out method from Firebase.
            AuthUI.getInstance()
                .signOut(this@HomeActivity)
                // after sign out is executed we are redirecting
                // our user to MainActivity where our login flow is being displayed.
                .addOnCompleteListener { task: Task<Void?> ->
                    // below method is used after logout from device.
                    Toast.makeText(this@HomeActivity, "User Signed Out", Toast.LENGTH_SHORT).show()
                    // below line is to go to MainActivity via an intent.
                    val i = Intent(this@HomeActivity, MainActivity::class.java)
                    startActivity(i)
                }
        }
    }
}

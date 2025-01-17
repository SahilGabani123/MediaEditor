package com.mediaeditor.app.ui.home

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mediaeditor.app.R
import com.mediaeditor.app.databinding.ActivityHomeBinding
import com.mediaeditor.app.databinding.ActivityMainBinding
import com.mediaeditor.app.ui.main.MainActivity
import com.mediaeditor.app.utils.FileUtils

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPickMedia.setOnClickListener {
            pickMedia()
        }
    }

    private fun pickMedia() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
        pickMediaLauncher.launch(intent)
    }

    private val pickMediaLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val selectedUri: Uri? = result.data?.data
            if (selectedUri != null) {
                val filePath = FileUtils.getPath(this,selectedUri)
                Log.i("HomeActivity", "onCreate: Path :$filePath")
                if (filePath != null) {
                    startActivity(MainActivity.getIntent(this, filePath))
                }
            }
        }
    }

}
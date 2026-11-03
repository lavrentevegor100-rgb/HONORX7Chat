package com.honorx7chat

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast

class MainActivity : Activity() {

    companion object {
        private const val REQUEST_ACCESSIBILITY_SETTINGS = 4102
        private const val VIDEO_URL = "https://vkvideo.ru/video-222829966_456239019"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Android не разрешает обычным приложениям переключать
        // системную инверсию цветов без привилегированного доступа.
        // Поэтому сначала открываем системные настройки, где пользователь
        // может включить «Инверсию цветов» вручную.
        if (savedInstanceState == null) {
            try {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                startActivityForResult(intent, REQUEST_ACCESSIBILITY_SETTINGS)
            } catch (_: Exception) {
                openVideo()
            }
        }
    }

    @Deprecated("Deprecated by Android, retained for broad device compatibility")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ACCESSIBILITY_SETTINGS) {
            openVideo()
        }
    }

    private fun openVideo() {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(VIDEO_URL)))
            finish()
        } catch (_: Exception) {
            Toast.makeText(this, "Не удалось открыть видео", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}

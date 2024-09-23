package app.ditodev.fruitz.utils

import android.view.Window
import android.view.WindowManager

class Utils {
    companion object{
        const  val EXTRA_DATA = "extra_data"
        fun changeStatusBarColor(window : Window , color: String) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }
}
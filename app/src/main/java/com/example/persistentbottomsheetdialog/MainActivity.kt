package com.example.persistentbottomsheetdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.android.material.bottomsheet.BottomSheetBehavior

import android.widget.LinearLayout
import androidx.annotation.NonNull
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback


class MainActivity : AppCompatActivity() {

    private lateinit var mBottomSheetLayout: LinearLayout
    private lateinit var sheetBehavior: BottomSheetBehavior<*>
    private lateinit var header_Arrow_Image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mBottomSheetLayout = findViewById(R.id.bottom_sheet_layout)
        sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout)

        header_Arrow_Image = findViewById(R.id.bottom_sheet_arrow)

        header_Arrow_Image.setOnClickListener {
            if (sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }

        sheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                header_Arrow_Image.rotation = slideOffset * 180
            }
        })


    }
}
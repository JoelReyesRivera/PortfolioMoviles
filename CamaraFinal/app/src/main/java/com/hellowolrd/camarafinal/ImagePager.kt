package com.hellowolrd.camarafinal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_image_pager.*
import java.io.File
import java.io.FilenameFilter


class ImagePager : AppCompatActivity() {

    lateinit var files: List<File>
    lateinit var button : FloatingActionButton
    lateinit var file: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_pager)

        button = findViewById(R.id.floatingActionButton)
        val folderImage = File(filesDir, "image")
        val files = folderImage.listFiles(FilenameFilter { dir, name ->
            name.contains("image_")
        })?.reversed()

        val viewPager = findViewById<ViewPager2>(R.id.viewpager)

        val photoPagerAdapter = PhotoPagerAdapter(this, files!!)

        viewPager.adapter = photoPagerAdapter

        floatingActionButton.setOnClickListener {

            file = files.get(viewPager.currentItem)
            val photoURI = FileProvider.getUriForFile(
                applicationContext,
                BuildConfig.APPLICATION_ID + ".provider",
                file
            )
            var intent = Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, photoURI)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.type = "image/jpeg"
            startActivity(intent);
        }

    }

    private inner class PhotoPagerAdapter(fa: FragmentActivity, private val files: List<File>) :
        FragmentStateAdapter(fa) {
        val cacheFragments = mutableMapOf<Int, Fragment>()

        override fun getItemCount(): Int = files.size

        override fun createFragment(position: Int): Fragment {
            val imagePageFragment: Fragment
            if (!cacheFragments.containsKey(position)) {
                val file = files[position]
                imagePageFragment = ImagePageFragment(file)
                cacheFragments[position] = imagePageFragment
            } else {
                imagePageFragment = cacheFragments[position]!!
            }
            return imagePageFragment
        }

    }
}
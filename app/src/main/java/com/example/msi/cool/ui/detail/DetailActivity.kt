package com.example.msi.cool.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.msi.karn.ui.detail.viewpager.SectionsPagerAdapter
import com.example.msi.cool.HomeActivity
import com.example.msi.cool.JsonMockUtility
import com.example.msi.cool.R
import com.example.msi.cool.extension.navigate
import com.example.msi.cool.model.ListReview
import com.example.msi.cool.model.PmtCoolModel
import com.example.msi.cool.ui.detail.adapter.AdpterReview
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_re_view.*
import android.widget.Toast



class DetailActivity : AppCompatActivity() {

    companion object {
        const val Key = "KEY_DATA"
    }

    lateinit var layoutShow: LinearLayout

    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setDetailFood()
        setPagerImage()
        setReview()
        backMain.setOnClickListener {
            navigate<HomeActivity> { }
        }
        btnBackToTop.setOnClickListener {
            myScrollingContent.fullScroll(ScrollView.FOCUS_UP)
        }
        call.setOnClickListener {
            val detail: PmtCoolModel = intent.getParcelableExtra(Key)
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf("recipient@example.com"))
            i.putExtra(Intent.EXTRA_SUBJECT, "ขอใบเสนอราคาห้องเย็นตั้งพื้นสำเร็จรูป")
            i.putExtra(Intent.EXTRA_TEXT, "ขอใบเสนอราคาห้องเย็นตั้งพื้นสำเร็จรูปขนาด: "+" "+detail.size)
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun setReview() {
        JsonMockUtility().apply {
            val dataMock = getJsonToMock("reviewbitzer.json", ListReview::class.java)
            val review: AdpterReview  by lazy { AdpterReview  (listOf()) }
            recyclerViewReview?.layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
            recyclerViewReview?.adapter = review
            dataMock.results?.let { review.setItem(it) }
        }

    }

    @SuppressLint("SetTextI18n")
    private fun setDetailFood() {
        val detail: PmtCoolModel = intent.getParcelableExtra(Key)
        size.text = detail.size
        type.text = "ประเภท: " + detail.type
        recipe.text = detail.recipe
        detailType.text = detail.ingredients
        detailPmt.text = detail.detail
        rating.numStars = detail.vote?.toInt()!!
        rating.rating = detail.vote.toFloat()!!
    }

    private fun setPagerImage() {
        val urlImage: PmtCoolModel = intent.getParcelableExtra(Key)
        val mSectionsPagerAdapter: SectionsPagerAdapter?
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager,
            urlImage.gallery?.image_cover1.toString(),
            urlImage.gallery?.image_cover2.toString(),
            urlImage.gallery?.image_cover3.toString(),
            urlImage.gallery?.image_cover4.toString(),
            urlImage.gallery?.image_cover5.toString()
        )

        container.adapter = mSectionsPagerAdapter
        val dot: Int
        val dots: Array<ImageView?>
        dot = mSectionsPagerAdapter.count
        dots = arrayOfNulls(dot)
        for (i in 0 until dot) {
            dots[i] = ImageView(this)
            dots[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(8, 0, 8, 0)
            sliderDots.addView(dots[i], params)
        }

        dots[0]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))
        container.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                for (i in 0 until dot) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))
                }
                dots[position]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}

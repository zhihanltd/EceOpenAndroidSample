package com.ececloud.android.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.ececloud.android.open.EceOpen
import com.ececloud.android.sample.databinding.ActivityCustomToolbarBinding

/**
 * @author Hyu
 * @since 2021/09/18
 * Email: fvaryu@163.com
 * Description:
 *
 * 自定义导航
 * 将fragment嵌入到自己的页面
 */
class CustomActionBarActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context, accessToken:String, evaluationId:Long) {
            context.startActivity(Intent().apply {
                putExtra("token", accessToken)
                putExtra("id", evaluationId)
            })
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.close.setOnClickListener {
            finish()
        }


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment,
                EceOpen.fragment(intent.getStringExtra("token") ?: "",
                    intent.getLongExtra("id", 0L)))
            .commit()


    }
}
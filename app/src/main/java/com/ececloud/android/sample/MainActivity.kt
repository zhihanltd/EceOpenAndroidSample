package com.ececloud.android.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import cn.ececloud.android.open.EceOpen
import com.ececloud.android.sample.databinding.ActivityMainBinding

// 评测服务demo
class MainActivity : AppCompatActivity() {

    // 请求的token，从自己服务器获取
    private val token = ""
    //  评测的id，从自己服务器获取
    private val evaluationId = 0L

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


         // 使用集成好的页面，不可定义导航
        binding.btnSDK.setOnClickListener {
            if (token.isBlank() || evaluationId == 0L) {
                Toast.makeText(this, "请获取token或评测", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            EceOpen.start(this, token, evaluationId)
        }

        // 使用fragment页面，嵌入到自定义的Activity中，能够自定义导航
        binding.btnSDKCustom.setOnClickListener {
            if (token.isBlank() || evaluationId == 0L) {
                Toast.makeText(this, "请获取token或评测", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            CustomActionBarActivity.start(this, token, evaluationId)
        }

    }


}
package com.wahyupermadie.visitablepattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wahyupermadie.visitablepattern.adapter.FetchStateViewHolder.FetchStateViewHolderListener
import com.wahyupermadie.visitablepattern.base.BaseItemModel
import com.wahyupermadie.visitablepattern.base.HomeAdapter
import com.wahyupermadie.visitablepattern.factory.ItemTypeFactoryImpl
import com.wahyupermadie.visitablepattern.model.TransactionBannerModel
import com.wahyupermadie.visitablepattern.model.TransactionHistoryModel
import com.wahyupermadie.visitablepattern.utils.EndlessRecyclerViewScrollListener
import com.wahyupermadie.visitablepattern.utils.ListUpdateCallBack
import java.util.Random

class MainActivity : AppCompatActivity(), FetchStateViewHolderListener {

    lateinit var mBaseAdapter: HomeAdapter
    val listUpdateCallBack = ListUpdateCallBack()

    private var isLoaded = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBaseAdapter = HomeAdapter(ItemTypeFactoryImpl(), this)

        listUpdateCallBack.bind(mBaseAdapter)
        val linearLayoutManager = LinearLayoutManager(this)
        val scrollListener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int) {
                if (!isLoaded) {
                    onScroll()
                    isLoaded = true
                }
            }
        }
        findViewById<RecyclerView>(R.id.rvMain).apply {
            layoutManager = linearLayoutManager
            adapter = mBaseAdapter
            setHasFixedSize(true)
            itemAnimator = null
            addOnScrollListener(scrollListener)
        }

        addTransactionHeader()

    }

    private fun addTransactionHeader() {
        val header = arrayListOf<BaseItemModel>(
            TransactionBannerModel(
                "11223344",
                "2123123123"
            )
        )
        mBaseAdapter.submitData(header)

        val transaction = TransactionHistoryModel(
            1231223123,
            "11223344",
            2123123123
        )
        val transactions = arrayListOf<BaseItemModel>(
            transaction.copy(transacationAmount = "Wahyu"),
            transaction.copy(transacationAmount = "Permadi"),
            transaction.copy(transacationAmount = "Putu"),
            transaction.copy(transacationAmount = "Bagus"),
            transaction.copy(transacationAmount = "Adi"),
            transaction.copy(transacationAmount = "Purnama"),
            transaction.copy(transacationAmount = "Wibawa"))

        mBaseAdapter.submitData(transactions)
    }

    private fun onScroll() {
        mBaseAdapter.showLoading()

        Handler(Looper.getMainLooper()).postDelayed({
            mBaseAdapter.hideLoading()
            val transaction = TransactionHistoryModel(
                1231223123,
                "11223344",
                Random().nextInt()
            )
            val transactions = arrayListOf<BaseItemModel>(
                transaction.copy(transacationAmount = "Wahyu"),
                transaction.copy(transacationAmount = "Permadi"),
                transaction.copy(transacationAmount = "Putu"),
                transaction.copy(transacationAmount = "Bagus"),
                transaction.copy(transacationAmount = "Adi"),
                transaction.copy(transacationAmount = "Purnama"),
                transaction.copy(transacationAmount = "Wibawa"))

            mBaseAdapter.submitData(transactions)

            mBaseAdapter.setError()
        }, 3000)



    }

    override fun onRetryClicked() {
        mBaseAdapter.showLoading()
    }
}
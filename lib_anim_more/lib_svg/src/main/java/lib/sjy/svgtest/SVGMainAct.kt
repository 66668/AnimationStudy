package lib.sjy.svgtest

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewPropertyAnimator
import lib.base.sjy.adpater.MainAdapter
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import android.content.Intent
import java.util.ArrayList

/**
 * 矢量图
 */
class SVGMainAct : AppCompatActivity() {
    //-----------------------------控件--------------------------------
    private var recyclerView: RecyclerView? = null
    private val animator: ViewPropertyAnimator? = null

    //-------------------------------------------------------------
    private var data: MutableList<String> = ArrayList()
    private var adapter: MainAdapter? = null
    var mExitTime = System.currentTimeMillis()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)
        recyclerView = findViewById(R.id.recyclerView)
        initView()
    }

    private fun initView() {
        data = ArrayList()
        //参考github开源：SVGMapView
        data.add("01-SVGMapView-世界地图")
        data.add("02-补间动画(Tween Animation)")
        data.add("03-属性动画(Propety Animation)")
        //
        adapter = MainAdapter(this)
        adapter!!.setDatas(data)
        //
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        recyclerView!!.layoutManager = manager
        //
        recyclerView!!.adapter = adapter
        //
        adapter!!.setListener { str, pos ->
            when (pos) {
                0 -> startMapView()
                1 -> {
                }
                2 -> {
                }
                3 -> {
                }
                4 -> Toast.makeText(this@SVGMainAct, str + pos, Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(this@SVGMainAct, str + pos, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startMapView() {
        val intent = Intent(this@SVGMainAct, MapViewAct::class.java)
        startActivity(intent)
    }
}
package lib.sjy.svgtest;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lib.sjy.svgtest.mapview.MapView

/**
 * github开源：SVGMapView：世界地图：svg展示
 * svg资源放在res/raw中
 */
class MapViewAct : AppCompatActivity() {
    private lateinit var mapview: MapView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_map_main)
        mapview = findViewById(R.id.mapview)
        mapview.setOnProvinceClickLisener({
            if (it.contains("nei", true)) {
                mapview.setData(R.raw.neimeng)
            } else if (it.contains("tai", true)) {
                mapview.setData(R.raw.taiwanhigh)
            }
        }, {
            mapview.setData(R.raw.chinahigh)
        })
    }
}
# Transition Animation /矢量图 Vector(svg)

## 1. 什么是 Vector?
**矢量图像**：SVG是W3C 推出的一种开放标准的文本式矢量图形描述语言,他是基于XML的、专门为网络而设计的图像格式

**位图图像**：位图图像的存储单位是图像上每一点的像素值，因而文件会比较大，像GIF、JPEG、PNG等都是位图图像格式

**Vector**: 在Android中指的是Vector Drawable，也就是Android中的矢量图，
可以说Vector就是Android中的SVG实现(并不是支持全部的SVG语法,现已支持的完全足够用了)

**优点：**
1.矢量图使用点和线来描述图形，所有文件会比较小，同时也能提供高清晰的画面。
2.矢量图缩放自由且不会失真，完全适配于任何分辨率的屏幕。
3.矢量图是以xml语言来描述的，所以它修改自如，节约空间，使用方便。
4.矢量图色彩分辨率非常高清，同时支持滤镜。
5.跨平台，因为矢量图是纯文本格式来描述的，所以不受平台的限制。

**缺点：**
SVG 是在要用图的时候再把图画出来，所以在图片显示的时候会花费更多的时间消耗更多的资源；此外，SVG 并不太适合层次过于复杂细节过于繁多的图片。

简单来说，SVG就是描述图形的xml文件，缩放不变形。
和安卓中的shape有点异曲同工之妙。

**静态Vector**：vector标签

**动态Vector**：animated-vector标签

**VectorDrawable的性能问题**：

1）Bitmap的绘制效率并不一定会比Vector高，它们有一定的平衡点，当Vector比较简单时，其效率是一定比Bitmap高的，所以，为了保证Vector的高效率，Vector需要更加简单，PathData更加标准、精简，当Vector图像变得非常复杂时，就需要使用Bitmap来代替了
2）Vector适用于ICON、Button、ImageView的图标等小的ICON，或者是需要的动画效果，由于Bitmap在GPU中有缓存功能，而Vector并没有，所以Vector图像不能做频繁的重绘
3）Vector图像过于复杂时，不仅仅要注意绘制效率，初始化效率也是需要考虑的重要因素

SVG - 在Android中使用矢量图全攻略： https://blog.csdn.net/zheng_weichao/article/details/94453946


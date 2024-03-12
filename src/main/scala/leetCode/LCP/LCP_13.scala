package leetCode.LCP

import scala.collection.mutable
import scala.util.control.Breaks._

object LCP_13 {

  private val max_value = Int.MaxValue / 2

  class Point(_x: Int, _y: Int) {
    val x: Int = _x
    val y: Int = _y
    var dis: Int = _

    def setDis(_dis: Int): Point = {
      this.dis = _dis
      this
    }

    override def equals(obj: Any): Boolean = {
      if (this == obj) return true
      if (obj == null || getClass != obj.getClass) return false
      val point: Point = obj.asInstanceOf[Point]
      x == point.x && y == point.y
    }

    override def hashCode(): Int = java.util.Objects.hash(new Integer(_x), new Integer(_y))
  }

  private var sToMDis = Array.empty[Int]
  private var mToMDis = Array.empty[Array[Int]]
  private var sToODis = Array.empty[Int]
  private var mToODis = Array.empty[Array[Int]]
  private var oToMDis = Array.empty[Array[Int]]
  private var mToTDis = Array.empty[Int]
  private var pointToIndex = new mutable.HashMap[Point, Int]()
  private var map = Array.empty[Array[Char]]

  def minimalSteps(maze: Array[String]): Int = {
    map = Array.ofDim[Char](maze.length + 2, maze(0).length + 2)
    map.indices.foreach(i => map(i) = Array.fill(map(i).length)('#'))
    var oLen = 0
    var mLen = 0
    var start: Point = null
    var end: Point = null
    var oList = Array.empty[Point]
    var mList = Array.empty[Point]
    maze.indices.foreach(y => maze(0).indices.foreach(x => {
      map(y + 1)(x + 1) = maze(y)(x)
      var p = new Point(x + 1, y + 1)
      map(y + 1)(x + 1) match {
        case 'O' =>
          oList :+= p
          pointToIndex += p -> oLen
          oLen += 1
        case 'M' =>
          mList :+= p
          pointToIndex += p -> mLen
          mLen += 1
        case 'S' =>
          pointToIndex += p -> 0
          start = new Point(x + 1, y + 1)
        case 'T' =>
          pointToIndex += p -> 0
          end = p
        case _ =>
      }
    }))
    val sToTMap = bfs(start.x, start.y, 'T')
    if (sToTMap.isEmpty) return -1
    if (mLen == 0) return sToTMap(0)
    sToODis = Array.fill(oLen)(max_value)
    val sToOMap = bfs(start.x, start.y, 'O')
    if (sToOMap.isEmpty) return -1
    sToOMap.toSet.foreach((v: (Int, Int)) => sToODis(v._1) = v._2)
    val sToMMap = bfs(start.x, start.y, 'M')
    if (sToMMap.size < mLen) return -1
    oToMDis = Array.ofDim[Int](oLen, mLen)
    oToMDis.indices.foreach(v => oToMDis(v) = Array.fill(oToMDis(v).length)(max_value))
    var i = 0
    oList.foreach(op => {
      val oToMMap = bfs(op.x, op.y, 'M')
      breakable {
        if (oToMMap.isEmpty) {
          i += 1
          break()
        }
      }
      oToMMap.toSet.foreach((v: (Int, Int)) => oToMDis(i)(v._1) = v._2)
      i += 1
    })
    mToODis = Array.ofDim[Int](mLen, oLen)
    mToTDis = Array.fill(mLen)(0)
    i = 0
    mList.foreach(mp => {
      val mToOMap = bfs(mp.x, mp.y, 'O')
      if (mToOMap.isEmpty) return -1
      mToOMap.toSet.foreach((v: (Int, Int)) => mToODis(i)(v._1) = v._2)
      val mToTMap = bfs(mp.x, mp.y, 'I')
      if (mToTMap.isEmpty) return -1
      mToTDis(i) = mToTMap(0)
      i += 1
    })
    sToMDis = Array.fill(mLen)(max_value)
    mToMDis = Array.ofDim[Int](mLen, mLen)
    mToMDis.indices.foreach(v => mToODis(v) = Array.fill(mToODis(v).length)(max_value))
    (0 until mLen).foreach(m => (0 until oLen).foreach(o => {
      val dis = sToODis(0) + oToMDis(o)(m)
      if (dis < sToMDis(m)) sToMDis(m) = dis
      (0 until mLen).foreach(mEnd => {
        val mmDis = mToODis(m)(0) + oToMDis(0)(mEnd)
        if (mmDis < mToMDis(m)(mEnd)) mToMDis(m)(mEnd) = mmDis
      })
    }))
    val mSta = 1 << mLen
    val dp = Array.ofDim[Int](mLen + 1, mSta, mLen)
    val bigSta = mSta - 1
    (0 until mLen).foreach(m => dp(mLen)(bigSta)(m) = mToTDis(m))
    (1 until mLen).reverse.foreach(mCnt => (0 to bigSta).reverse.foreach(sta => (0 until mLen).foreach(m => {
      var minDis = max_value
      (0 until mLen).foreach(endM => {
        breakable {
          if ((sta & (1 << endM)) != 0 || m == endM) break()
        }
        minDis = minDis.min(mToMDis(m)(endM) + dp(mCnt + 1)(sta | (1 << endM))(endM))
      })
      dp(mCnt)(sta)(m) = minDis
    })))
    var res = max_value
    (0 until mLen).foreach(m => res = res.min(sToMDis(m) + dp(1)(1 << m)(m)))
    if (res == max_value) -1 else res
  }

  def bfs(_x: Int, _y: Int, _findChar: Char): mutable.Map[Int, Int] = {
    val vis = Array.ofDim[Boolean](map.length, map(0).length)
    val q = new mutable.Queue[Point]()
    q.enqueue(new Point(_x, _y))
    vis(_y)(_x) = true
    var indexAndDisMap = new mutable.HashMap[Int, Int]()
    while (q.nonEmpty) {
      val p = q.head
      q.dequeue()
      val px = p.x
      val py = p.y
      if (map(px)(py) == _findChar) indexAndDisMap += pointToIndex(p) -> p.dis
      deal(px + 1, py, q, vis, p.dis + 1)
      deal(px - 1, py, q, vis, p.dis + 1)
      deal(px, py - 1, q, vis, p.dis + 1)
      deal(px, py + 1, q, vis, p.dis + 1)
    }
    indexAndDisMap
  }

  def deal(_x: Int, _y: Int, _q: mutable.Queue[Point], _vis: Array[Array[Boolean]], _dis: Int): Unit = {
    if (!_vis(_y)(_x) && map(_y)(_x) != '#') {
      _vis(_y)(_x) = true
      _q.enqueue(new Point(_x, _y).setDis(_dis))
    }
  }
}

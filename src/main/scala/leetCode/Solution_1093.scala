package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_1093 {
  def sampleStats(array: Array[Int]): Array[Double] = {
    var sum = 0.0
    var cnt = 0
    var mxCnt = Integer.MIN_VALUE
    var mxValue = 0
    val tm = new mutable.TreeMap[Int, Int]()
    var i = 0
    while (i < array.length) {
      if (array(i) > 0) {
        sum += array(i) * i
        cnt += array(i)
        tm += i -> array(i)
      }
      if (mxCnt < array(i)) {
        mxCnt = array(i)
        mxValue = i
      }
      i += 1
    }
    val a = cnt / 2 - 1
    val b = cnt / 2
    var av, bv = -1
    var cc = 0
    breakable {
      tm.keySet.foreach(k => {
        cc += tm(k)
        if (cc > b) {
          if (av == -1) av = k
          bv = k
          break()
        } else if (cc >= a && cc <= b)
          if (av == -1) av = k
      })
    }
    val m = if (cnt % 2 == 0) (av.toDouble + bv.toDouble) / 2 else bv.toDouble
    Array(tm.firstKey.toDouble, tm.lastKey.toDouble, sum / cnt.toDouble, m, mxValue.toDouble)
  }
}

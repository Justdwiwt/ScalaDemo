package leetCode.LCP

import java.util.{Comparator, PriorityQueue}

object LCP_59 {
  def buildBridge(num: Int, wood: Array[Array[Int]]): Long = {
    val reverseOrderComparator: Comparator[java.lang.Long] = Comparator.reverseOrder[java.lang.Long]()
    val L = new PriorityQueue[java.lang.Long](reverseOrderComparator)
    val R = new PriorityQueue[Long]()
    L.add(wood.head.head.toLong)
    R.add(wood.head.head.toLong)
    var biasL = 0L
    var biasR = 0L
    var res = 0L
    wood.indices.drop(1).foreach(i => {
      biasL -= (wood(i)(1) - wood(i).head).toLong
      biasR += (wood(i - 1)(1) - wood(i - 1).head).toLong
      val l0 = L.peek() + biasL
      val r0 = R.peek() + biasR
      val x = wood(i).head.toLong
      if (x < l0) {
        res += l0 - x
        L.poll()
        L.add(x - biasL)
        L.add(x - biasL)
        R.add(l0 - biasR)
      } else if (x > r0) {
        res += x - r0
        R.poll()
        R.add(x - biasR)
        R.add(x - biasR)
        L.add(r0 - biasL)
      } else {
        L.add(x - biasL)
        R.add(x - biasR)
      }
    })
    res
  }
}

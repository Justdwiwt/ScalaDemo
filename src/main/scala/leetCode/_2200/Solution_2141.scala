package leetCode._2200

object Solution_2141 {
  def maxRunTime(computers: Int, batteries0: Array[Int]): Long = {
    val batteries = batteries0.map(_.toLong)

    def canRunComputersFor(time: Long): Boolean =
      batteries.map(_.min(time)).sum >= computers * time

    @scala.annotation.tailrec
    def binarySearch(l: Long, r: Long): Long =
      if (l >= r) l
      else {
        val mid = (l + r + 1) / 2
        if (canRunComputersFor(mid)) binarySearch(mid, r)
        else binarySearch(l, mid - 1)
      }

    binarySearch(l = 0L, r = batteries.sum / computers)
  }
}

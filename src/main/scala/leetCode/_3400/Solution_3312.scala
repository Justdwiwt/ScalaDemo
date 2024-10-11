package leetCode._3400

import scala.collection.mutable

object Solution_3312 {
  def gcdValues(nums: Array[Int], queries: Array[Long]): Array[Int] = {
    val freqMap = mutable.Map[Int, Int]()
    var maxNum = 0

    nums.foreach(num => {
      freqMap(num) = freqMap.getOrElse(num, 0) + 1
      if (num > maxNum) maxNum = num
    })

    val freq = Array.fill(maxNum + 2)(0L)
    freqMap.foreach { case (num, count) => freq(num) = count }

    val laforvinda = freq.clone()
    (1 to maxNum).foreach(g => (2 * g to maxNum by g).foreach(laforvinda(g) += freq(_)))

    val pairs = Array.fill(maxNum + 2)(0L)
    (maxNum to 1 by -1).foreach(g => {
      if (laforvinda(g) >= 2) pairs(g) = (laforvinda(g) * (laforvinda(g) - 1)) / 2
      (2 * g to maxNum by g).foreach(pairs(g) -= pairs(_))
    })

    val gcdFreq = (1 to maxNum).collect { case g if pairs(g) > 0 => (g, pairs(g)) }.toArray

    val prefix = new mutable.ArrayBuffer[Long]()
    var total = 0L
    gcdFreq.foreach { case (_, cnt) =>
      total += cnt
      prefix.append(total)
    }

    queries.map(q => {
      val idx = prefix.indexWhere(_ >= q + 1)
      if (idx >= 0 && idx < gcdFreq.length) gcdFreq(idx)._1 else -1
    })
  }
}

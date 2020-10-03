package leetCode

import scala.collection.mutable

object Solution_1224 {
  def maxEqualFreq(nums: Array[Int]): Int = {
    val uniqueFreq = mutable.Map[Int, Int]()
    val freqCnt = mutable.Map[Int, mutable.Set[Int]]()

    nums.indices.foreach(i => {
      val currNum = nums(i)
      uniqueFreq += currNum -> (uniqueFreq.getOrElse(currNum, 0) + 1)
      val ft = uniqueFreq(currNum)
      if (!freqCnt.contains(ft)) freqCnt += ft -> mutable.Set[Int]()
      freqCnt(ft).add(currNum)
      if (ft > 1) {
        freqCnt(ft - 1).remove(currNum)
        if (freqCnt(ft - 1).isEmpty) freqCnt.remove(ft - 1)
      }
    })

    (nums.length - 1 to 0 by -1).foreach(i => {
      if (uniqueFreq.size == 1 || uniqueFreq.size == i + 1) return i + 1
      if (freqCnt.size == 2) {
        val ks = freqCnt.keySet.toList
        val firstFreqKey = ks.head
        val secondFreqKey = ks(1)
        val firstValue = freqCnt(firstFreqKey)
        val secondValue = freqCnt(secondFreqKey)
        if ((firstFreqKey == 1 && firstValue.size == 1) || (secondFreqKey == 1 && secondValue.size == 1)) return i + 1
        if ((firstFreqKey == secondFreqKey + 1 && firstValue.size == 1) || (secondFreqKey == firstFreqKey + 1 && secondValue.size == 1)) return i + 1
      }

      val removedNum = nums(i)
      val originalFreq = uniqueFreq(removedNum)
      uniqueFreq += removedNum -> (uniqueFreq(removedNum) - 1)
      if (uniqueFreq(removedNum) == 0) uniqueFreq.remove(removedNum)
      freqCnt(originalFreq).remove(removedNum)
      if (freqCnt(originalFreq).isEmpty) freqCnt.remove(originalFreq)
      if (uniqueFreq.contains(removedNum)) {
        if (!freqCnt.contains(originalFreq - 1)) freqCnt(originalFreq - 1) = mutable.Set[Int]()
        freqCnt(originalFreq - 1).add(removedNum)
      }
    })
    0
  }
}

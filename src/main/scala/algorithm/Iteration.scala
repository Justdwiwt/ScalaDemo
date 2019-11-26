package algorithm

/**
  * 迭代法
  */
object Iteration {

  /**
    * 计算大于1的正整数之平方根
    *
    * @param n              待求的数
    * @param deltaThreshold 误差的阈值
    * @param maxTry         二分查找的最大次数
    * @return 平方根的解
    */
  def getSquareRoot(n: Int, deltaThreshold: Double, maxTry: Int): Double = {
    if (n <= 1) return -1.0
    var min = 1.0
    var max = n.toDouble
    (0 until maxTry).foreach(_ => {
      val mid = (max + min) / 2
      val square = mid * mid
      val delta = ((square / n) - 1).abs
      if (delta <= deltaThreshold) return mid
      else {
        if (square > n) max = mid else min = mid
      }
    })
    -2.0
  }

  /**
    * 查找某个单词是否在字典里出现
    *
    * @param dictionary 排序后的字典
    * @param wordToFind 待查的单词
    * @return 是否发现待查的单词
    */
  def searchWord(dictionary: Array[String], wordToFind: String): Boolean = {
    if (dictionary == null || dictionary.length == 0) return false
    var left = 0
    var right = dictionary.length - 1
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (dictionary(mid).equals(wordToFind)) return true
      else {
        if (dictionary(mid).compareTo(wordToFind) > 0) right = mid - 1 else left = mid + 1
      }
    }
    false
  }

}

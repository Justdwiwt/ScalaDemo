package leetCode._900

object Solution_805 {
  def splitArraySameAverage(nums: Array[Int]): Boolean = {
    val n = nums.length
    if (n < 2) return false
    if (n == 2) return nums(0) == nums(1)
    val sum = nums.sum
    val average = sum / n.toDouble
    val ListP = new scala.collection.mutable.ListBuffer[Double]
    val ListM = new scala.collection.mutable.ListBuffer[Double]
    nums.indices.foreach(i => {
      val a = nums(i)
      val newA = a - average
      if (newA == 0) return true
      if (newA > 0) {
        if (ListM.contains(newA))
          return true
        ListP += newA
      } else {
        if (ListP.contains(math.abs(newA)))
          return true
        ListM += math.abs(newA)
      }
    })
    val mSum = ListM.sum
    val mSumSet = new scala.collection.mutable.HashSet[Double]
    ListM.foreach(m => {
      val mSumSetTemp = new scala.collection.mutable.HashSet[Double]
      mSumSet.foreach(mm => mSumSetTemp += (m + mm))
      mSumSet ++= mSumSetTemp
      mSumSet += m
    })
    mSumSet -= mSum

    val pSumSet = new scala.collection.mutable.HashSet[Double]
    ListP.foreach(p => {
      val pSumSetTemp = new scala.collection.mutable.HashSet[Double]
      pSumSet.foreach(pp => {
        if (mSumSet.contains(p + pp))
          return true
        pSumSetTemp.add(p + pp)
      })
      pSumSet ++= pSumSetTemp
      if (mSumSet.contains(p))
        return true
      pSumSet.add(p)
    })
    pSumSet.foreach(ps => mSumSet.foreach(ms => if (math.abs(ps - ms) < 0.00000001) return true))
    false
  }
}

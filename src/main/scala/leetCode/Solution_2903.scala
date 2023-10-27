package leetCode

object Solution_2903 {
  def findIndices(nums: Array[Int], indexDifference: Int, valueDifference: Int): Array[Int] = {
    var mxIdx, mnIdx = 0
    (indexDifference until nums.length).foreach(j => {
      val i = j - indexDifference
      if (nums(i) > nums(mxIdx)) mxIdx = i
      else if (nums(i) < nums(mnIdx)) mnIdx = i
      if (nums(mxIdx) - nums(j) >= valueDifference) return Array(mxIdx, j)
      if (nums(j) - nums(mnIdx) >= valueDifference) return Array(mnIdx, j)
    })
    Array(-1, -1)
  }
}

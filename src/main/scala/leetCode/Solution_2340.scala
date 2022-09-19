package leetCode

object Solution_2340 {
  def minimumSwaps(nums: Array[Int]): Int = {
    var mn = 0
    var mx = 0
    nums.indices.drop(1).foreach(i => {
      if (nums(i) < nums(mn)) mn = i
      else if (nums(i) >= nums(mx)) mx = i
    })
    (mn - 0) + (nums.length - 1 - mx) - (if (mn > mx) 1 else 0)
  }
}

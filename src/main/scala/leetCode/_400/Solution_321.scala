package leetCode._400

object Solution_321 {
  def maxNumber(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
    val res = Array.ofDim[Int](k)
    (Math.max(0, k - nums2.length) to Math.min(k, nums1.length)).foreach(i => {
      val candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k)
      if (greater(candidate, 0, res, 0)) res.indices.foreach(j => res(j) = candidate(j))
    })
    res
  }

  private def merge(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
    val res = Array.ofDim[Int](k)
    var i = 0
    var j = 0
    res.indices.foreach(r => res(r) = if (greater(nums1, i, nums2, j)) {
      i += 1
      nums1(i - 1)
    } else {
      j += 1
      nums2(j - 1)
    })
    res
  }

  private def greater(nums1: Array[Int], i: Int, nums2: Array[Int], j: Int): Boolean = {
    var ii = i
    var jj = j
    while (ii < nums1.length && jj < nums2.length && nums1(ii) == nums2(jj)) {
      ii += 1
      jj += 1
    }
    jj == nums2.length || (ii < nums1.length && nums1(ii) > nums2(jj))
  }

  private def maxArray(nums: Array[Int], k: Int): Array[Int] = {
    val res = Array.ofDim[Int](k)
    var j = 0
    nums.indices.foreach(i => {
      while (nums.length - i + j > k && j > 0 && res(j - 1) < nums(i)) j -= 1
      if (j < k) {
        res(j) = nums(i)
        j += 1
      }
    })
    res
  }
}

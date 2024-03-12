package leetCode.offer

object Offer_51 {
  def reversePairs(nums: Array[Int]): Int = mergeSort(nums, 0, nums.length - 1)

  def mergeSort(nums: Array[Int], left: Int, right: Int): Int = {
    if (left >= right) return 0
    val mid = (left + right) >> 1
    mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right) + merge(nums, left, mid, right)
  }

  def merge(nums: Array[Int], left: Int, mid: Int, right: Int): Int = {
    var i = left
    var j = mid + 1
    var k = 0
    var cnt = 0
    val res = Array.fill(right - left + 1)(0)
    while (i <= mid && j <= right) {
      if (nums(i) > nums(j)) cnt += mid - i + 1
      if (nums(i) <= nums(j)) {
        res(k) = nums(i)
        i += 1
      } else {
        res(k) = nums(j)
        j += 1
      }
      k += 1
    }
    while (i <= mid) {
      res(k) = nums(i)
      k += 1
      i += 1
    }
    while (j <= right) {
      res(k) = nums(j)
      k += 1
      j += 1
    }
    res.indices.foreach(m => nums(left + m) = res(m))
    cnt
  }
}

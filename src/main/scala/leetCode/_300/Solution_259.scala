package leetCode._300

object Solution_259 {
  def threeSumSmaller(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) return 0
    var res = 0
    val sort = nums.sorted
    var sum = 0
    sort.indices.foreach(i => {
      var l = i + 1
      var r = sort.length - 1
      while (l < r) {
        sum = sort(i) + sort(l) + sort(r)
        if (sum < target) {
          res += (r - l)
          l += 1
        } else r -= 1
      }
    })
    res
  }
}

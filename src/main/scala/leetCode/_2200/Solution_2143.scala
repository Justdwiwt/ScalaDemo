package leetCode._2200

object Solution_2143 {
  def countSubranges(nums1: Array[Int], nums2: Array[Int]): Int = {
    val n = nums1.length
    val M = (1e9 + 7).toInt

    val (s1, s2) = nums1.zip(nums2).foldLeft((0, 0)) { case ((acc1, acc2), (num1, num2)) =>
      (acc1 + num1, acc2 + num2)
    }

    val base = s1.max(s2)
    val arr = Array.fill(n, 2 * base + 1)(0)
    arr.head(base + nums1.head) += 1
    arr.head(base - nums2.head) += 1

    val updatedArr = nums1.indices.drop(1).foldLeft(arr)((accArr, i) => {
      (0 to 2 * base).foreach(j => {
        if (nums1(i) + base == j) accArr(i)(j) += 1
        if (-nums2(i) + base == j) accArr(i)(j) += 1
        if (j - nums1(i) >= 0) accArr(i)(j) = (accArr(i)(j) % M + accArr(i - 1)(j - nums1(i)) % M) % M
        if (j + nums2(i) <= 2 * base) accArr(i)(j) = (accArr(i)(j) % M + accArr(i - 1)(j + nums2(i)) % M) % M
      })
      accArr
    })

    nums1.indices.foldLeft(0)((acc, i) => (acc % M + updatedArr(i)(base) % M) % M)
  }
}

package leetCode._3600

object Solution_3524 {
  def resultArray(nums: Array[Int], k: Int): Array[Long] = {
    val zero = Array.fill[Long](k)(0L)

    val (_, res) = nums.foldLeft((zero, zero)) { case ((f, acc), v) =>
      val nf = f.zipWithIndex.foldLeft(Array.fill[Long](k)(0L).updated(v % k, 1L)) {
        case (arr, (c, y)) =>
          if (c == 0) arr
          else {
            val idx = ((y.toLong * v.toLong) % k).toInt
            arr.updated(idx, arr(idx) + c)
          }
      }

      val updatedAcc = acc.indices.map(i => acc(i) + nf(i)).toArray
      (nf, updatedAcc)
    }

    res
  }
}

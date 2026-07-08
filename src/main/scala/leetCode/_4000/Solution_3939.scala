package leetCode._4000

object Solution_3939 {
  def countValidSubsets(parent: Array[Int], nums: Array[Int], k: Int): Int = {
    val MOD = 1000000007L
    val n = parent.length

    val g = Array.fill(n)(collection.mutable.ArrayBuffer[Int]())
    parent.indices.drop(1).foreach(i => g(parent(i)) += i)

    def dfs(x: Int): (Array[Long], Array[Long]) = {
      var f0 = Array.fill[Long](k)(0L)
      var f1 = Array.fill[Long](k)(0L)
      f0(0) = 1
      f1(nums(x) % k) = 1

      g(x).foreach(y => {
        val (fy0, fy1) = dfs(y)

        val nf0 = Array.fill[Long](k)(0L)
        (0 until k).foreach(i => {
          val v = (fy0(i) + fy1(i)) % MOD
          if (v != 0) (0 until k)
            .withFilter(f0(_) != 0)
            .foreach(j => {
              val s = (i + j) % k
              nf0(s) = (nf0(s) + v * f0(j)) % MOD
            })
        })

        val nf1 = Array.fill[Long](k)(0L)
        (0 until k)
          .withFilter(fy0(_) != 0)
          .foreach(i => {
            val v = fy0(i)
            (0 until k)
              .withFilter(f1(_) != 0)
              .foreach(j => {
                val s = (i + j) % k
                nf1(s) = (nf1(s) + v * f1(j)) % MOD
              })
          })

        f0 = nf0
        f1 = nf1
      })

      (f0, f1)
    }

    val (f0, f1) = dfs(0)
    ((f0(0) + f1(0) - 1 + MOD) % MOD).toInt
  }
}

package leetCode._3700

object Solution_3690 {
  def minSplitMerge(nums1: Array[Int], nums2: Array[Int]): Int = {
    if (nums1.sameElements(nums2)) return 0
    val n = nums1.length

    val mp = nums1.distinct.zipWithIndex.toMap

    def encode(arr: Array[Int]): Long = arr
      .zipWithIndex
      .foldLeft(0L) { case (acc, (x, i)) => acc | (mp(x).toLong << (i * 3)) }

    val start = encode(nums1)
    val target = encode(nums2)

    def mask(bits: Int): Long =
      if (bits == 0) 0L
      else (1L << bits) - 1

    def next(cur: Long): Iterable[Long] = (1 to n)
      .map { r => val v = cur & mask(r * 3); (r, v) }
      .flatMap { case (r, v) => (0 until r)
        .map { l => val sub = v >> (l * 3); (l, sub) }
        .map { case (l, sub) => val left = cur & mask(l * 3); (l, sub, left) }
        .map { case (l, sub, left) => val right = cur >> (r * 3); (l, sub, left, right) }
        .map { case (l, sub, left, right) => val b = left | (right << (l * 3)); (l, sub, left, right, b) }
        .flatMap { case (l, sub, left, right, b) => (0 to (n - r + l))
          .map(i => {
            val left2 = b & mask(i * 3)
            val mid = sub << (i * 3)
            val right2 = b >> (i * 3)
            left2 | mid | (right2 << ((i + r - l) * 3))
          })
        }
      }

    @scala.annotation.tailrec
    def bfs(step: Int, frontier: Set[Long], visited: Set[Long]): Int = {
      val generated = frontier.flatMap(next).filterNot(visited)

      if (generated.isEmpty) -1
      else if (generated.contains(target)) step
      else bfs(step + 1, generated, visited ++ generated)
    }

    bfs(1, Set(start), Set(start))
  }
}

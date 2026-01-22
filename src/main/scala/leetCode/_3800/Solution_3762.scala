package leetCode._3800

object Solution_3762 {
  final case class Node(l: Int, r: Int, lo: Node, ro: Node, cnt: Int, sum: Long) {
    def add(i: Int, v: Int): Node =
      if (l == r) copy(cnt = cnt + 1, sum = sum + v)
      else {
        val mid = (l + r) >>> 1
        if (i <= mid) {
          val nlo = lo.add(i, v)
          copy(lo = nlo, cnt = nlo.cnt + ro.cnt, sum = nlo.sum + ro.sum)
        } else {
          val nro = ro.add(i, v)
          copy(ro = nro, cnt = lo.cnt + nro.cnt, sum = lo.sum + nro.sum)
        }
      }

    def query(old: Node, k: Int): (Int, Int, Long) =
      if (l == r) (l, 0, 0L)
      else {
        val cntL = lo.cnt - old.lo.cnt
        if (k <= cntL) lo.query(old.lo, k)
        else {
          val (i, c, s) = ro.query(old.ro, k - cntL)
          val sumL = lo.sum - old.lo.sum
          (i, cntL + c, sumL + s)
        }
      }
  }

  object Node {
    def build(l: Int, r: Int): Node =
      if (l == r) Node(l, r, null, null, 0, 0L)
      else {
        val mid = (l + r) >>> 1
        val lo = build(l, mid)
        val ro = build(mid + 1, r)
        Node(l, r, lo, ro, 0, 0L)
      }
  }

  def minOperations(nums: Array[Int], k: Int, queries: Array[Array[Int]]): Array[Long] = {
    val n = nums.length

    val left = nums.indices.foldLeft(Array.fill(n)(0))((a, i) => {
      if (i > 0 && nums(i) % k == nums(i - 1) % k) a(i) = a(i - 1)
      else a(i) = i
      a
    })

    val sorted = nums.distinct.sorted
    val idx = sorted.zipWithIndex.toMap

    val trees = nums.foldLeft(Vector(Node.build(0, sorted.length - 1))) { case (ts, x) => ts :+ ts.last.add(idx(x), x) }

    queries.map(q => {
      val l = q.head
      val r0 = q(1)

      if (left(r0) > l) -1L
      else {
        val r = r0 + 1
        val size = r - l

        val (i, cntL, sumL) = trees(r).query(trees(l), size / 2 + 1)

        val median = sorted(i)
        val total = trees(r).sum - trees(l).sum

        val dist = median.toLong * cntL - sumL + (total - sumL - median.toLong * (size - cntL))

        dist / k
      }
    })
  }
}

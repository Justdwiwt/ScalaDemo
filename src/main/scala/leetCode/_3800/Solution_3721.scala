package leetCode._3800

object Solution_3721 {
  def longestBalanced(nums: Array[Int]): Int = {
    val n = nums.length
    val B = math.sqrt(n + 1).toInt / 2 + 1

    val sum = Array.fill(n + 1)(0)

    case class Block(l: Int, r: Int, var todo: Int, var pos: Map[Int, Int])

    def calcPos(l: Int, r: Int): Map[Int, Int] =
      (r - 1 to l by -1).map(j => sum(j) -> j).toMap

    val blocks = Array.tabulate(n / B + 2) { i =>
      val l = i * B
      val r = math.min(l + B, n + 1)
      Block(l, r, 0, calcPos(l, r))
    }

    def rebuild(b: Block, ql: Int, qr: Int, v: Int): Unit = {
      val Block(l, r, todo, _) = b
      (l until r).foreach(j => {
        sum(j) += todo
        if (ql <= j && j < qr) sum(j) += v
      })
      b.todo = 0
      b.pos = calcPos(l, r)
    }

    def rangeAdd(ql: Int, qr: Int, v: Int): Unit =
      blocks.foreach(b => {
        if (b.r <= ql || b.l >= qr) ()
        else if (ql <= b.l && b.r <= qr) b.todo += v
        else rebuild(b, ql, qr, v)
      })

    def findFirst(r: Int, v: Int): Int = blocks
      .iterator
      .takeWhile(_.l < r)
      .flatMap(b => {
        if (b.r <= r) b.pos.get(v - b.todo)
        else (b.l until r).find(sum(_) == v - b.todo)
      })
      .toSeq
      .headOption
      .getOrElse(n)

    val last = scala.collection.mutable.Map[Int, Int]().withDefaultValue(0)

    (1 to n).foldLeft(0)((ans, i) => {
      val x = nums(i - 1)
      val v = (x & 1) * 2 - 1

      val j = last(x)
      if (j == 0) rangeAdd(i, n + 1, v)
      else rangeAdd(j, i, -v)
      last(x) = i

      val b = blocks(i / B)
      val s = sum(i) + b.todo

      math.max(ans, i - findFirst(i - ans, s))
    })
  }
}

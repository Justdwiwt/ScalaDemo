package leetCode._3400

object Solution_3327 {
  def findAnswer(parent: Array[Int], s: String): Array[Boolean] = {
    val n = parent.length
    val g = Array.fill(n)(scala.collection.mutable.ListBuffer[Int]())

    parent.indices.drop(1).foreach(i => g(parent(i)) += i)

    val dfsStr = new Array[Char](n)
    val nodes = Array.fill(n)(Array(0, 0))
    var time: Int = 0

    def dfs(x: Int): Unit = {
      nodes(x)(0) = time
      g(x).foreach(dfs)
      dfsStr(time) = s(x)
      time += 1
      nodes(x)(1) = time
    }

    dfs(0)

    val t = new Array[Char](n * 2 + 3)
    t(0) = '^'
    parent.indices.foreach(i => t(i * 2 + 2) = dfsStr(i))
    t(n * 2 + 2) = '$'

    val halfLen = Array.fill(t.length - 2)(0)
    halfLen(1) = 1
    var boxM = 0
    var boxR = 0

    halfLen.indices.drop(2).foreach(i => {
      var hl = if (i < boxR) halfLen(boxM * 2 - i).min(boxR - i) else 1
      while (t(i - hl) == t(i + hl)) {
        hl += 1
        boxM = i
        boxR = i + hl
      }
      halfLen(i) = hl
    })

    Array.tabulate(n)(i => {
      val l = nodes(i).head
      val r = nodes(i)(1)
      halfLen(l + r + 1) > r - l
    })
  }
}

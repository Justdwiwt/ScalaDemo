package leetCode._4000

object Solution_3985 {
  def getSum(nums: Array[Int]): Long = {
    val t = Array(-2) ++ nums.flatMap(Array(-1, _)) ++ Array(-1, -3)

    val halfLen = Array.fill(t.length - 2)(0)
    halfLen(1) = 1

    var boxM = 0
    var boxR = 0

    (2 until halfLen.length).foreach(i => {
      var hl = if (i < boxR) halfLen(boxM * 2 - i).min(boxR - i) else 1

      while (t(i - hl) == t(i + hl)) {
        hl += 1
        boxM = i
        boxR = i + hl
      }

      halfLen(i) = hl
    })

    val pre = Array.ofDim[Long](nums.length + 1)

    nums.indices.foreach(i => pre(i + 1) = pre(i) + nums(i))

    var ans = 0L

    (2 until halfLen.length).foreach(i => {
      val hl = halfLen(i)

      val sum = pre((i + hl) / 2 - 1) - pre((i - hl) / 2)

      ans = ans.max(sum)
    })

    ans
  }
}

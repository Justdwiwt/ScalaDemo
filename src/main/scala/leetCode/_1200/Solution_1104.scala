package leetCode._1200

object Solution_1104 {
  def pathInZigZagTree(label: Int): List[Int] = {
    var t = label
    var num = label
    num |= num >>> 1
    num |= num >>> 2
    num |= num >>> 4
    num |= num >>> 8
    num |= num >>> 16
    var other = num + ((num + 1) >>> 1) - label
    var res = List[Int]()
    while (t != 1) {
      res :+= t
      t >>>= 1
      other >>>= 1
      t ^= other
      other ^= t
      t ^= other
    }
    res :+= t
    res.reverse
  }
}

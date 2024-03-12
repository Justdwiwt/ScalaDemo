package leetCode._2300

object Solution_2300 {
  def successfulPairs(spells: Array[Int], potions: Array[Int], success: Long): Array[Int] = {
    val sorted = potions.sorted

    @scala.annotation.tailrec
    def search(l: Int = 0, r: Int, spell: Int): Int =
      if (l >= r) sorted.length - l
      else {
        val mid = (l + r) >>> 1
        if (spell.toLong * sorted(mid) >= success) search(l, mid, spell)
        else search(mid + 1, r, spell)
      }

    spells.map(search(l = 0, r = sorted.length, _))
  }
}

package leetCode

object Solution_848 {
  def shiftingLetters(S: String, shifts: Array[Int]): String = {
    val s = new StringBuilder
    s.append(S)
    (shifts.length - 2 to 0 by -1).foreach(i => shifts(i) = (shifts(i) + shifts(i + 1)) % 26)
    shifts.indices.foreach(i => s(i) = ((s(i) - 'a' + shifts(i)) % 26 + 'a').toChar)
    s.toString
  }
}

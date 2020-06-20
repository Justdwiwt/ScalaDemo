package leetCode

object Solution_937 {
  def reorderLogFiles(logs: Array[String]): Array[String] = {
    logs.sorted((o1: String, o2: String) => {
      val s1 = o1.split(" ", 2)
      val s2 = o2.split(" ", 2)
      val f1 = Character.isDigit(s1(1)(0))
      val f2 = Character.isDigit(s2(1)(0))
      if (!f1 && !f2) if (s1(1).compareTo(s2(1)) != 0) s1(1).compareTo(s2(1))
      else s1(0).compareTo(s2(0))
      else if (f1) if (f2) 0
      else 1
      else -1
    })
  }
}

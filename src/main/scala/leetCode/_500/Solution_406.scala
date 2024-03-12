package leetCode._500

object Solution_406 {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    def f(sorted: Array[Array[Int]], value: Array[Array[Int]]): Array[Array[Int]] = sorted.headOption.map((person: Array[Int]) => {
      val empty = value.zipWithIndex.collect({ case (null, index) => index })
      value(empty(person(1))) = person
      f(sorted.drop(1), value)
    }).getOrElse(value)

    f(sorted = people.sortWith((p1, p2) => {
      if (p1(0) < p2(0)) true
      else if (p1(0) == p2(0) && p1(1) > p2(1)) true
      else false
    }), value = new Array[Array[Int]](people.length))
  }
}

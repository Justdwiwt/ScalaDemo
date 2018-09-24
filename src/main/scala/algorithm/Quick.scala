package algorithm

class Quick {

  def qsort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case ::(pivot, t) => qsort(t.filter(_ <= pivot)) ++ List(pivot) ++ qsort(t.filter(_ > pivot))
  }

  println(qsort(List(1, 32, 4, 5, 2, 3, 5, 6, 7, 33)))

}

package leetCode

import scala.reflect.ClassTag

object Solution_1252 {

  implicit class A[T: ClassTag](a: Array[T]) {
    def patchElement(idx: Int, modifier: T => T): Array[T] = a.zipWithIndex.map(x => if (x._2 == idx) modifier(x._1) else x._1)
  }

  def oddCells(n: Int, m: Int, arr: Array[Array[Int]]): Int = {
    val cells = Array.fill(n)(Array.fill(m)(0))
    arr./:(cells)((mat, idx) => {
      mat.patchElement(idx.head, _.map(_ + 1)).map(_.patchElement(idx(1), _ + 1))
    }).map(_.count(_ % 2 == 1)).sum
  }

}

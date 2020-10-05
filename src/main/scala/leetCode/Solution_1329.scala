package leetCode

import scala.collection.mutable

object Solution_1329 {
  def diagonalSort(mat: Array[Array[Int]]): Array[Array[Int]] = {
    if (mat.isEmpty || mat(0).isEmpty) return mat
    val (borderLength, height) = (mat.length + mat(0).length - 1, mat(0).length - 1)
    val arr = Array.fill(borderLength)(mutable.PriorityQueue.empty[Int].reverse)
    mat.indices.foreach(i => mat(i).indices.foreach(j => arr(i - j + height) += mat(i)(j)))
    val res = mat.clone()
    mat.indices.foreach(i => mat(i).indices.foreach(j => res(i)(j) = arr(i - j + height).dequeue()))
    res
  }
}

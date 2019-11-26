package algorithm

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * 递归
  */
object Recursive {

  /**
    * 四种面额的纸币
    */
  val rewards = Array(1, 2, 5, 10)

  /**
    * 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合
    *
    * @param totalReward 奖赏总金额
    * @param result      保存当前的解
    */
  def get(totalReward: Long, result: ArrayBuffer[Long]): Unit = totalReward match {
    case 0 => println(result)
    case x if x < 0 =>
    case _ => rewards.indices.foreach(i => {
      val newRes = result.clone()
      newRes.append(rewards(i))
      get(totalReward - rewards(i), newRes)
    })
  }

  /**
    * 使用函数的递归（嵌套）调用，实现归并排序（从小到大）
    *
    * @param toSort 等待排序的数组
    * @return 排序后的数组
    */
  def mergeSort(toSort: Array[Int]): Array[Int] = toSort match {
    case null => Array()
    case x if x.length == 1 => toSort
    case _ =>
      val mid = toSort.length / 2
      var left = util.Arrays.copyOfRange(toSort, 0, mid)
      var right = util.Arrays.copyOfRange(toSort, mid, toSort.length)
      left = mergeSort(left)
      right = mergeSort(right)
      merge(left, right)
  }

  /**
    * 合并两个已经排序完毕的数组（从小到大）
    *
    * @param a 第一个数组
    * @param b 第二个数组
    * @return 合并后的数组
    */
  def merge(a: Array[Int], b: Array[Int]): Array[Int] = {
    var A = a
    var B = b
    if (a == null) A = Array()
    if (b == null) B = Array()
    val merged = Array.ofDim[Int](A.length + B.length)
    var mi = 0
    var ai = 0
    var bi = 0
    while (ai < A.length && bi < B.length) {
      if (A(ai) <= B(bi)) {
        merged(mi) = A(ai)
        ai += 1
      } else {
        merged(mi) = B(bi)
        bi += 1
      }
      mi += 1
    }
    if (ai < A.length) (ai until A.length).foreach(i => {
      merged(mi) = A(i)
      mi += 1
    })
    else (bi until B.length).foreach(i => {
      merged(mi) = B(i)
      mi += 1
    })
    merged
  }

}

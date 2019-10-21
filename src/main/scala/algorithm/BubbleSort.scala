package algorithm

object BubbleSort {

  def bubbleSort[A](list: List[A])(implicit ev$1: A => Ordered[A]): List[A] = {

    /**
      * @param unSorteds   待排序列表
      * @param remains     已遍历未冒出元素列表
      * @param accOrdereds 已冒出有序列表
      * @return 有序列表
      */
    @scala.annotation.tailrec
    def bubble(unSorteds: List[A], remains: List[A], accOrdereds: List[A]): List[A] = unSorteds match {
      case h1 :: h2 :: t =>
        if (h1 > h2) bubble(h1 :: t, h2 :: remains, accOrdereds)
        else bubble(h2 :: t, h1 :: remains, accOrdereds)
      case h1 :: Nil =>
        if (remains.isEmpty) h1 :: accOrdereds
        else bubble(remains, Nil, h1 :: accOrdereds)
    }

    bubble(list, Nil, Nil)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1, 13, 7, 5, 8, 9, 20, 43, 11, 8)
    println(bubbleSort(list))
  }

}

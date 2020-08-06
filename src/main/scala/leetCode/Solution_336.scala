package leetCode

object Solution_336 {

  class Node {
    val next: Array[Int] = Array.fill(26)(0)
    var flag: Int = -1
  }

  private var trie = Array.empty[Node]

  def palindromePairs(words: Array[String]): List[List[Int]] = {
    trie :+= new Node
    words.indices.foreach(i => add(words(i), i))
    var res = List.empty[List[Int]]
    words.indices.foreach(i => words(i).indices.foreach(j => {
      if (isPalindrome(words(i), j, words(i).length - 1)) {
        val rId = find(words(i), 0, j - 1)
        if (rId != -1 && rId != i) res ::= i :: rId :: Nil
      }
      if (j != 0 && isPalindrome(words(i), 0, j - 1)) {
        val lId = find(words(i), j, words(i).length - 1)
        if (lId != -1 && lId != i) res ::= lId :: i :: Nil
      }
    }))
    res
  }

  def add(key: String, id: Int): Unit = {
    var idx = 0
    key.indices.foreach(i => {
      val c = key(i) - 'a'
      if (trie(idx).next(c) == 0) {
        trie :+= new Node
        trie(idx).next(c) = trie.length - 1
      }
      idx = trie(idx).next(c)
    })
    trie(idx).flag = id
  }

  def isPalindrome(s: String, left: Int, right: Int): Boolean = {
    var l = left
    var r = right
    while (l <= r) {
      if (s(l) != s(r)) return false
      l += 1
      r -= 1
    }
    true
  }

  def find(s: String, left: Int, right: Int): Int = {
    var idx = 0
    (left to right).reverse.foreach(i => {
      val c = s(i) - 'a'
      if (trie(idx).next(c) == 0) return -1
      idx = trie(idx).next(c)
    })
    trie(idx).flag
  }

}

package codinginterview.tree

class BinaryTree<K, V>(
    private val comparator: Comparator<in K>?
) {
    var root: Node<K, V>? = null
        private set
    var size = 0
        private set

    data class Node<K, V>(
        var key: K, // 키 값
        var data: V, // 데이터 값
        var left: Node<K, V>?, // 왼쪽 포인터
        var right: Node<K, V>?, // 오른쪽 포인터
    ) {
        fun print() {
            println(data)
        }
    }

    fun search(key: K): V? {
        var p: Node<K, V>? = root

        while (true) {
            if (p == null) {
                return null
            }
            val cond = comp(key, p.key)
            p = if (cond == 0) {
                return p.data
            } else if (cond < 0) {
                p.left
            } else {
                p.right
            }
        }
    }

    fun add(key: K, data: V) {
        if (root == null) {
            root = Node(key, data, null, null)
            size++
        } else {
            addNode(root!!, key, data)
        }
    }

    fun remove(key: K): Boolean {
        var p: Node<K, V>? = root
        var parent: Node<K, V>? = root
        var isLeftChild = true

        while (true) {
            if (p == null) {
                return false
            }
            val cond = comp(key, p.key)
            if (cond == 0) {
                break
            } else {
                parent = p
                if (cond < 0) {
                    isLeftChild = true
                    p = p.left
                } else {
                    isLeftChild = false
                    p = p.right
                }
            }
        }

        if (p!!.left == null) {
            if (p == root) {
                root = p.right
            } else if (isLeftChild) {
                parent!!.left = p.right
            } else {
                parent!!.right = p.right
            }
        } else if (p.right == null) {
            if (p == root) {
                root = p.left
            } else if (isLeftChild) {
                parent!!.left = p.left
            } else {
                parent!!.right = p.left
            }
        } else { // p.left != null && p.right != null
            parent = p

            var alternateNode = p.left
            isLeftChild = true
            while (alternateNode!!.right != null) {
                parent = alternateNode
                alternateNode = alternateNode.right
                isLeftChild = false
            }
            p.key = alternateNode.key
            p.data = alternateNode.data

            if (isLeftChild) {
                parent!!.left =  alternateNode.left
            } else {
                parent!!.right = alternateNode.left
            }
        }
        size--
        return true
    }

    private fun addNode(node: Node<K, V>, key: K, data: V) {
        val cond = comp(key, node.key)
        if (cond == 0) {
            return
        } else if (cond < 0) {
            if (node.left == null) {
                node.left = Node(key, data, null, null)
                size++
            } else {
                addNode(node.left!!, key, data)
            }
        } else {
            if (node.right == null) {
                node.right = Node(key, data, null, null)
                size++
            } else {
                addNode(node.right!!, key, data)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun comp(key1: K, key2: K): Int {
        return comparator?.compare(key1, key2) ?: (key1 as Comparable<K>).compareTo(key2)
    }

}
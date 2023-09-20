package codinginterview.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BinaryTreeTest {

    private lateinit var binaryTree: BinaryTree<Int, String>

    @BeforeEach
    fun init() {
        binaryTree = BinaryTree(null)
        binaryTree.add(4, "Four")
        binaryTree.add(5, "Five")
        binaryTree.add(2, "Two")
        binaryTree.add(1, "One")
        binaryTree.add(3, "Three")
    }

    @Test
    fun searchWithExistedNode() {
        assertEquals("Four", binaryTree.search(4))
    }

    @Test
    fun searchWithNotExistedNode() {
        assertNull(binaryTree.search(6))
    }

    @Test
    fun addNodeWithExistedNode() {
        binaryTree.add(0, "Zero")
        assertEquals("Zero", binaryTree.search(0))
        assertEquals(6, binaryTree.size)
    }

    @Test
    fun addNodeWithNotExistedNode() {
        binaryTree.add(1, "One")
        assertEquals(5, binaryTree.size)
    }

    @Test
    fun removeWithExistedNode() {
        val result = binaryTree.remove(5)

        assertTrue(result)
        assertNull(binaryTree.search(5))
        assertEquals(4, binaryTree.size)
    }

    @Test
    fun removeWithNotExistedNode() {
        val result = binaryTree.remove(6)

        assertFalse(result)
        assertEquals(5, binaryTree.size)
    }
}
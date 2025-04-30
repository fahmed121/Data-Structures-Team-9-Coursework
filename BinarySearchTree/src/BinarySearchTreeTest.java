package BinarySearchTree.src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree tree;

    @BeforeEach
    public void setUp() {
        tree = new BinarySearchTree();
    }

    @Test
    public void testInsertPostCodes() {
        tree.insert("AB12");
        tree.insert("AA01");
        tree.insert("NA01");
        tree.insert("AD56");
        tree.insert("AA02");
        System.out.println("display :");
        tree.displayTreeStructure();
        System.out.println("ordered display :");
        tree.inOrder();
        assertEquals(5, tree.count());
    }

    @Test
    public void testInsertDuplicatePostcode() {
        tree.insert("AB12");
        tree.insert("AB12");
        assertEquals(1, tree.count(), "Duplicate postcode should not increase count.");
    }

    @Test
    public void testSearchExistingPostcode() {
        tree.insert("AB12");
        assertTrue(tree.search("AB12"));
        assertFalse(tree.search("AB1200"));
    }

    @Test
    public void testDeleteLeafNode() {
        tree.insert("AB12");
        tree.insert("AA01");
        tree.insert("AC03");
        tree.delete("AC03");
        assertFalse(tree.search("AC03"));
        assertEquals(2, tree.count(), "Count should be 2 after deleting one node.");
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        tree.insert("AB12");
        tree.insert("AA01");
        tree.insert("AB11");
        tree.delete("AA01");
        assertFalse(tree.search("AA01"), "Postcode AA01 should be deleted.");
        assertTrue(tree.search("AB11"), "Child postcode AB11 should still exist.");
        assertEquals(2, tree.count(), "Count should be 2 after deletion.");
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        tree.insert("AB12");
        tree.insert("AA01");
        tree.insert("AC03");

        tree.delete("AB12"); // Root with two children
        assertFalse(tree.search("AB12"), "Root postcode AB12 should be deleted.");
        assertEquals(2, tree.count(), "Count should be 2 after deleting root.");
    }

    @Test
    public void testDeleteNonExistingPostcode() {
        tree.insert("AB12");
        tree.delete("ZZ99"); // Deleting non-existing node

        assertEquals(1, tree.count(), "Count should remain same when deleting non-existing postcode.");
    }

    @Test
    public void testInOrderTraversalSorted() {
        tree.insert("AB12");
        tree.insert("AA01");
        tree.insert("AC03");

        // Capture output from inOrder()
        System.out.println("In-order Traversal Output:");
        tree.inOrder();
        // Manual visual check because original code prints directly.
        // Ideally, modify inOrder() to return a list for better testing.
    }

    @Test
    public void testCountEmptyTree() {
        assertEquals(0, tree.count(), "Empty tree should have count 0.");
    }
}

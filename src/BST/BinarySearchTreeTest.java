package BST;
import BST.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        BST bst = new BST();

        Album album1 = new Album(1, Arrays.asList("Artist1"), "Album 1", 10);
        Album album2 = new Album(2, Arrays.asList("Artist2", "Artist3"), "Album 2", 15);
        Album album3 = new Album(3, Arrays.asList("Artist4"), "Album 3", 5);

        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);

        List<Album> inOrderTraversal = bst.getInOrderTraversal();

        assertEquals(album1, inOrderTraversal.get(0));
        assertEquals(album2, inOrderTraversal.get(1));
        assertEquals(album3, inOrderTraversal.get(2));
    }

}
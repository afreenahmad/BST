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

    @Test
    public void testDelete() {
        BST bst = new BST();

        Album album1 = new Album(1, Arrays.asList("Artist1"), "Album 1", 10);
        Album album2 = new Album(2, Arrays.asList("Artist2", "Artist3"), "Album 2", 15);
        Album album3 = new Album(3, Arrays.asList("Artist4"), "Album 3", 5);

        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);

        assertEquals(album1, bst.delete(album1).data);

        List<Album> inOrderTraversalAfterDeletion = bst.getInOrderTraversal();
        assertEquals(album2, inOrderTraversalAfterDeletion.get(0));
        assertEquals(album3, inOrderTraversalAfterDeletion.get(1));

        assertThrows(IllegalArgumentException.class, () -> bst.delete(album1));

        Album nonExistentAlbum = new Album(4, Arrays.asList("Artist5"), "Album 4", 8);
        assertThrows(IllegalArgumentException.class, () -> bst.delete(nonExistentAlbum));
    }
    @Test
    public void testContains() {
        BST bst = new BST();

        Album album1 = new Album(1, Arrays.asList("Artist1"), "Album 1", 10);
        Album album2 = new Album(2, Arrays.asList("Artist2", "Artist3"), "Album 2", 15);
        Album album3 = new Album(3, Arrays.asList("Artist4"), "Album 3", 5);

        bst.insert(album1);
        bst.insert(album2);

        assertTrue(bst.contains(album1));
        assertTrue(bst.contains(album2));
        assertFalse(bst.contains(album3));

        Album duplicateAlbum1 = new Album(1, Arrays.asList("Artist1"), "Album 1", 10);
        Album duplicateAlbum2 = new Album(2, Arrays.asList("Artist2", "Artist3"), "Album 2", 15);

        assertTrue(bst.contains(duplicateAlbum1));
        assertTrue(bst.contains(duplicateAlbum2));
    }
     @Test
    public void testToString() {
        BST bst = new BST();

        Album album1 = new Album(100, Arrays.asList("Artist1"), "Album 1", 10);
        Album album2 = new Album(50, Arrays.asList("Artist2", "Artist3"), "Album 2", 15);
        Album album3 = new Album(150, Arrays.asList("Artist4"), "Album 3", 5);
        Album album4 = new Album(25, Arrays.asList("Artist5"), "Album 4", 8);
        Album album5 = new Album(125, Arrays.asList("Artist6"), "Album 5", 12);
        Album album6 = new Album(180, Arrays.asList("Artist7"), "Album 6", 18);

        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);
        bst.insert(album4);
        bst.insert(album5);
        bst.insert(album6);

        String expectedOutput = "100, 50, 25, N, N, N, N, N, N, 150, 125, N, N, N, N, 180, N, N, N, N,  ";
        String actualOutput = bst.toString();

        assertEquals(expectedOutput, actualOutput);
    }


}
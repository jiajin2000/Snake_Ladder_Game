package adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {

  private Node root;

  public BinarySearchTree() {
    root = null;
  }

  public BinarySearchTree(T rootData) {
    root = new Node(rootData);
  }

  public boolean contains(T entry) {
    return getEntry(entry) != null;
  }

  public T getEntry(T entry) {
    return findEntry(root, entry);
  }

  private T findEntry(Node rootNode, T entry) {
    T result = null;

    if (rootNode != null) {
      T rootEntry = rootNode.data;

      if (entry.equals(rootEntry)) {
        result = rootEntry;
      } else if (entry.compareTo(rootEntry) < 0) {
        result = findEntry(rootNode.left, entry);
      } else {
        result = findEntry(rootNode.right, entry);
      }
    }
    return result;
  }

  public T add(T newEntry) {
    T result = null;

    if (isEmpty()) {
      root = new Node(newEntry);
    } else {
      result = addEntry(root, newEntry);
    }

    return result;
  }


  private T addEntry(Node rootNode, T newEntry) {
    T result = null;
    int comparison = newEntry.compareTo(rootNode.data);

    if (comparison == 0) {						
      result = rootNode.data;
      rootNode.data = newEntry;
    } else if (comparison < 0) {				
      if (rootNode.left != null) {
        result = addEntry(rootNode.left, newEntry);
      } else {
        rootNode.left = new Node(newEntry);
      }
    } else {														
      if (rootNode.right != null) {
        result = addEntry(rootNode.right, newEntry);
      } else {
        rootNode.right = new Node(newEntry);
      }
    }
    return result;
  }
  


  public T remove(T entry) {
    ReturnObject oldEntry = new ReturnObject(null);

    Node newRoot = removeEntry(root, entry, oldEntry);

    root = newRoot;

    return oldEntry.get();
  }


  private Node removeEntry(Node rootNode, T entry, ReturnObject oldEntry) {
    if (rootNode != null) {
      T rootData = rootNode.data;
      int comparison = entry.compareTo(rootData);

      if (comparison == 0) {     
        oldEntry.set(rootData);
        rootNode = removeFromRoot(rootNode);
      } else if (comparison < 0) { 
        Node leftChild = rootNode.left;
        Node subtreeRoot = removeEntry(leftChild, entry, oldEntry);
        rootNode.left = subtreeRoot;
      } else {                 
        Node rightChild = rootNode.right;
        rootNode.right = removeEntry(rightChild, entry, oldEntry);
      }
    }

    return rootNode;
  }


  private Node removeFromRoot(Node rootNode) {
  
    if (rootNode.left != null && rootNode.right != null) {
    
      Node leftSubtreeRoot = rootNode.left;
      Node largestNode = findLargest(leftSubtreeRoot);

     
      rootNode.data = largestNode.data;

     
      rootNode.left = removeLargest(leftSubtreeRoot);
    } 
    
    else if (rootNode.right != null) {
      rootNode = rootNode.right;
    } else {
      rootNode = rootNode.left;
    }

	
    return rootNode;
  }

  
  private Node findLargest(Node rootNode) {
    if (rootNode.right != null) {
      rootNode = findLargest(rootNode.right);
    }

    return rootNode;
  }


  private Node removeLargest(Node rootNode) {
    if (rootNode.right != null) {
      Node rightChild = rootNode.right;
      Node root = removeLargest(rightChild);
      rootNode.right = root;
    } else {
      rootNode = rootNode.left;
    }

    return rootNode;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void clear() {
    root = null;
  }

  @Override
  public Iterator<T> getInorderIterator() {
    return new InorderIterator();
  }

  @Override
  public Iterator<T> getPreorderIterator() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator<T> getPostorderIterator() {
    throw new UnsupportedOperationException();
  }



  private class ReturnObject {

    private T item;

    private ReturnObject(T entry) {
      item = entry;
    }

    public T get() {
      return item;
    }

    public void set(T entry) {
      item = entry;
    }
  }

  private class Node {

    private T data;
    private Node left;
    private Node right;

    private Node() {
      this(null);
    }

    private Node(T dataPortion) {
      this(dataPortion, null, null);
    }

    private Node(T data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    private boolean isLeaf() {
      return (left == null) && (right == null);
    }

  }

  private class InorderIterator implements Iterator<T> {

    private CircularArrQueueInterface<T> queue = new CircularArrQueue<T>();

    public InorderIterator() {
      inorder(root);
    }

    private void inorder(Node treeNode) {
      if (treeNode != null) {
        inorder(treeNode.left);
        queue.enqueue(treeNode.data);
        inorder(treeNode.right);
      }
    }

    public boolean hasNext() {
      return !queue.isEmpty();
    }

    public T next() {
      if (!queue.isEmpty()) {
        return queue.dequeue();
      } else {
        throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
      }
    }

  }

}

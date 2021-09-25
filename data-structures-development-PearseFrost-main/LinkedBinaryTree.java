import javax.swing.text.Position;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    //---------------- nested Node class ----------------
    protected static class Node<E> implements Position<E> {
        private E element;//Element stored ay certain node
        private Node<E> parent;//Parent node
        private Node<E> left;//Left node
        private Node<E> right;//Right node

        //Constructs a node with the given element and neighbors
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        //Gets element at node
        public E getElement() {
            return element;
        }
        //Gets parent node
        public Node<E> getParent() {
            return parent;
        }
        //Gets left node
        public Node<E> getLeft() {
            return left;
        }
        //Gets right node
        public Node<E> getRight() {
            return right;
        }
        //Sets Element at certain node
        public void setElement(E e) {
            element = e;
        }
        //Sets parent Node
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }
        //Sets left node
        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }
        //Sets right node
        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
        //Method included in Position interface must be overrided
        @Override
        public int getOffset() {
            return 0;
        }
    }
    //Method to create a node which stores a certain element
    protected Node<E> createNode(E e, Node<E> parent,
                                 Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }
    //Standard instance variables for binary tree
    protected Node<E> root = null;
    private int size = 0;
    //Constructor
    public LinkedBinaryTree() {
    }
    //Makes sure position is available and returns it as a node
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    //Returns the size of tree ie how many nodes it has
    public int size() {
        return size;
    }

    // Returns the root Position of the tree
    public Position<E> root() {
        return root;
    }
    //Returns the position of the parent node
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    //Returns the position of the right node
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    //Returns the position of the right node
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }
}


package adt.rbtree;

import adt.bst.BSTImpl;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}

	protected int blackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	protected boolean verifyProperties() {
		boolean resp = verifyNodesColour() && verifyNILNodeColour()
				&& verifyRootColour() && verifyChildrenOfRedNodes()
				&& verifyBlackHeight();

		return resp;
	}

	/**
	 * The colour of each node of a RB tree is black or red. This is guaranteed
	 * by the type Colour.
	 */
	private boolean verifyNodesColour() {
		return true; // already implemented
	}

	/**
	 * The colour of the root must be black.
	 */
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK; // already
																// implemented
	}

	/**
	 * This is guaranteed by the constructor.
	 */
	private boolean verifyNILNodeColour() {
		return true; // already implemented
	}

	/**
	 * Verifies the property for all RED nodes: the children of a red node must
	 * be BLACK.
	 */
	private boolean verifyChildrenOfRedNodes() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * Verifies the black-height property from the root.
	 */
	private boolean verifyBlackHeight() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void insert(T value) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public RBNode<T>[] rbPreOrder() {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// FIXUP methods
	protected void fixUpCase1(RBNode<T> node) {
		if (node.equals(root))
			node.setColour(Colour.BLACK);
		else
			fixUpCase2(node);
	}

	protected void fixUpCase2(RBNode<T> node) {
		RBNode parent = (RBNode) node.getParent();
		if (!parent.getColour().equals(Colour.BLACK))
			fixUpCase3(node);
	}

	protected void fixUpCase3(RBNode<T> node) {
		RBNode parent = (RBNode) node.getParent();
		RBNode grandfather = (RBNode) parent.getParent();
		RBNode uncle = getUncle(node, grandfather);

		if (uncle.getColour().equals(Colour.RED) && uncle != null){
			parent.setColour(Colour.BLACK);
			uncle.setColour(Colour.BLACK);
			grandfather.setColour(Colour.BLACK);
			fixUpCase1(node);
		} else {
			fixUpCase4(node);
		}
	}

	protected void fixUpCase4(RBNode<T> node) {
		RBNode parent = (RBNode) node.getParent();
		if(isRightChild(node) && !isRightChild(parent)) {
			Util.leftRotation(parent);

		}
	}

	protected void fixUpCase5(RBNode<T> node) {
		// TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}


	private boolean isRightChild(RBNode<T> node) {
		if (node.getParent().getRight().equals(node))
			return true;
		return false;
	}

	private RBNode getUncle(RBNode grandfather, RBNode node) {
		if(isRightChild(node))
			return (RBNode) grandfather.getLeft();
		return (RBNode) grandfather.getRight();
	}

}

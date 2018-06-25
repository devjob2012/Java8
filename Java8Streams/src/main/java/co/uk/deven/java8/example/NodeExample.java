package co.uk.deven.java8.example;

import java.util.ArrayList;
import java.util.List;

public class NodeExample<T> {
	private List<NodeExample<T>> children = new ArrayList<NodeExample<T>>();
	private NodeExample<T> parent = null;
	private T data = null;

	public NodeExample(T data) {
		this.data = data;
	}

	public NodeExample(T data, NodeExample<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	public List<NodeExample<T>> getChildren() {
		return children;
	}

	public void setParent(NodeExample<T> parent) {
		// parent.addChild(this);
		this.parent = parent;
	}

	public NodeExample<T> getParent() {
		return this.parent;
	}

	public void addChild(T data) {
		NodeExample<T> child = new NodeExample<T>(data);
		child.setParent(this);
		this.children.add(child);
	}

	public void addChild(NodeExample<T> child) {
		child.setParent(this);
		this.children.add(child);
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}

	public boolean isLeaf() {
		return this.children.size() == 0;
	}

	public void removeParent() {
		this.parent = null;
	}

	public NodeExample<T> findParent(T data) {
		return parent;
	}
}